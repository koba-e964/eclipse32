import java.util.*;
public class SkiResortsEasy {

	public int minCost(int[] altitude) {
		int  n=altitude.length;
		int total=0;
		for(int i=0;i<n-1;i++)
		{
			if(altitude[i]<altitude[i+1])
			{
				total+=altitude[i+1]-altitude[i];
				altitude[i+1]=altitude[i];
			}
		}
		return total;
	}

}
//SRM 573 div 2 easy