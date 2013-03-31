import java.util.Arrays;

public class MegaFactorialDiv2 {
	int[][] memo;
	boolean prime[];
	long MOD=1000000009;
	public int countDivisors(int n, int k) {
		memo=new int[1001][101];
		prime=new boolean[1001];
		mkPrime();
		long count=1;
		for(int p=2;p<1000;p++)
		{
			if(!prime[p])continue;
			init();
			for(int i=0;i<k;i++)
			{
				for(int j=p;j<=n;j++)
				{
					dp(j,i,p);
				}
			}
			count*=dp(n,k,p)+1;
			count%=MOD;
		}
		return (int)count;
	}
	void mkPrime()
	{
		prime[0]=false;
		prime[1]=false;
		for(int i=2;i<1001;i++)
		{
			prime[i]=true;
		}
		for(int i=2;i<1001;i++)
		{
			if(!prime[i])continue;
			for(int j=i*i;j<1001;j+=i)
			{
				prime[j]=false;
			}
		}
	}
	void init()
	{
		for(int[] row:memo)
			Arrays.fill(row, -1);
	}
	int power(int n,int p)
	{
		int count=0;
		if(n==0 || !prime[p])return 0;
		while(n>0 && n%p==0)
		{
			n/=p;
			count++;
		}
		return count;
	}
	int dp(int n,int k,int p)
	{
		if(!prime[p])return 0;
		if(memo[n][k]>=0)return memo[n][k];
		long count=0;
		if(k==0)
		{
			int pow=n>=p?power(n,p):0;
			memo[n][0]=pow;
			return memo[n][0];
		}
		if(n<=0)
		{
			memo[0][k]=0;
			return 0;
		}
		count=dp(n-1,k,p)+dp(n,k-1,p);
		count%=MOD;
		memo[n][k]=(int)count;
		return memo[n][k];
	}
}
//srm 569 div 2 hard
