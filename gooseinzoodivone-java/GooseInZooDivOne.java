import java.util.*;
import static java.lang.Math.*;
public class GooseInZooDivOne {
	static final int MOD=1000000007;
	int[] disj;
	public int count(String[] field, int dist) {
		int m=field.length;
		int n=field[0].length();
		disj=new int[m*n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				disj[i*n+j]=(field[i].charAt(j)=='v')?i*n+j:-1;
			}
		}
		for(int y0=0;y0<m;y0++)
		{
			for(int x0=0;x0<n;x0++)
			{
				for(int y1=0;y1<m;y1++)
				{
					for(int x1=0;x1<n;x1++)
					{
						if(dist(x0, y0, x1, y1)<=dist)
						{
							link(x0+y0*n,x1+y1*n);
						}
					}
				}
			}
		}
		int[] app=new int[n*m];
		for(int i=0;i<app.length;i++)
		{
			app[i]=0;
		}
		for(int i=0;i<m*n;i++)
		{
			if(disj[i]>=0)
				app[root(i)]++;
		}
		int ev=0,od=0;
		for(int i=0;i<m*n;i++)
		{
			int a=app[i];
			if(disj[i]==-1 || a==0)
				continue;
			if(a%2==0)
			{
				ev++;
			}
			else
			{
				od++;
			}
		}
		long count=1;
		System.out.println("ev="+ev+", od="+od);
		for(int i=0;i<ev+max(od-1,0);i++)
		{
			count*=2;
			count%=MOD;
		}
		count+=MOD-1;
		count%=MOD;
		return (int)count;
	}
	int dist(int x0,int y0,int x1,int y1)
	{
		return abs(x0-x1)+abs(y0-y1);
	}
	void link(int a,int b)
	{
		if(disj[a]==-1 || disj[b]==-1)return;
		disj[root(a)]=root(b);
	}
	int root(int a)
	{
		if(disj[a]==-1)
		{
			return -1;
		}
		if(disj[a]!=a)
		{
			return disj[a]=root(disj[a]);
		}
		return a;
	}
	
}
//SRM578 div1 easy