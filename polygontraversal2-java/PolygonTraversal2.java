import java.util.*;
public class PolygonTraversal2 {
	int n;
	int m;
	int pts[];
	public int count(int N, int[] points) {
		n=N;
		pts=points;
		m=pts.length;
		boolean[] oc=new boolean[n];
		for(int p:points)
		{
			oc[p-1]=true;
		}
		int[] perm=new int[n-points.length];
		for(int i=0,c=0;i<n;i++)
		{
			if(!oc[i])
			{
				perm[c]=i;
				c++;
			}
		}
		edges=new int[n];
		int bits=0;
		for(int p:points)
		{
			bits|=1<<(p-1);
		}
		System.out.println("n="+n);
		int res=dp(bits,points[m-1]-1);
		return res;
	}
	int[] edges;
	int check(int[] perm)
	{
		return 0;
	}
	HashMap<Integer,Integer> memo=new HashMap<Integer,Integer>();
	int dp(int bits,int prev)
	{
		int canonical=bits|(prev<<15);
		if(memo.containsKey(canonical))
		{
			return memo.get(canonical);
		}
		if(bits==(1<<n)-1)
		{
			int diff=prev-(pts[0]-1);
			diff+=n;
			diff%=n;
			int res=(diff==1 || diff==n-1)?0:1;
			return res;
			
		}
		int sum=0;
		for(int i=0;i<n;i++)
		{
			if((bits&(1<<i))!=0)continue;
			if(!intersect(bits,prev,i))continue;
			int sub=dp(bits|(1<<i),i);
			sum+=sub;
		}
		memo.put(canonical, sum);
		return sum;
	}
	boolean intersect(int bits,int st,int end)//st in bits, end not in bits
	{
		if(st<end)
		{
			//doesn't include
			int res = (bits^(1<<st))&((1<<end)-(1<<st));
			if(res==(bits^(1<<st)))
				return false;
			if(res==0)return false;
			return true;
		}
		if(st>end)
		{
			//doesn't include
			int res = (bits^(1<<st))&((1<<st)-(1<<end));
			if(res==(bits^(1<<st)))
				return false;
			if(res==0)return false;
			return true;
		}
		throw new AssertionError();
	}
}
//SRM