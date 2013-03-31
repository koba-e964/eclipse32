import java.util.Arrays;

public class ConsecutiveNumbers {

	public int[] missingNumber(int[] numbers) {
		Arrays.sort(numbers);
		int n=numbers.length;
		int i;
		int pres=-1;
		for(i=0;i<n-1;i++)
		{
			int diff=numbers[i+1]-numbers[i];
			if(diff==2)
			{
				if(pres==-1)
					pres=numbers[i]+1;
				else
					return new int[0];
			}
			else if(diff>=3 || diff==0)
			{
				return new int[0];
			}
		}
		if(pres==-1)
		{
			if(numbers[0]>=2)
				return new int[]{numbers[0]-1,numbers[n-1]+1};
			return new int[]{numbers[n-1]+1};
		}
		return new int[]{pres};
	}

}
//srm 402 div 2 medium
