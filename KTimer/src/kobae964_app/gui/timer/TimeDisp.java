package kobae964_app.gui.timer;

import java.util.Arrays;

class TimeDisp
{
	private long time;
	private boolean input;
	int len;
	private char[] buf;
	TimeDisp()
	{
		time=0;
		input=false;
		len=0;
		buf=new char[8];
	}
	synchronized void decrement()
	{
		if(input)
		{
			parse();
		}
		time--;
	}
	synchronized public void parse()
	{
		time=Integer.parseInt(""+buf[7]+buf[6]);
		time*=60;
		time+=Integer.parseInt(""+buf[5]+buf[4]);
		time*=60;
		time+=Integer.parseInt(""+buf[3]+buf[2]);
		time*=100;
		time+=Integer.parseInt(""+buf[1]+buf[0]);
		len=8;
		input=false;
	}
	synchronized public void push(int v)
	{
		if(!input)
		{
			time=0;
			len=0;
			Arrays.fill(buf, '0');
		}
		input=true;
		if(len>=8)return;
		if(len==0 && v==0)return;
		for(int i=len;i>=1;i--)
		{
			buf[i]=buf[i-1];
		}
		buf[0]=(char)('0'+v);
		len++;
	}
	@Override
	public String toString()
	{
		if(input)
		{
			return(""+buf[7]+buf[6]+":"+buf[5]+buf[4]+":"+buf[3]+buf[2]+"."+buf[1]+buf[0]);
		}
		long time=Math.abs(this.time);
		StringBuilder sb=new StringBuilder();
		sb.append(String.format("%02d",time/360000))
		.append(':')
		.append(String.format("%02d",(time/6000)%60))
		.append(':')
		.append(String.format("%02d",time/100%60))
		.append('.')
		.append(String.format("%02d",time%100));
		return sb.toString();
	}
	public String debug()
	{
		return "input="+input+", buf="+new String(buf)+", time="+time;
	}
}