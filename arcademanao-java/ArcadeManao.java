import java.util.*;
public class ArcadeManao {
	String[] level;
	int m,n;
	int x,y;
	int disj[];
	public int shortestLadder(String[] level, int coinRow, int coinColumn) {
		this.level=level;
		m=level.length;
		n=level[0].length();
		x=coinColumn-1;
		y=coinRow-1;
		disj=new int[m*n];
		for(int i=0;i<m*n;i++){
			disj[i]=i;
		}
		int l=-1;
		while(!isSameSet(y*n+x,(m-1)*n))
		{
			l++;
			check(l);
		}
		return Math.max(l,0);
	}
	void check(int l)
	{
		if(l==0)
		{
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n-1;j++)
				{
					if(level[i].charAt(j)=='X' && level[i].charAt(j+1)=='X')
					{
						link(i*n+j,i*n+j+1);
					}
				}
			}
		}
		else
		{
			for(int i=0;i<m-l;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(level[i].charAt(j)=='X' && level[i+l].charAt(j)=='X')
					{
						link(i*n+j,i*n+j+l*n);
					}
				}
			}
			
		}
	}
	boolean isSameSet(int a,int b)
	{
		return root(a)==root(b);
	}
	void link(int a,int b)
	{
		disj[root(b)]=root(a);
	}
	int root(int a)
	{
		if(a!=disj[a])
		{
			return disj[a]=root(disj[a]);
		}
		return a;
	}
}
//SRM