import java.util.*;
public class ChessMatchup
{
	public int maximumScore(int[] us,int[] them)
	{
		return 0;
	}
}
class ChessMatchup_On4 {
	int n;
	private int scores[][];
	static int getScore(int u,int t)
	{
		if(u>t)return 2;
		if(u==t)return 1;
		return 0;
	}
	public int maximumScore(int[] us, int[] them) {
		n=us.length;
		scores = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				scores[i][j]=2-getScore(us[i],them[j]);
			}
		}
		for(int i=0;i<n;i++)
		{
			int min=Integer.MAX_VALUE;
			for(int v:scores[i])
			{
				min=Math.min(min, v);
			}
			for(int j=0;j<n;j++)
			{
				scores[i][j]-=min;
			}
		}
		for(int j=0;j<n;j++)
		{
			int min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				min=Math.min(min, scores[i][j]);
			}
			for(int i=0;i<n;i++)
			{
				scores[i][j]-=min;
			}
		}
		while(true)
		{
			zeroMatch();
			if(perfect())
				break;
			int min=Integer.MAX_VALUE;
			for(int x=0;x<n;x++)
			{
				for(int y=0;y<n;y++)
				{
					if((vcx&(1L<<x))==0&&(vcy&(1L<<y))==0)
					{
						min=Math.min(min, scores[x][y]);
					}
				}
			}
			for(int x=0;x<n;x++)
			{
				for(int y=0;y<n;y++)
				{
					if((vcx&(1L<<x))!=0&&(vcy&(1L<<y))!=0)
					{
						scores[x][y]+=min;
					}
					if((vcx&(1L<<x))==0&&(vcy&(1L<<y))==0)
					{
						scores[x][y]-=min;
					}
				}
			}
		}
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=getScore(us[i],them[px[i]]);
		}
		return sum;
	}
	int[] px,py;
	long vcx,vcy;
	boolean perfect()
	{
		boolean ok=true;
		for(int i=0;i<n&&ok;i++)ok=px[i]!=-1;
		return ok;
	}
	void zeroMatch()
	{
		py=new int[n];
		Arrays.fill(py, -1);
		long v=0L;
		for(int i=0;i<n;i++)
		{
			zeroMatchSub(i,v);
		}
		px=new int[n];
		Arrays.fill(px,-1);
		for(int i=0;i<n;i++)
		{
			if(py[i]>=0)
			{
				px[py[i]]=i;
			}
		}
		vcx=(1L<<n)-1;
		vcy=0L;
		for(int i=0;i<n;i++)
		{
			if(px[i]==-1)
			{
				vcSub(i);
			}
		}
	}
	boolean zeroMatchSub(int xs,long v)
	{
		for(int i=0;i<n;i++)
		{
			if(py[i]==xs)continue;
			if((v&(1L<<i))!=0)continue;
			if(scores[xs][i]!=0)continue;
			if(py[i]==-1)
			{
				py[i]=xs;
				return true;
			}
			boolean res=zeroMatchSub(py[i],v|(1L<<i));
			if(res)
			{
				py[i]=xs;
				return true;
			}
		}
		return false;
	}
	void vcSub(int x)
	{
		if((vcx&(1L<<x))==0 || px[x]!=-1)return;
		vcx&=~(1L<<x);
		for(int i=0;i<n;i++)
		{
			if( scores[x][i]==0 && (vcy&(1L<<i))==0)
			{
				vcy|=1L<<i;
				vcSub(py[i]);
			}
		}
	}
}
//SRM 371 div1 medium
