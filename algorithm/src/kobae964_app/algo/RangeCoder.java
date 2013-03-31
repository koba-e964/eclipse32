package kobae964_app.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeCoder {
	public static class Frequency
	{
		public Frequency()
		{
			
		}
		public int[] toIntArray()
		{
			int[] res=new int[256];
			Arrays.fill(res,0x100);
			return res;
		}
	}
	public RangeCoder(Frequency freq)
	{
		this(freq,0x10000);
	}
	public RangeCoder(Frequency freq,int initialCapacity)
	{
		int[] ary=freq.toIntArray();
		assert ary.length==256;
		content=new ArrayList<Byte>(initialCapacity);
	}
	public void encode(byte[] data)
	{
		for(final byte d:data)
			append(d&0xff);
	}
	private void append(int data)
	{
		int st=(int) (l+(r*tbl[data])/0x10000);
		int end=(int)(l+(r*tbl[data+1])/0x10000);
		l=st;
		r=end-st;
		if(l>=(1L<<32))
		{
			content.set(content.size()-1, content.get(content.size()-1));
			for(int i=0;i<ffcount;i++)
			{
				content.add((byte) 0);
			}
			ffcount=0;
		}
		if(r<0x1000000)
		{
			int c=(int) (l>>>24);
			if(c!=0xff)
				content.add((byte)c);
			else
				ffcount++;
			l&=0xffffff;
			l<<=8;
			r<<=8;
		}
	}
	public byte[] getContent()
	{
		return null;
	}
	private long l=0,r=0x100000000L;
	private int ffcount=0;
	private List<Byte> content;
	private int[] tbl;
}
