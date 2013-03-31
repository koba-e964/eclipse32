import java.util.*;
public class TrueSpace {

	public long calculateSpace(int[] sizes, int clusterSize) {
		long sum=0;
		for(int s:sizes)
		{
			sum+=(s+clusterSize-1)/clusterSize*clusterSize;
		}
		return sum;
	}
}
//SRM