import java.util.*;
public class CollectingUsualPostmarks {
	int[] prices;
	public int numberOfPostmarks(int[] prices, int[] have) {
		this.prices=prices;
		int pv=0;
		for(int h:have)
		{
			pv+=prices[h];
		}
		Arrays.sort(prices);
		int t=0;
		for(int i=0;i<prices.length;i++)
		{
			t+=prices[i];
			if(t>pv)
			{
				return i;
			}
		}
		return prices.length;
	}
	HashMap<Long,Integer> map=new HashMap<Long, Integer>();
	int dp(long bits,int pv,int start)
	{
		int max=0;
		long canon=bits|((1L<<start)-1);
		if(map.containsKey(canon) && false)
		{
			return map.get(canon);
		}
		for(int i=start;i<prices.length;i++)
		{
			if(pv<prices[i])
				continue;
			int sub=dp(bits|(1L<<i),pv-prices[i],i+1);
			if(max<sub)
			{
				max=sub;
			}
		}
		int sub=Long.bitCount(bits);
		if(max<sub)max=sub;
		return max;
	}

}
//SRM