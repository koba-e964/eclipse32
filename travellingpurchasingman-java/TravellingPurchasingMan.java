import java.util.*;
public class TravellingPurchasingMan {
	int n;
	int m;
	int[][] dist;
	int[] open,close,dura;
	public int maxStores(int N, String[] interestingStores, String[] roads) {
		n=N;
		m=interestingStores.length;
		dist=new int[n][n];
		open=new int[m];
		close=new int[m];
		dura=new int[m];
		for(int[] row:dist)
		{
			Arrays.fill(row, -1);
		}
		for(int i=0;i<m;i++)
		{
			String[] split=interestingStores[i].split(" ");
			open[i]=Integer.parseInt(split[0]);
			close[i]=Integer.parseInt(split[1]);
			dura[i]=Integer.parseInt(split[2]);
		}
		for(String road:roads)
		{
			String[] split=road.split(" ");
			int a=Integer.parseInt(split[0]);
			int b=Integer.parseInt(split[1]);
			int l=Integer.parseInt(split[2]);
			dist[a][b]=dist[b][a]=l;
		}
		return 0;
	}
	HashMap<Long,Integer> memo=new HashMap<Long, Integer>();
	int dp(long bits,int cur)
	{
		assert (bits&((-1L)<<m))==0;
		long canon=bits|(cur<<16L);
		if(memo.containsKey(canon))
		{
			return memo.get(canon);
		}
		return 0;
	}

}
//SRM 579 div1 medium(450)
