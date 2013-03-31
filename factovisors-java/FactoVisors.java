import java.util.*;
public class FactoVisors {

	public int getNum(int[] divisors, int[] multiples) {
		int g=0;
		long l=1;
		for(int d:divisors)
		{
			l=lcm(l,d);
			if(l>=0x80000000L)
			{
				return 0;
			}
		}
		for(int m:multiples)
		{
			g=(int)gcd(g,m);
		}
		if(g%l!=0)
			return 0;
		g/=l;
		int p=2;
		int pow=0;
		int count=1;
		while(g>=2 || pow>=1)
		{
			if((long)p*(long)p>(long)g &&pow==0)
			{
				count*=2;
				break;
			}
			if(g%p!=0)
			{
				count*=pow+1;
				pow=0;
				p++;
				continue;
			}
			g/=p;
			pow++;
		}
		return count;
	}
	long gcd(long x,long y)
	{
		while(y>0)
		{
			long r=x%y;
			x=y;
			y=r;
		}
		return x;
	}
	long lcm(long x,long y)
	{
		if(x==0 || y==0)return 0;
		return x/gcd(x,y)*y;
	}
}
//SRM406 div2 medium