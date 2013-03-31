import java.util.*;
public class GetToTheTop {
	int n;
	int res[];
	int  disj[];
	public int collectSweets(int K, int[] sweets, int[] x, int[] y, int[] sl) {
		n=sweets.length;
		res=new int[n];
		disj=new int[n];
		for(int i=0;i<n;i++)
		{
			disj[i]=i;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(y[i]==y[j] && Math.min(Math.abs(x[i]-x[j]+sl[i]),Math.abs(x[j]+sl[j]-x[i]))<=K)
				{
					link(i,j);
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==j)continue;
				if(y[i]==y[j] && Math.min(Math.abs(x[i]-x[j]+sl[i]),Math.abs(x[j]+sl[j]-x[i]))<=K)
				{
					link(i,j);
				}
			}
		}
		for(int i=0;i<n;++i)
		{
			System.out.printf("%d:%d\n",i,disj[i]);
		}
		System.out.println();
		return 0;
	}
	int root(int i)
	{
		int d=disj[i];
		if(d==i)
		{
			return d;
		}
		disj[i]=root(d);
		return disj[i];
	}
	void link(int i,int j)
	{
		disj[root(j)]=root(i);
	}
}
//SRM404 div2 hard
