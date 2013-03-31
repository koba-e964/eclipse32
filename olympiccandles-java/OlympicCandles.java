import java.util.*;
public class OlympicCandles {

	public int numberOfNights(int[] candles) {
		Arrays.sort(candles);
		int n=candles.length;
		int count=0;
		top:
		while(count<n)
		{
			for(int i=0;i<count+1;i++)
			{
				if(candles[n-1-i]<=0)
				{
					break top;
				}
				candles[n-1-i]--;
			}
			count++;
			Arrays.sort(candles);
		}
		return count;
	}
	int tmp0(int val)
	{
		int s=0;
		int ret=0;
		while(s<val)
		{
			s+=ret;
			ret++;
		}
		return ret-1;
	}
}
//SRM 408 div2 medium
