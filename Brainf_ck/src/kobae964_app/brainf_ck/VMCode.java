package kobae964_app.brainf_ck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VMCode {
	List<Byte> code;
	int start;
	int end;
	VMCode()
	{
		code=new ArrayList<Byte>();
		start=0;
		end=0;
	}
	/**
	 * loopMemo contains the information to which point '['/']' skip
	 * @param program
	 * @param start
	 * @param end
	 * @param loopMemo
	 * @return
	 */
	public static VMCode compile(byte[] program,int start,int end,LoopMemo loopMemo)
	{
		VMCode code=new VMCode();
		Map<Integer,Integer> bfVmMap=new HashMap<Integer, Integer>();
		code.start=start;
		code.end=end;
		int mode=-1;
		int app=0;
		for(int i=start;i<end;i++)
		{
			switch(program[i]&0xff)
			{
			case '+':
				if(mode==MEMADD)
				{
					app++;
				}
				else
				{
					code.putCode(mode, app);
					mode=MEMADD;
					app=1;
				}
				break;
			case '-':
				if(mode==MEMADD)
				{
					app--;
				}
				else
				{
					code.putCode(mode, app);
					mode=MEMADD;
					app=-1;
				}
				break;
			case '<':
				if(mode==PTRMOV_W)
				{
					app--;
				}
				else
				{
					code.putCode(mode,app);
					mode=PTRMOV_W;
					app=-1;
				}
				break;
			case '>':
				if(mode==PTRMOV_W)
				{
					app++;
				}
				else
				{
					code.putCode(mode,app);
					mode=PTRMOV_W;
					app=1;
				}
				break;
			case '.':
				code.putCode(mode,app);
				mode=PUTCHAR;
				app=1;
				break;
			case ',':
				code.putCode(mode,app);
				mode=GETCHAR;
				app=1;
				break;
			case '[':
				code.putCode(mode, app);
				int corBra=loopMemo.searchBracket(i,start,end);
				bfVmMap.put(i, code.code.size());
				VMCode sub=VMCode.compile(program, i+1, corBra, loopMemo);
				//write 05 ?? ?? //condjump
				int dist1=sub.size();
				int dist2=dist1+6;
				code.putCode(CONDJMP_W,dist1);
				code.code.addAll(sub.code);
				code.putCode(JMP_W, dist2);
				i=corBra;
				mode=-1;
				app=0;
				break;
			case ']':
				throw new IllegalStateException();
			default:
				break;
			}
		}
		//flush
		code.putCode(mode, app);
		return code;
	}
	void setByte(int pos,byte b)
	{
		code.set(pos, b);
	}
	void setShort(int pos,short sh)
	{
		code.set(pos, (byte)(sh));
		code.set(pos+1, (byte)(sh>>>8));
	}
	void putCode(int mode,int app)
	{
		switch(mode)
		{
		case MEMADD:
			app=(int)(byte)app;
			if(app>=-8 && app<=7)
			{
				code.add((byte)(MEMADD_N+(app&15)));
				break;
			}
			code.add((byte) mode);
			code.add((byte)app);
			break;
		case PTRMOV_W:
			if(app==1)
			{
				code.add((byte) PTRMOV_R1);
				break;
			}
			if(app==-1)
			{
				code.add((byte) PTRMOV_L1);
				break;
			}
			if(app>=-8 && app<=7)
			{
				code.add((byte)(PTRMOV_N+(app&15)));
				break;
			}
			if(app>=-128 && app<=127)
			{
				code.add((byte) PTRMOV_B);
				code.add((byte)app);
				break;
			}
			code.add((byte) mode);
			code.add((byte)app);
			code.add((byte)(app>>8));
			break;
		case PUTCHAR:
		case GETCHAR:
			code.add((byte)mode);
			break;
		case JMP_W:
			app=-app;
			if(app>=-128 && app<=127)
			{
				code.add((byte) JMP_B);
				code.add((byte)app);
				break;
			}
			code.add((byte) mode);
			code.add((byte)app);
			code.add((byte)(app>>8));
			break;
		case CONDJMP_W:
			if(app>=-128 && app<=127)
			{
				code.add((byte) CONDJMP_B);
				code.add((byte)app);
				break;
			}
			code.add((byte) mode);
			code.add((byte)app);
			code.add((byte)(app>>8));
			break;
		default:
			break;
		}
	}
	public byte[] yieldByteCode()
	{
		byte[] result=new byte[code.size()];
		for(int i=0;i<result.length;i++)
		{
			result[i]=code.get(i);
		}
		return result;
	}
	public int size()
	{
		return code.size();
	}
	@Override 
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append('[');
		int c=0;
		for(byte b:code)
		{
			sb.append(String.format("%02x ",b&0xff));
			if((++c)%16==0)
			{
				sb.append('\n');
			}
		}
		sb.append(']');
		return sb.toString();
	}
	public static final int MEMADD=0,
			PTRMOV_W=1,
			PUTCHAR=2,
			GETCHAR=3,
			JMP_W=4,
			CONDJMP_W=5,
			PTRMOV_B=0x11,
			JMP_B=0x14,
			CONDJMP_B=0x15,
			PTRMOV_R1=0x20,
			PTRMOV_L1=0x21,
			MEMADD_N=0x40,//nibble
			PTRMOV_N=0x50;
	public static void main(String[] args) throws IOException
	{
		String filename=args.length>=1?args[0]:new Scanner(System.in).nextLine();
		File file=new File(filename);
		if(file.length()>Brainf_ckVM.THRESHOLD)
		{
			throw new RuntimeException();
		}
		byte[] code=new byte[(int)file.length()];
		{
			FileInputStream fis=new FileInputStream(file);
			fis.read(code);
			fis.close();
		}
		LoopMemo lm=new LoopMemo(code);
		VMCode vmc=VMCode.compile(code, 0, code.length, lm);
		System.out.println(vmc);
		{
			FileOutputStream bin=new FileOutputStream(filename+".bin");
			bin.write(vmc.yieldByteCode());
			bin.close();
		}
	}
}
