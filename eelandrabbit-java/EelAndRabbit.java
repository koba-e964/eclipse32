import java.util.*;
public class EelAndRabbit {
	int n;
	int[] tl,t;
	public int getmax(int[] l, int[] t) {
		n=l.length;
		 tl=new int[n];
		 this.t=t;
		for(int i=0;i<n;i++)
		{
			tl[i]=t[i]+l[i];
		}
		TreeSet<Integer> app=new TreeSet<Integer>();
		for(int a:t)
		{
			app.add(a);
		}
		for(int a:tl)
		{
			app.add(a);
		}
		int[] tmp=new int[app.size()];
		{
			int c=0;
			for(int a:app)
			{
				tmp[c++]=a;
			}
		}
		int max=0;
		for(int i=0;i<tmp.length;i++)
		{
			for(int j=i+1;j<tmp.length;j++)
			{
				max=Math.max(max,calc(tmp[i],tmp[j]));
			}
		}
		return max;
	}
	int calc(int u1,int u2)
	{
		return Long.bitCount(getFlag(u1)|getFlag(u2));
	}
	long getFlag(int u)
	{
		long bits=0;
		for(int i=0;i<n;i++)
		{
			if(t[i]<=u&&u<=tl[i])bits|=1L<<i;
		}
		return bits;
	}

}
//SRM 
