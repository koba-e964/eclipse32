import java.util.*;
import static java.lang.Math.*;
public class WolfInZooDivOne {
	int left[];
	int right[];
	int m,n;
	static final int MOD=1000000007;
	public int count(int N, String[] L, String[] R) {
		n=N;
		{
			StringBuilder sb=new StringBuilder();
			for(String t:L)
			{
				sb.append(t);
			}
			String[] res=sb.toString().split("\\s");
			m=res.length;
			left=new int[res.length];
			for(int i=0;i<res.length;i++)
			{
				left[i]=Integer.parseInt(res[i]);
			}
		}
		{
			StringBuilder sb=new StringBuilder();
			for(String t:R)
			{
				sb.append(t);
			}
			String[] res=sb.toString().split(" ");
			right=new int[res.length];
			for(int i=0;i<res.length;i++)
			{
				right[i]=Integer.parseInt(res[i]);
			}
		}
		return new Correct().count(N, left, right);
	}

}
class Correct
{
	int[] end;
	int n;
	int m;
	int count(int n,int left[],int right[])
	{
		this.n=n;
		m=left.length;
		end=new int[n];
		for(int i=0;i<n;i++)
		{
			end[i]=-1;
		}
		for(int i=0;i<m;i++)
		{
			int l=left[i];
			if(end[l]==-1)
			{
				end[l]=right[i];
			}
			else
			{
				end[l]=max(end[l],right[i]);
			}
		}
		for(int i=1;i<n;i++)
		{
			end[i]=max(end[i],end[i-1]);
		}
		memo=new int[n*(n+1)*(n+2)/2];
		Arrays.fill(memo, -1);
		return dp(0,-1,-1);
	}
	int memo[];
	//memo: 0<=pos<=n-1, -1<=last1<=last2<=n-1
	int dp(int pos,int last1,int last2)
	{
		if(pos==n)
		{
			return 1;
		}
		int canon=pos+n*((2*n+2-last1)*(last1+1)/2+(last2-last1));
		if(memo[canon]!=-1)
		{
			return memo[canon];
		}
		int r=dp(pos+1,last1,last2);
		if(last1==-1 || end[last1]<pos)
		{
			r+=dp(pos+1,last2,pos);
			r%=WolfInZooDivOne.MOD;
		}
		if(n==5)
			System.out.println("pos="+pos+", last1="+last1+", last2="+last2+", res="+r);
		memo[canon]=r;
		return r;
	}
}
//SRM578 Div1 Medium