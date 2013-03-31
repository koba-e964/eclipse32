import java.util.Arrays;

public class RandomSort {

	double memo[];
	int n;
	public double getExpected(int[] permutation) {
		this.memo=new double[0x200000];
		n=permutation.length;
		for(int i=0;i<memo.length;i++)
		{
			memo[i]=-1;
		}
		return naive(permutation);
	}
	int encode(int []perm)
	{
		int val=0;
		for(int i=0;i<n-1;i++)
		{
			val|=(perm[i]-1)<<(3*i);
		}
		return val;
	}
	int[] decode(int val)
	{
		int[] perm=new int[n];
		for(int i=0;i<n;i++)
		{
			perm[i]=((val>>(3*i))&7)+1;
		}
		return perm;
	}
	public double naive(int [] perm)
	{
		int enc=encode(perm);
		if(memo[enc]>=0)return memo[enc];
		int n=perm.length;
		int pair=0;
		double sum=0.0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(perm[i]>perm[j])
				{
					pair++;
					int[] cp1=(int[])perm.clone();
					cp1[j]=perm[i];
					cp1[i]=perm[j];
					sum+=naive(cp1);
				}
			}
		}
		if(pair==0)
			return 0.0;
		memo[enc]=sum/pair+1;
		return memo[enc];
	}
}
//srm 402 div 2 hard
