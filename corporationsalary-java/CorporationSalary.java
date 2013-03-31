import java.util.*;
public class CorporationSalary {
	long sal[];
	int n;
	boolean man[][];
	public long totalSalary(String[] relations) {
		n=relations.length;
		sal=new long[n];
		for(int i=0;i<n;i++)
		{
			sal[i]=-1;
		}
		man=new boolean[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				man[i][j]=relations[i].charAt(j)=='Y';
			}
		}
		long total=0;
		for(int i=0;i<n;i++)
		{
			total+=calc(i);
		}
		return total;
	}
	long calc(int id)
	{
		if(sal[id]>=0)
			return sal[id];
		long sum=0;
		for(int j=0;j<n;j++)
		{
			if(man[id][j])
			{
				sum+=calc(j);
			}
		}
		if(sum==0)sum=1;
		sal[id]=sum;
		return sum;
	}
}
//SRM 407 div2 medium