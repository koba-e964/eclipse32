package kobae964_app.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
	int[][] matrix;
	/**
	 *mat[i][j]==-1
	 * @param mat
	 */
	public Dijkstra(int[][] mat)
	{
		matrix=mat;
	}
	public void initializeByEdges(int numNodes,int[] starts,int ends[],int[] distances)
	{
		int m=starts.length;
		if(ends.length!=m)
		{
			throw new IllegalArgumentException("starts.length != ends.lengths");
		}
		if(distances.length!=m)
		{
			throw new IllegalArgumentException("starts.length != distances.lengths");
		}
		this.matrix=new int[numNodes][numNodes];
		for(int[] row:matrix)
		{
			Arrays.fill(row, -1);
		}
		for(int i=0;i<m;i++)
		{
			checkBounds(starts[i],0,numNodes);
			checkBounds(ends[i],0,numNodes);
			checkBounds(distances[i],0,Integer.MAX_VALUE);
			matrix[starts[i]][ends[i]]=distances[i];
		}
	}
	private void checkBounds(int val,int min,int sup)
	{
		if(val<min || val>=sup)
		{
			new IllegalArgumentException();
		}
	}
	public int shortest(int start,int end)
	{
		checkBounds(end,0,matrix.length);
		return shortests(start)[end];
	}
	public int[] shortests(int start)
	{
		int n=matrix.length;
		Set<Integer> undec=new HashSet<Integer>();
		undec.add(start);
		int[] sh2 = new int[n];
		boolean[] dec2 = new boolean[n];
		for(int i=0;i<n;i++)
		{
			dec2[i]=false;
			sh2[i]=-1;
		}
		sh2[start]=0;
		while(undec.size()>0)
		{
			//mini :the node in undec whose distance is smallest
			int mini=-1;
			for(int i:undec)
			{
				if(sh2[i]>=0 &&(mini<0 || sh2[mini]>sh2[i]))
				{
					mini=i;
				}
			}
			if(mini<0)
			{
				throw new AssertionError();
			}
			dec2[mini]=true;
			for(int i=0;i<n;i++)
			{
				if(!dec2[i] && matrix[mini][i]>=0)
				{
					undec.add(i);
					if(sh2[i]<0 || matrix[mini][i]+sh2[mini]<sh2[i])
					{
						sh2[i]=matrix[mini][i]+sh2[mini];
					}
				}
			}
			undec.remove(mini);
		}
		return sh2;
	}
}
