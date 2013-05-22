import java.util.*;
public class CharacterBoard2 {
	long MOD=1000000009;
	int m,n;
	int h=10000,w;
	int i0,j0;
	String[] frag;
	public int countGenerators(String[] fragment, int W, int i0, int j0) {
		frag=fragment;
		n=fragment.length;
		m=fragment[0].length();
		w=W;
		this.i0=i0;
		this.j0=j0;
		int[] p26=new int[w+1];
		int ur=1;
		for(int i=0;i<=w;i++)
		{
			p26[i]=ur;
			ur=(int)((ur*26L)%MOD);
		}
		long sum=0;
		buf=new char[w];
		fail=new boolean[w+1];
		for(int i=0;i<w+1;i++)fail[w]=false;
		for(int l=w;l>=1;l--)
		{
			char[] ret=dp(l);
			if(ret==null)
				continue;
			long count=1;
			int c=0;
			for(int i=0;i<l;i++)
			{
				if(ret[i]==0)
				{
					c++;
				}
			}
			sum+=p26[c];
			sum%=MOD;
		}
		return (int)sum;
	}
	char[] buf;
	boolean fail[];
	char[] dp(int l)
	{
		if(fail[l])
			return null;
		for(int i=0;i<l;i++)buf[i]=0;
		for(int p=i0;p<i0+n;p++)
		{
			for(int q=j0;q<j0+m;q++)
			{
				int ind=p*w+q;
				if(buf[ind%l]==0)
				{
					buf[ind%l]=frag[p-i0].charAt(q-j0);
				}
				else
				{
					if(buf[ind%l]!=frag[p-i0].charAt(q-j0))
					{
						for(int i=1;i*i<l;i++)
						{
							if(l%i==0)
								fail[i]=true;
						}
						return null;
					}
				}
			}
		}
		return buf;
	}
	boolean inRange(int ind)
	{
		int x=ind%w;
		int y=ind/w;
		return i0<=y && y<i0+n && j0<=x && x<j0+m;
	}
}
//SRM576 div2 hard