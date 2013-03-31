package kobae964_app.algo;

import java.util.Random;

public class RandomContraction {

	public RandomContraction()
	{
		
	}
	int[][] graph;
	int n;
	Random rand;
	public int[] action(int[][] graph)
	{
		this.graph=graph;
		n=graph.length;
		rand=new Random();
		return null;
	}
	int[] contract()
	{
		int [] conn=new int[n];
		for(int i=0;i<n;i++)
		{
			conn[i]=i;
		}
		//contract
		for(int t=0;t<n-2;t++)
		{
			
		}
		return null;
	}
	int random(int[] conn,int rem)
	{
		int val=rand.nextInt(rem);
		int cur=0;
		for(int i=0;i<val+1;)
		{
			if(conn[cur]==cur)
			{
				if(i==val)
				{
					break;
				}
			}
		}
		return val;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
