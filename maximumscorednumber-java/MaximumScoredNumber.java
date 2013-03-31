import java.util.*;
public class MaximumScoredNumber {

	public int getNumber(int lowerBound, int upperBound) {
		int maxi=-1;
		int max=0;
		for(int i=lowerBound;i<=upperBound;i++)
		{
			int val=num(i);
			if(max<=val)
			{
				maxi=i;
				max=val;
			}
		}
		return maxi;
	}
	int num(int val)
	{
		int count=0;
		for(int i=(int)Math.sqrt(val*2)/2;i>=0;i--)
		{
			int j=(int)Math.sqrt(val-i*i);
			if(i*i+j*j==val)
			{
				count++;
			}
		}
		return count;
	}
}
//SRM