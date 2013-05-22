package kobae964_app.algo;

import java.util.Arrays;

public class Assignment {

	public int[] match(int[][] cost)
	{
		m = cost   .length;
		n = cost[0].length;
		c=new int[m][];
		for(int i=0;i<m;i++)
		{
			c[i]=Arrays.copyOf(cost[i], n);
		}
		for(int x=0;x<m;x++)
		{
			int min=Integer.MAX_VALUE;
			for(int y=0;y<n;y++)
			{
				min=Math.min(min,c[x][y]);
			}
			for(int y=0;y<n;y++)
			{
				c[x][y]-=min;
			}
		}
		for(int y=0;y<n;y++)
		{
			int min=Integer.MAX_VALUE;
			for(int x=0;x<m;x++)
			{
				min=Math.min(min, c[x][y]);
			}
			for(int x=0;x<m;x++)
			{
				c[x][y]-=min;
			}
		}
		while(true)
		{
			int[] res=zeroMatch();
			boolean ok=true;
			for(int i=0;i<res.length;i++)
			{
				if(res[i]==-1)ok=false;
			}
			if(ok)return res;
		}
	}
	private int[] zeroMatch()
	{
		boolean[][] edges=new boolean[m][n];
		for(int x=0;x<m;x++)
		{
			for(int y=0;y<n;y++)
			{
				edges[x][y]=c[x][y]==0;
			}
		}
		return new BipartiteMatch(edges).match();
	}
	int[][]c;
	private int m;
	private int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
