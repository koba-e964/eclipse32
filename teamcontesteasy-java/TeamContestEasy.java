import java.util.*;
public class TeamContestEasy {

	int  n;
	int[] strength;
	int my;
	public int worstRank(int[] strength) {
		n=strength.length/3;
		this.strength=new int[3*n-3];
		for(int i=3;i<3*n;i++)
		{
			this.strength[i-3]=strength[i];
		}
		Arrays.sort(this.strength);
		my=strength[0]+strength[1]+strength[2]-Math.min(Math.min(strength[0],strength[1]), strength[2]);
		memo=new HashMap<Long, Integer>();
		memo2=new HashMap<Integer,Integer>();
		int res=dp2(0,3*n-3)+1;
		System.out.println("memo.size="+memo2.size());
		return res;
	}
	Map<Long, Integer> memo;
	int[] maxm;
	int dp(long bits,int start)
	{
		if(start>=3*n-1)
			return 0;
		long canonical=(bits&((-1L)<<start))|((long)start<<48L);
		if(memo.containsKey(canonical))
		{
			return memo.get(canonical);
		}
		int max=0;
		int limit = Math.min(n-1,(3*n-start)/2);
		if((bits&(1L<<start))==0)
		{
			long cache=bits|(1L<<start);
			int left=my-strength[start];
			for(int j=start+1;j<3*n;j++)
			{
				if(3*n-start<=max)
				{
					break;
				}
				if((cache&(1L<<j))!=0)continue;
				if(strength[j]<=left)continue;
				int sub=dp(cache|(1L<<j),start+1)+1;
				if(max<sub)
				{
					max=sub;
				}
				if(max>=limit)
				{
					max=limit;
					break;
				}
			}
		}
		if(max<limit)
		{
			int sub=dp(bits,start+1);
			if(max<sub)
			{
				max=sub;
			}
			if(max>=limit)
			{
				max=limit;
			}
		}
		//if(start<=n || start>=3*n/2 )
			memo.put(canonical,max);
		return max;
	}
	Map<Integer,Integer> memo2;
	int dp2(int start,int end)//[start,end)
	{
		int canonical=start*128+end;
		if(start>=end-1)
		{
			return 0;
		}
		if(memo2.containsKey(canonical))
		{
			return memo2.get(canonical);
		}
		final int limit=Math.min(n-1, (end-start)/2);
		int max=0;
		for(int i=start+1;i<end;i++)
		{
			if(my>=strength[start]+strength[i])continue;
			int sub=dp2(start+1,i)+dp2(i+1,end)+1;
			if(max<sub)
				max=sub;
			if(max>=limit)
			{
				max=limit;
				break;
			}
		}
		if(max<limit)
		{
			int sub=dp2(start+1,end);
			if(max<sub)
			{
				max=sub;
			}
			if(max>=limit)
			{
				max=limit;
			}
		}
		memo2.put(canonical, max);
		return max;
	}
	int edge[][];
	void makeEdges()
	{
		List<Long> te=new ArrayList<Long>(5*n*n);
		for(int i=3;i<3*n;i++)
		{
			for(int j=i+1;j<3*n;j++)
			{
				if(strength[i]+strength[j]>my)
				{
					te.add((1L<<i)|(1L<<j));
				}
			}
		}
		int ne=te.size();
		edge=new int[ne][ne];
		for(int i=0;i<ne;i++)
		{
			for(int j=0;j<ne;j++)
			{
				edge[i][j]=(te.get(i)&te.get(j))==0?1:0;
			}
		}
	}
}
//SRM573 div2 medium