import java.util.*;
public class CheapestRoute {

	int n;
	int enter[],exit[];
	int m;
	int cp[];
	int tp;
	public int[] routePrice(int[] cellPrice, int[] enterCell, int[] exitCell, int teleportPrice) {
		n=cellPrice.length;
		m=enterCell.length;
		tp=teleportPrice;
		cp=cellPrice;
		enter=enterCell;
		exit=exitCell;
		cs=new int[n][m+1];
		ps=new int[n][m+1];
		dec=new boolean[n][m+1];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m+1;j++)
			{
				cs[i][j]=-1;
				ps[i][j]=-1;
				dec[i][j]=false;
			}
		}
		dp();
		if(n<=5)
		{
			for(int i=0;i<n;i++)
			{
				System.out.print(i+":");
				for(int j=0;j<=m;j++)
				{
					System.out.print("("+cs[i][j]+","+ps[i][j]+") ");
				}
				System.out.print("\n");
			}
		}
		int minm=-1;
		for(int i=0;i<=m;i++)
		{
			if(cs[n-1][i]<0)continue;
			if(minm==-1)
			{
				minm=i;
				continue;
			}
			if(cs[n-1][minm]>cs[n-1][i] || (cs[n-1][minm]==cs[n-1][i] && ps[n-1][minm]>ps[n-1][i]))
			{
				minm=i;
			}
		}
		return minm>=0 ? new int[]{cs[n-1][minm],ps[n-1][minm]}:new int[0];
	}
	int cs[][];
	int ps[][];
	boolean dec[][];
	final int INF=0x7fffffff;
	void dp()
	{
		Set<Integer> undec=new HashSet<Integer>();
		undec.add(0);
		cs[0][0]=0;
		ps[0][0]=0;
		while(undec.size()>=1)
		{
			int mini=-1;
			int minm=-1;
			for(int ind_mult:undec)
			{
				int ind=ind_mult&0xffff;
				int world=ind_mult>>>16;
				if(ind>=n || world >= m+1)
					continue;
				if(mini==-1 || (cs[mini][minm]>cs[ind][world]) || (cs[mini][minm]==cs[ind][world] && ps[mini][minm]>ps[ind][world]))
				{
					mini=ind;
					minm=world;
				}
			}
			if(mini==-1)
			{
				throw new AssertionError();
			}
			//minimum distance	
			dec[mini][minm]=true;
			undec.remove(mini|(minm<<16));
			if(mini>=1)
			{
				if(cp[mini-1]>=0 && !dec[mini-1][minm])
				{
					undec.add((mini-1)|(minm<<16));
					koushin(mini-1,minm,cs[mini][minm]+cp[mini-1],ps[mini][minm]+1);
				}
			}
			if(mini<=n-2)
			{
				if(cp[mini+1]>=0 && !dec[mini+1][minm])
				{
					undec.add((mini+1)|(minm<<16));
					koushin(mini+1,minm,cs[mini][minm]+cp[mini+1],ps[mini][minm]+1);
				}
			}
			if(minm==m)
				continue;
			for(int i=0;i<m;i++)
			{
				if(enter[i]==mini && cp[exit[i]]>=0 && !dec[exit[i]][minm+1])
				{
					undec.add(exit[i]|((minm+1)<<16));
					koushin(exit[i],minm+1,cs[mini][minm]+tp+minm,ps[mini][minm]+1);
				}
			}
		}
	}
	void koushin(int ind,int world,int c,int p)
	{
		if(cs[ind][world]==-1 || cs[ind][world]>c)
		{
			cs[ind][world]=c;
			ps[ind][world]=p;
			return;
		}
		if(cs[ind][world]==c && ps[ind][world]>p)
		{
			ps[ind][world]=p;
		}
	}

}
//SRM 407 div2 hard
