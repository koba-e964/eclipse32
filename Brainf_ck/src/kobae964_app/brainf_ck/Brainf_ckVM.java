package kobae964_app.brainf_ck;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Brainf_ckVM {
	static final int THRESHOLD=0x10000;
	static final int MEMSIZE=0x10000;
	static final int MEM_GUARANTEED=30000;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String filename=args.length>=1?args[0]:new Scanner(System.in).nextLine();
		//load
		RandomAccessFile raf=new RandomAccessFile(filename,"r");
		if(raf.length()>THRESHOLD)
		{
			throw new IOException("Filesize too large");
		}
		int length=(int)raf.length();
		byte[] program=new byte[length];
		raf.readFully(program);
		new Brainf_ckVM(program);
	}
	public Brainf_ckVM(byte[] p) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		program=p;
		memory=new byte[MEMSIZE];
		pc=0;
		ptr=0;
		loopMemo=new LoopMemo(program);
		while(pc<program.length)
		{
			int code=program[pc]&0xff;
			//System.out.println(this+", code="+(char)code);
			switch(code)
			{
			case '+':
				memory[ptr]++;
				break;
			case '-':
				memory[ptr]--;
				break;
			case '<':
				ptr--;
				break;
			case '>':
				ptr++;
				break;
			case '.':
				System.out.print((char)memory[ptr]);
				break;
			case ',':
				byte b=(byte)br.read();
				memory[ptr]=b;
				break;
			case '[':
				int clBra=searchBracket(pc);
				if(memory[ptr]==0)
				{
					pc=clBra+1;
					continue;
				}
				break;
			case ']':
				int openBra=searchBracket(pc);
				if(memory[ptr]!=0)
				{
					pc=openBra+1;
					continue;
				}
				break;
			default:
				break;	
			}
			pc++;
		}
		System.out.println("loopMemo="+loopMemo);
	}
	void runVMCode(VMCode vmc)
	{
		
	}
	int searchBracket(int pos)
	{
		return loopMemo.searchBracket(pos);
	}
	@Override
	public String toString()
	{
		return "pc="+pc+", ptr="+ptr+", mem[ptr]="+memory[ptr];
	}
	byte[] memory;
	byte[] program;
	int pc;
	int ptr;
	LoopMemo loopMemo=null;
}
