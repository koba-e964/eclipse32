import java.util.*;
public class TheNumberGameDivTwo {

	public String find(int n) {
		memo=new int[n+1];
		for(int i=0;i<memo.length;i++)
		{
			memo[i]=-1;
		}
		return dp(n)?"John":"Brus";
	}
	int[] memo;
	boolean dp(int n)
	{
		if(memo[n]>=0)
		{
			return memo[n]==1;
		}
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				boolean sub=dp(n-i);
				if(!sub)
				{
					memo[n]=1;
					return true;
				}
			}
		}
		memo[n]=0;
		return false;
	}
}
//SRM