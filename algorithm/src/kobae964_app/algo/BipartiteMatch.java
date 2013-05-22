package kobae964_app.algo;

import java.util.Arrays;

class BipartiteMatch
{
	final boolean[][] edges;
	final int m,n;
	BipartiteMatch(boolean[][] edges)
	{
		m=edges.length;
		n=edges[0].length;
		this.edges=Arrays.copyOf(edges, m);
		for(int i=0;i<edges.length;i++)
		{
			this.edges[i]=Arrays.copyOf(edges[i],n);
		}
	}
	boolean[] v;
	int[] p;
	int[] match()
	{
		p=new int[n];
		Arrays.fill(p, -1);
		v=new boolean[n];
		for(int i=0;i<m;i++)
		{
			Arrays.fill(v,false);
			matchSub(i);
		}
		int[] ret=new int[m];
		Arrays.fill(ret, -1);
		for(int i=0;i<n;i++)
		{
			if(p[i]>=0)
				ret[p[i]]=i;
		}
		return ret;
	}
	int matchSub(int start)
	{
		if(start>=m)
			throw new IllegalArgumentException();
		for(int i=0;i<n;i++)
		{
			if(v[i])continue;
			v[i]=true;
			if(edges[start][i])
			{
				if(p[i]==-1)
				{
					p[i]=start;
					return 1;
				}
				else if(p[i]!=start)
				{
					int res=matchSub(p[i]);
					if(res>0)
					{
						p[i]=start;
						return 1;
					}
				}
			}
			v[i]=false;
		}
		return 0;
	}
	
}