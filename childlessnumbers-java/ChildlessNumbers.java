import java.util.*;
public class ChildlessNumbers {

	public int howMany(int A, int B) {
		long bound=bound(B);
		boolean[] value=new boolean[B-A+1];
		for(long i=bound(A)/100;i<=bound;i++)
		{
			int s=sum(i);
			if(i%s==0 )
			{
				long q=i/s;
				if(q>=A &&q<=B)
				{
					value[(int)q-A]=true;
				}
			}
		}
		int count=0;
		for(boolean a:value)
		{
			count+=a?0:1;
		}
		return count;
	}
	long bound(int max)
	{
		int pow=1;
		while(max>0)
		{
			max/=10;
			pow*=10;
		}
		return pow*100;
	}
	int sum(long val)
	{
		int total=0;
		while(val>0)
		{
			total+=val%10;
			val/=10;
		}
		return total;
	}
	public void test()
	{
		int[] map=new int[1001];
		for(int i=1;i<1000000;i++)
		{
			int s=sum(i);
			if(i%s==0 & i/s<1000)
			{
				map[i/s]++;
			}
		}
		for(int j=0;j<1000;j++)
		{
			if(map[j]==0)
				System.out.println(j);
		}
	}

}
//SRM