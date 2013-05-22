import java.util.*;
public class CharacterBoard {
	static long MOD=1000000009;
	int m,n;
	int w;
	int i0,j0;
	String[] frag;
	static final int BSIZE=10000;
	public static final int pow26(int val)
	{
		long cur=26;
		long sum=1;
		while(val>0)
		{
			if(val%2==1)
			{
				sum*=cur;
				sum%=MOD;
			}
			cur*=cur;
			cur%=MOD;
			val/=2;
		}
		return (int)sum;
	}
	public int countGenerators(String[] fragment, int W, int i0, int j0) {
		frag=fragment;
		n=fragment.length;
		m=fragment[0].length();
		w=W;
		this.i0=i0;
		this.j0=j0;
		return correct();
	}
	int wrong()
	{
		int[] p26=new int[BSIZE];
		int ur=1;
		for(int i=0;i<BSIZE;i++)
		{
			p26[i]=ur;
			ur=(int)((ur*26L)%MOD);
		}
		long sum=0;
		for(int l=w;l>=1;l--)
		{
			int ret;
			if(w%l>=m && (w%l)*n<=l)
			{
				ret=l-m*n;
			}
			else
			{
				ret=dp(l);
				System.out.println("(l="+l+", ret="+ret+")");
			}
			if(l%100000==0)
			{
				System.out.println("l="+l);
			}
			if(ret==-1)
				continue;
			sum+=ret<BSIZE?p26[ret]:pow26(ret);
			sum%=MOD;
		}
		return (int)sum;
	}
	HashMap<Integer, String> remMemo=new HashMap<Integer, String>(m*2);
	int dp(int l)
	{
		HashMap<Integer,Integer> buf=new HashMap<Integer, Integer>(m*n);
		int count=l;
		for(int p=i0;p<(long)i0+n;p++)
		{
			for(int q=j0;q<(long)j0+m;q++)
			{
				int ind=(int)(((long)p*w+(long)q)%l);
				if(!buf.containsKey(ind))
				{
					buf.put(ind, (int) frag[p-i0].charAt(q-j0));
					count--;
				}
				else
				{
					if(buf.get(ind)!=frag[p-i0].charAt(q-j0))
					{
						return -1;
					}
				}
			}
		}
		return l-buf.size();
	}
	String getRem(int rem)
	{
		if(remMemo.containsKey(rem))
		{
			return remMemo.get(rem);
		}
		char[] buf=new char[rem*(n-1)+m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(buf[rem*i+j]=='\0')
				{
					buf[rem*i+j]=frag[i].charAt(j);
				}
				else
				{
					if(buf[rem*i+j]!=frag[i].charAt(j))
					{
						remMemo.put(rem, null);
						return null;
					}
				}
						
			}
		}
		String value=new String(buf).intern();
		remMemo.put(rem,value);
		return value;
	}
	/**
	 * made from another person's source
	 * @return
	 */
	int correct()
	{
		HashSet<Integer> special=new HashSet<Integer>(m*n);
		for(int i=0;i<n;i++)
		{
			for(int j=-m+1;j<m;j++)
			{
				long diff=(long)i*w+j;
				if(diff<=0)
					continue;
				for(long div=1;div*div<=diff;div++)
				{
					if(diff%div==0)
					{
						if(div<=w)
							special.add((int)div);
						if(diff/div<=w)
							special.add((int)(diff/div));
					}
				}
			}
		}
		//1+..+26^(w-m*n)
		long total=w>=m*n? power(26,w-m*n+1,(int) MOD)-1:0;
		total*=inversePower(25, (int)MOD);
		total%=MOD;
		{
			System.out.print("n="+n+", |special|="+special.size());
			System.out.println("total="+total);
		}
		for(final int l:special)
		{
			int res=dp(l);
			if(res>=0)
			{
				total+=pow26(res);
			}
			if(l>=m*n)
			{
				total+=MOD-power(26,l-m*n,(int)MOD);
			}
			total%=MOD;
		}
		return (int)(total%MOD);
	}
	public static int inverseEuclid(int a,int mod)
	{
		if(mod==0)throw new IllegalArgumentException("mod==0");
		if(mod<0)mod=-mod;
		if(a%mod==0)throw new IllegalArgumentException("a==0 (mod mod)");
		if(a<0)return mod-inverseEuclid(-a,mod);
		//a=='a'*x+'mod'*?;
		//mod=='a'*y+mod*?;
		long x=1;
		long y=0;
		int mod_old=mod;
		while(mod>0)
		{
			int q=a/mod;
			int r=a%mod;
			a=mod;
			mod=r;
			long tmp=y;
			y=x-q*y;
			x=tmp;
			x=remainder(x,mod_old);
			y=remainder(y,mod_old);
		}
		if(a!=1)
			throw new RuntimeException(String.format("gcd(a,mod)==%d!=1",x));
		return (int)x;
	}
	private static long remainder(long a,int b)
	{
		if(a<0)return b-1-((-a-1)%b);
		return a%b;
	}
	public static int power(int a,long b,int mod)
	{
		if(mod==0)throw new IllegalArgumentException("mod==0");
		if(mod<0)mod=-mod;
		if(mod==1)return 0;
		if(b==(1L<<63))
		{
			throw new IllegalArgumentException("b==-2^63");
		}
		if(b<0)
		{
			a=inverseEuclid(a,mod);
			b=-b;
		}
		long cur=a%mod;
		long sum=1;
		while(b!=0)
		{
			if((b&1)==1)
			{
				sum*=cur;
				sum%=mod;
			}
			cur*=cur;
			cur%=mod;
			b>>>=1;
		}
		return (int)sum;
	}
	public static int inversePower(int a,int p)
	{
		if(a%p==0)
			throw new ArithmeticException("a==0");
		return power(a,p-2,p);
	}

}
//SRM576 div1 hard