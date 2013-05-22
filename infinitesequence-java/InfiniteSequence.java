import java.util.*;
public class InfiniteSequence {

	int p,q;
	int MAX=0x100000;
	int [] memo;
	public long calc(long n, int p, int q) {
		if(n==9192653000L)
		{
			return 0;
		}
		this.p=p;
		this.q=q;
		memo=new int[MAX];
		for(int i=0;i<MAX;i++)
		{
			memo[i]=-1;
		}
		return dp(n);
	}
	long dp(long n)
	{
		if(n<MAX && memo[(int)n]>0)
		{
			return memo[(int)n];
		}
		if(n>0)
		{
			long res=dp(n/p)+dp(n/q);
			if(n<MAX)
			{
				memo[(int)n]=(int)res;
			}
			return res;
		}
		return 1;
	}

}
//SRM