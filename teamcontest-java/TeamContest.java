import java.util.*;
public class TeamContest {
	int[] str;
	int my;
	int n;
	public int worstRank(int[] strength) {
		str=strength;
		Arrays.sort(str,0,3);
		Arrays.sort(str,3, str.length);
		my=str[0]+str[2];
		n=str.length/3;
		return dp(0L,3,str.length)+1;
	}
	HashMap<Long,Integer> memo=new HashMap<Long, Integer>();
	int dp(long bits,int start,int end)
	{
		long canonical=bits|((1L<<start)-1)|((-1L)<<end);
		if(memo.containsKey(canonical))
		{
			return memo.get(canonical);
		}
		int max=0;
		int limit=Math.min(n-1, (end-start)/3);
		if((bits&(1L<<start))!=0)
		{
			int sub=dp(bits,start+1,end);
			return sub;
		}
		top:
		for(int j=end-1;j>=start+2;j--)
		{
			if((bits&(1L<<j))!=0)
			{
				continue;
			}
			if(str[start]+str[j]<=my)
				break;
			for(int i=start+1;i<j;i++)
			{
				if((bits&(1L<<i))!=0)
					continue;
				int sub=dp(bits|(1L<<start)|(1L<<i)|(1L<<j),start+1,j)+1;
				if(max<sub)
				{
					max=sub;
				}
				if(max>=limit)
				{
					max=limit;
					break top;
				}
				break;
			}
			break;
		}
		if(max<limit)
		{
			int sub=dp(bits,start+1,end);
			if(max<sub)
			{
				max=sub;
			}
			if(max>=limit)
			{
				max=limit;
			}
		}
		memo.put(canonical, max);
		return max;
	}
}
//SRM 573 div 1 easy
