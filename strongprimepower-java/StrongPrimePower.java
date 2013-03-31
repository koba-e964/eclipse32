import java.math.BigInteger;

public class StrongPrimePower {

	public int[] baseAndExponent(String n) {
		long val=Long.parseLong(n);
		//10^18 == 1000 ^ 6
		for(int p=2;p<1000;p++)
		{
			if(val%p==0)
			{
				int result=checkPrimePower(val,p);
				if(result>=2)
				{
					return new int[]{p,result};
				}
				else
				{
					return new int[0];
				}
					
			}
		}
		for(int i=6;i>=2;i--)
		{
			double app_d=Math.pow(((double)val),1.0/i);
			int app=(int)(long)(Math.floor(app_d));
			while(true)
			{
				long pwr=power(app,i);
				if(pwr>val)
					break;
				if(pwr==val)
				{
					if(isPrime(app))
					{
						return new int[]{(int) app,i};
					}
					else
						return new int[0];
				}
				app++;
			}
		}
		return new int[0];
	}
	long power(long a,int b)
	{
		long c=1;
		for(int i=0;i<b;i++)
		{
			c*=a;
		}
		return c;
	}
	boolean isPrime(int val)
	{
		if(val<=1)return false;
		for(int i=2;i*i<=val;i++)
		{
			if(val%i==0 )return val==i;
		}
		return true;
	}
	int checkPrimePower(long n,long p)
	{
		int cnt=0;
		while(n!=1)
		{
			if(n%p!=0)return -1;
			n/=p;
			cnt++;
		}
		return cnt;
	}

}
