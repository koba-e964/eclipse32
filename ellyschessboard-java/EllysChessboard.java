import java.util.*;
import static java.lang.Math.*;
public class EllysChessboard {
	int[][] dist;
	long bb=0;
	int[] dis;
	Comparator<Integer> mdComp=new Comparator<Integer>() {
		
		public int compare(Integer o1, Integer o2) {
			int i1=o1>>>8;
			int j1=o1%64;
			int i2=o2>>>8;
			int j2=o2%64;
			return dist[i1][j1]-dist[i2][j2];
		}
	};
	public int minCost(String[] board) {
		return new Correct().minCost(board);
	}
	public int myMinCost(String[] board) {
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(board[i].charAt(j)=='#')
					bb|=1L<<(8*i+j);
			}
		}
		List<Integer> edges=new ArrayList<Integer>(4096);
		dist=new int[64][64];
		for(int i=0;i<64;i++)
		{
			for(int j=i+1;j<64;j++)
			{
				if((bb&(1L<<i))!=0 && (bb&(1L<<j))!=0)
				{
					dist[i][j]=dist[j][i]=getDist(i,j);
					edges.add(i<<8|j);
				}
				else
					dist[i][j]=-1;
			}
		}
		Collections.sort(edges, mdComp);
		dis=new int[64];
		for(int i=0;i<64;i++)
		{
			dis[i]=i;
		}
		int total=0;
		for(int edge:edges)
		{
			int i=edge>>>8;
			int j=edge%64;
			System.out.println("i="+i+", j="+j);
			if(!inSameSet(i,j))
			{
				link(i,j);
				System.out.println("link:("+i+","+j+") dist="+dist[i][j]);
				total+=dist[i][j];
			}
		}
		return total;
	}
	static int getDist(int i,int j)
	{
		int x0=i%8;
		int x1=j%8;
		int y0=i/8;
		int y1=j/8;
		
		int res=Math.abs(x0-x1)+Math.abs(y0-y1);
		return res;
	}
	int root(int r)
	{
		if(dis[r]!=r)
		{
			return dis[r]=root(dis[r]);
		}
		return r;
	}
	void link(int a,int b)
	{
		dis[root(b)]=root(a);
	}
	boolean inSameSet(int  a,int b)
	{
		return root(a)==root(b);
	}

}
class Correct
{
	boolean[][] bb;
	int minCost(String[] board)
	{
		bb=new boolean[15][15];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				bb[i+j][7-i+j]=board[i].charAt(j)=='#';
			}
		}
		return dp(0,15,0,15);
	}
	static final int INF=Integer.MAX_VALUE;
	HashMap<Integer, Integer> memo=new HashMap<Integer, Integer>();
	int dp(int x0,int x1,int y0,int y1)
	{
		if(x0>=x1 || y0>=y1)
		{
			return 0;
		}
		int canon=x0|(x1<<4)|(y0<<8)|(y1<<12);
		if(memo.containsKey(canon))
		{
			return memo.get(canon);
		}
		int ret=INF;
		int tmp;
		tmp=dp(x0+1,x1,y0,y1);
		for(int i=y0;i<y1;i++)
		{
			if(bb[x0][i])tmp+=Math.max(x1-x0-1,Math.max(y1-1-i, i-y0));
		}
		ret=min(ret,tmp);
		tmp=dp(x0,x1-1,y0,y1);
		for(int i=y0;i<y1;i++)
		{
			if(bb[x1-1][i])tmp+=Math.max(x1-x0-1,Math.max(y1-1-i, i-y0));
		}
		ret=min(ret,tmp);
		tmp=dp(x0,x1,y0+1,y1);
		for(int i=x0;i<x1;i++)
		{
			if(bb[i][y0])tmp+=Math.max(y1-y0-1,Math.max(x1-1-i, i-x0));
		}
		ret=min(ret,tmp);
		tmp=dp(x0,x1,y0,y1-1);
		for(int i=x0;i<x1;i++)
		{
			if(bb[i][y1-1])tmp+=Math.max(y1-y0-1,Math.max(x1-1-i, i-x0));
		}
		ret=min(ret,tmp);
		memo.put(canon, ret);
		return ret;
	}
}
//SRM577 div1 medium