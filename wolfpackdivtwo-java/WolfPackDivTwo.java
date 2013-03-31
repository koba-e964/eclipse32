import java.util.*;
public class WolfPackDivTwo {
	final long MOD=1000000007;
	int n;
	final int SIZE=250;
	public int calc(int[] x, int[] y, int m) {
		n=x.length;
		boolean even = (x[0]+y[0])%2==0;
		/*for(int i=0;i<n;i++)
		{
			if(((x[i]+y[i])%2==0)!=even)
			{
				return 0;
			}
		}*/
		int[][] global=makeTable(0,0);
		global=progress(global,m);
		even=m%2==0?even:!even;
		long total=0;
		for(int i=x[0]-m;i<=x[0]+m;i++)
		{
			for(int j=y[0]-m;j<=y[0]+m;j++)
			{
				if((i+j)%2!=(even?0:1))
				{
					//continue;
				}
				long tmp=1;
				for(int k=0;k<n;k++)
				{
					tmp*=global[i-x[k]+BIAS][j-y[k]+BIAS];
					tmp%=MOD;
				}
				total+=tmp;
				total%=MOD;
			}
		}
		return (int)(total%MOD);
	}
	final int BIAS=125;
	int[][] makeTable(int x,int y)
	{
		int[][] res=new int[SIZE][SIZE];
		res[x+BIAS][y+BIAS]=1;
		return res;
	}
	int[][] progress(int[][] old,int t)
	{
		int[][] cur;
		for(int k=0;k<t;k++)
		{
			cur=new int[SIZE][SIZE];
			for(int i=0;i<SIZE;i++)
			{
				for(int j=0;j<SIZE;j++)
				{
					cur[i][j]=(int)(((long)(i>0?old[i-1][j]:0)
							+(j>0?old[i][j-1]:0)
							+(i<SIZE-1?old[i+1][j]:0)
							+(j<SIZE-1?old[i][j+1]:0))%MOD);
				}
			}
			old=cur;
		}
		return old;
	}

}
//SRM 573 div2 hard