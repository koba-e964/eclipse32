import java.util.*;
public class ContiguousCacheEasy {

	public int bytesRead(int n, int k, int[] addresses) {
		int st=0;
		int sum=0;
		for(int i=0;i<addresses.length;i++)
		{
			int addr=addresses[i];
			if(addr<st)
			{
				int neu=Math.min(st-addr, k);
				sum+=neu;
				st=addr;
			}
			else if(addr>=st+k-1)
			{
				int neu=Math.min(addr-st-k+1, k);
				sum+=neu;
				st=addr-k+1;
			}
		}
		return sum;
	}

}
//SRM