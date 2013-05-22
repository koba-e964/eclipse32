import java.util.*;
public class RestaurantManager {

	public int allocateTables(int[] tables, int[] groupSizes, int[] arrivals, int[] departures) {
		Arrays.sort(tables);
		int n=tables.length;
		int[] ends=new int[n]; 
		for(int i=0;i<n;i++)
		{
			ends[i]=0;
		}
		int m=groupSizes.length;
		int count=0;
		for(int i=0;i<m;i++)
		{
			boolean d=false;
			for(int j=0;j<n && !d;j++)
			{
				if(tables[j]>=groupSizes[i] && ends[j]<=arrivals[i])
				{
					ends[j]=departures[i];
					d=true;
				}
			}
			if(!d)
			{
				count+=groupSizes[i];
			}
		}
		return count;
	}

}
//SRM