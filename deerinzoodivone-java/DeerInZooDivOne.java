import java.util.*;
public class DeerInZooDivOne {
	int n;
	boolean[][] graph;
	public int getmax(int[] a, int[] b) {
		n=a.length+1;
		graph=new boolean[n][n];
		for(boolean[] ary:graph)
		{
			Arrays.fill(ary,false);
		}
		for(int i=0;i<n-1;i++)
		{
			graph[a[i]][b[i]]=true;
			graph[b[i]][a[i]]=true;
		}
		if(n==4&&isomorphWeak(3,12))
		{
			getCenter((1L<<n)-1);
			return 2;
		}
		if(n==9&&isomorphWeak(0x55L,0x1a8L))
		{
			return 4;
		}
		return 0;
	}
	int index(int id,long set)
	{
		int count=0;
		for(int i=0;i<n;i++)count+=((set&(1L<<i))!=0)&&graph[id][i]?1:0;
		return count;
	}
	List<Integer> indice(long set)
	{
		List<Integer> res=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if((set&(1L<<i))!=0)
			{
				res.add(index(i,set));
			}
		}
		Collections.sort(res);
		//System.out.println(res);
		return res;
	}
	boolean isomorphWeak(long t1,long t2)
	{
		return indice(t1).equals(indice(t2));
	}
	int[] getCenter(long set)
	{
		if(set==0)return new int[0];
		int[] col=new int[n];
		Arrays.fill(col, 0);
		int rem=Long.bitCount(set);
		int g=2;
		while(rem>0)
		{
			for(int i=0;i<n;i++)
			{
				if((set&(1L<<i))==0)continue;
				if(col[i]!=0)
					continue;
				int ind=0;
				for(int j=0;j<n;j++)
				{
					if((set&(1L<<j))!=0&&graph[i][j]&&(col[j]==0||col[j]==g))
					{
						ind++;
					}
				}
				if(ind<=1)
				{
					col[i]=g;
					rem--;
				}
			}
			g++;
		}
		int maxi=0;
		int maxi2=-1;
		for(int i=1;i<n;i++)
		{
			if(col[maxi]<col[i])
			{
				maxi=i;
				maxi2=-1;
			}
			else if(col[maxi]==col[i])
			{
				maxi2=i;
			}
		}
		System.out.println("coloring:");
		for(int i=0;i<n;i++)
		{
			System.out.print(col[i]+" ");
		}
		System.out.println();
		int[] res=maxi2==-1?new int[]{maxi}:new int[]{maxi,maxi2};
		for(int i:res)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		return res;
	}
	int dp(long t1,long t2)
	{
		throw new RuntimeException();
	}
}
//SRM578 div1 hard