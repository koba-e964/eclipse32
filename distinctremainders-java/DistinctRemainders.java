import java.util.*;
public class DistinctRemainders {
	long MOD=1000000007;
	int A=1000000;
	int m;
	public int howMany(long n, int M) {
		m=M;
		for(int i=0;i<FMAX;i++)
		{
			fct[i]=-1;
		}
		fct[0]=1;
		long count=0;
		makeTable();
		if(n==0)count++;
		for(int p=1;p<=m;p++)
		{
			for(int i=0;i<memo[p].length && i<=n;i++)
			{
				if((n-i)%m!=0)continue;
				int div=divide((n-i)/m,p);
				long temp=(factorial(p)*(long)div)%MOD;
				temp*=memo[p][i];
				count+=temp;
				count%=MOD;
			}
		}
		return (int)(count%MOD);
	}
	long naive(long n,long v)
	{
		if(v==0)return 0;
		int sum=0;
		int pat=0;
		for(int i=0;i<m;i++)
		{
			if((v&(1L<<i))!=0)
			{
				sum+=i;
				pat++;
			}
		}
		if((n-sum)%m!=0)
			return 0;
		return (factorial(pat)*(long)divide((n-sum)/m,pat))%MOD;
	}
	final int FMAX=51;
	int []fct=new int[FMAX];
	int divide(long val,int num)
	{//(val+num-1)C (num-1)
		val%=MOD;
		long cur=1;
		for(int i=0;i<num-1;i++)
		{
			cur*=val+i+1;
			cur%=MOD;
			cur*=inv(i+1);
			cur%=MOD;
		}
		return (int)(cur%MOD);
	}
	int inv(int val)
	{
		if(val==0)throw new RuntimeException();
		long cur=val;
		long sum=1;
		int v=(int)MOD-2;
		while(v>0)
		{
			if(v%2==1)
			{
				sum*=cur;
				sum%=MOD;
			}
			cur*=cur;
			cur%=MOD;
			v/=2;
		}
		return (int)(sum%MOD);
	}
	int factorial(int t)
	{
		if(fct[t]>=0)return fct[t];
		if(t==0)return 1;
		long cur=((long)factorial(t-1))*t;
		cur%=MOD;
		fct[t]=(int)cur;
		return fct[t];
	}
	int memo[][];
	int prev[][];
	void makeTable()
	{
		memo=new int[][]{{1}};
		for(int q=1;q<=m;q++)//make (size=q) q+1 x q(q-1)/2+1
		{
			prev=memo;
			memo=new int[q+1][q*(q-1)/2+1];
			//make memo[0][j]
			memo[0][0]=1;
			for(int j=1;j<memo[0].length;j++)
			{
				memo[0][j]=0;
			}
			for(int i=1;i<q+1;i++)
			{
				for(int j=0;j<memo[i].length;j++)
				{
					long count=0;
					if(i<q && j<prev[i].length)
					{
						count+=prev[i][j];
					}
					if(j>=q-1)
					{
						count+=prev[i-1][j-q+1];
						count%=MOD;
					}
					memo[i][j]=(int)count;
				}
			}
		}
	}
	int dp(int p,int sum,long bit,int start)
	{
		return -1;
	}
}
//SRM572 div 2 hard
