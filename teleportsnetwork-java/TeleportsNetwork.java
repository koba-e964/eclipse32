import java.util.*;
public class TeleportsNetwork {
	int n;
	int[] cx,cy;
	int[] par;
	int tc;
	public int distribute(int teleportCount, int[] citiesX, int[] citiesY) {
		n=citiesX.length;
		cx=citiesX;
		cy=citiesY;
		par=new int[n];
		tc=teleportCount;
		for(int i=0;i<n;i++)
		{
			par[i]=-1;
		}
		int cx0=cx[0],cy0=cy[0];
		for(int i=0;i<n;i++)
		{
			cx[i]-=cx0;
			cy[i]-=cy0;
		}
		for(int i=1;i<n;i++)
		{
			int p=getClosest(i);
			if(p==-1)
				throw new InternalError();
			par[i]=p;
		}
		return n==1?0:dp(1,1,1);
	}
	final int INF=0x7fffffff;
	HashMap<Long, Integer> memo=new HashMap<Long, Integer>();
	int min=INF;
	int dp(long bits,int start,int count)
	{
		if(count>tc+1)
		{
			return INF;
		}
		if(start>n)
		{
			return INF;
		}
		if(start==n && count<tc+1)
		{
			return INF;
		}
		if(count==tc+1)
		{
			min=inconv(bits);
		}
		if(count<tc+1)
		{
			for(int i=start;i<n;i++)
			{
				if((bits&(1L<<i))!=0)
					continue;
				int sub=dp(bits|(1L<<i),i+1,count+1);
				if(min>sub)min=sub;
			}
		}
		return min;
	}
	int inconv(long bits)
	{
		long rem=bits^((1L<<n)-1);
		int cur=1;
		while(rem>0 &&cur<=min)
		{
			long dec=0;
			for(int i=0;i<n;i++)
			{
				if((rem&(1L<<i))==0)
					continue;
				if(((rem)&(1L<<par[i]))==0)
				{
					dec|=1L<<i;
				}
			}
			for(int i=0;i<n;i++)
			{
				if((rem&(1L<<par[i]))==0)
					continue;
				if(((rem)&(1L<<i))==0)
				{
					dec|=1L<<par[i];
				}
			}
			cur++;
			rem&=~dec;
		}
		return cur-1;
	}
	static long sq(int va){return (long)va*va;}
	int getClosest(int id)
	{
		long min=Long.MAX_VALUE;
		int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE;
		int mini=-1;
		for(int i=0;i<n;i++)
		{
			if(i==id)continue;
			if(sq(cx[i])+sq(cy[i])>=sq(cx[id])+sq(cy[id]))
			{
				continue;
			}
			long di=sq(cx[i]-cx[id])+sq(cy[i]-cy[id]);
			if(di<min ||(di==min&&(cx[i]<x || (cx[i]==x &&cy[i]<y))))
			{
				mini=i;
				min=di;
				x=cx[i];
				y=cy[i];
			}
		}
		return mini;
	}
}
//SRM  409 div2 hard