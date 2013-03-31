package kobae964_app.algo;

public final class Modular {
	public static boolean isPrime(long p)
	{
		if(p<=1)return false;
		if(p%2==0)return p==2;
		for(long i=3;i*i<=p;i+=2)
		{
			if(p%i==0)return p==i;
		}
		return true;
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
		if(!isPrime(p))
			throw new UnsupportedOperationException("p is not prime");
		if(a%p==0)
			throw new ArithmeticException("a==0");
		return power(a,p-2,p);
	}
	private static long remainder(long a,int b)
	{
		if(a<0)return b-1-((-a-1)%b);
		return a%b;
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
	public static int quadratic(int a,int p)
	{
		if(p==2)
		{
			return new int[]{0,1,0,-1,0,-1,0,-1}[a%8];
		}
		if(!isPrime(p))
		{
			throw new IllegalArgumentException("p is not prime");
		}
		return power(a,(p-1)/2,p);
	}
}
