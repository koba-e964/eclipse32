import java.util.*;
public class AlienDictionary {
	int wl;
	int m;//length of each forbidden string
	String[] forbidden;
	public String[] getWords(int wordLength, String[] forbidden, int[] wordNumbers) {
		wl=wordLength;
		this.forbidden=forbidden;
		if(forbidden.length>=1)
		{
			m=forbidden[0].length();
		}
		else
		{
			m=-1;
		}
		if(m>=0)
		{
			fmem=new boolean[(1<<m)];
			for(int i=0;i<1<<m;i++)
			{
				fmem[i]=forbid(i);
			}
		}
		int wn=wordNumbers.length;
		String [] out=new String[wn];
		if(m>=0)
		{
			memo=new long[(wl+1)<<m];
			for(int i=0;i<memo.length;i++)
			{
				memo[i]=-1;
			}
			for(int i=m;i<=wl;i++)
			{
				inner:
					for(int bits=0;bits<1<<m;bits++)
					{
						endLock=i;
						patLock=bits;
						long res=dp0(i,bits);
					}
			}
			endLock=Integer.MAX_VALUE;
			patLock=Integer.MAX_VALUE;
		}
		for(int i=0;i<wn;i++)
		{
			out[i]=getNth(wordNumbers[i]);
		}
		return out;
	}
	static final long INF=0x80000000L-1;
	//HashMap<Integer,Long> memo=new HashMap<Integer, Long>();
	long memo[];
	int endLock,patLock;
	long dp0(int end,int pattern)//[start,start+k) fixed
	{
		if( (pattern& ((1<<m)-1) ) !=pattern)
		{
			throw new RuntimeException();
		}
		int canonical=pattern|(end<<m);
		//if(memo.containsKey(canon))
		if(memo[canonical]!=-1)
		{
			//return memo.get(canon);
			//System.out.println("memoread end="+end+String.format("pattern=%x", pattern)+", res="+memo[canonical]);
			return memo[canonical];
		}
		if(end<m)
		{
			throw new RuntimeException();
		}
		if(end==m)
		{
			
			int count=pattern==0?0:(int)dp0(m,pattern-1);
			
			if(!fmem[pattern])count++;
			//memo.put(canon,(long)count);
			memo[canonical]=count;
			return count;
		}
		//end>m
		long count=0;
		if(pattern>=1)
		{
			//System.out.println("end="+end+", pattern"+String.format("%x",pattern));
			long s=dp0(end,pattern-1);
			if(false && s>=INF)
			{
				//memo.put(canon, INF);
				memo[canonical]=INF;
				return INF;
			}
			count=s;
		}
		if(!fmem[pattern])
		{
			long subB=dp0(end-1,(pattern*2+1)& ((1<<m)-1) );
			if(pattern% (1<<(m-1)) >=1)
			{
				subB-=dp0(end-1,(pattern*2-1)& ((1<<m)-1) );
			}
			count+=subB;
		}
		if(count>=INF)
		{
			//count=INF;
		}
		//memo.put(canon, count);
		memo[canonical]=count;
		if(count==-1)
		{
			throw new RuntimeException();
		}
		return count;
	}
	static boolean matches(char[] buf,String pat)
	{
		for(int i=0;i<buf.length;i++)
		{
			char p=pat.charAt(i);
			if(p!='?' && buf[i]!=p)
			{
				return false;
			}
		}
		return true;
	}
	boolean fmem[];
	boolean forbid(int pattern)
	{
		if(forbidden.length==0)
		{
			return false;
		}
		char[] buf=new char[m];
		for(int i=0;i<m;i++)
		{
			buf[i]=(pattern&(1<<(m-1-i)))!=0?'B':'A';
		}

		for(String f:forbidden)
		{
			if(matches(buf,f))return true;
		}
		return false;
	}
	String getNth(int id)
	{
		if(m==-1 || m>wl)
		{
			char[] buf=new char[wl];
			if(id>=1L<<wl)
			{
				return "NO PAGE";
			}
			for(int i=0;i<wl;i++)
			{
				buf[wl-1-i]=(char) ('A'+id%2);
				id/=2;
			}
			return String.valueOf(buf);
		}
		int pat=(1<<m)-1;
		char[] ret=new char[wl];
		Arrays.fill(ret,' ');
		if(dp0(wl,pat)<=id)
		{
			return "NO PAGE";
		}
		for(int i=0;i<wl;i++)
		{
			if(i<m)
			{
				int t0=pat&~(1<<(m-i-1));
				long sub=dp0(wl,t0);
				if(id<sub)
				{
					pat&=~(1<<(m-i-1));
					ret[i]='A';
				}
				else
				{
					ret[i]='B';
				}
			}
			else
			{
				if(i==m)
				{
					id-=pat==0?0:dp0(wl,pat-1);
				}
				pat<<=1;
				pat&=(1<<m)-1;
				long base=pat==0?0:dp0(wl+m-i-1,pat-1);
				long upper=dp0(wl+m-i-1,pat);
				if(id<upper-base)
				{
					ret[i]='A';
					//id-=base;
				}
				else
				{
					pat|=1;
					ret[i]='B';
					id-=upper-base;
				}
				//throw new RuntimeException();
			}
		}
		return String.valueOf(ret);
	}
}
//SRM415 div1 hard