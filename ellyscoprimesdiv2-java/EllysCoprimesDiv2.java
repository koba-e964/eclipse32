import java.util.*;
public class EllysCoprimesDiv2 {

	public int getCount(int[] numbers) {
		Arrays.sort(numbers);
		int count=0;
		memo=new int[100001];
		for(int i=0;i<memo.length;i++)
		{
			memo[i]=-1;
		}
		for(int i=0;i<numbers.length-1;i++)
		{
			minret=Integer.MAX_VALUE;
			count+=mid(numbers[i],numbers[i+1],0);
		}
		return count;
	}
	int memo[];
	int minret;
	int mid(int a,int b,int depth)
	{
		if(b<=a)
		{
			return -1;
		}
		if(depth>=minret)
		{
			return 0;
		}
		if(memo[b]>=0)
		{
			return memo[b];
		}
		if(gcd(a,b)==1)
		{
			memo[b]=0;
			return 0;
		}
		int ret=Integer.MAX_VALUE;
		for(int i=a+1;i<b;i++)
		{
			if(gcd(i,b)!=1)
			{
				continue;
			}
			int sub=mid(a,i,depth+1)+1;
			if(ret>sub)
			{
				ret=sub;
			}
			if(minret>ret+depth)
			{
				minret=ret+depth;
			}
		}
		memo[b]=ret;
		if(minret>ret+depth)
		{
			minret=ret+depth;
		}
		return ret;
	}
	static int gcd(int x,int y)
	{
		while(y!=0)
		{
			int r=x%y;
			x=y;
			y=r;
		}
		return x;
	}

}
//SRM577 div2 hard
