import java.util.*;
public class TheExperiment {
	int MOD=1000000009;
	int[] vp;
	int n;
	int m,l,a,b;
	Set<Integer> full;
	public int countPlacements(String[] intensity, int M, int L, int A, int B) {
		StringBuilder sb=new StringBuilder();
		for(final String st:intensity)
		{
			sb.append(st);
		}
		vp=new int[sb.length()];
		int c=0;
		for(char ch:sb.toString().toCharArray())
		{
			vp[c++]=ch-'0';
		}
		n=vp.length;
		full=new HashSet<Integer>((int)(n/0.7));
		for(int i=0;i<n;i++)
		{
			full.add(i);
		}
		m=M;
		l=L;
		a=A;
		b=B;
		return dp2(0,0,2);
	}
	int dp(Set<Integer> set,int sps)
	{
		if(n<=6)
			System.out.println(set+","+sps);
		if(sps==m)
		{
			return 1;
		}
		Set<Integer> range=new HashSet<Integer>();
		int count=0;
		int total=0;
		for(int i=0;i<l;i++)
		{
			if(set.contains(i))
			{
				range.add(i);
				total+=vp[i];
			}
		}
		for(int i=0;i<=n-l;i++)
		{
			if(n<=6)
				System.out.println("("+range+","+total+" in "+set+")");
			if(total>=a && total<=b)
			{
				Set<Integer> copy=new HashSet<Integer>(set);
				copy.removeAll(range);
				int sub=dp(copy,sps+1);
				count+=sub;
			}
			if(range.remove(i))
			{
				total-=vp[i];
			}
			if(set.contains(i+l))
			{
				range.add(i+l);
				total+=vp[i+l];
			}
		}
		return count;
	}
	HashMap<Integer, Integer> memo=new HashMap<Integer,Integer>();
	int dp2(int start,int sps,int top)
	{
		int canon=(start*(m+1)+sps)*4+top;
		if(memo.containsKey(canon))
		{
			return memo.get(canon);
		}
		if(n<=18)
			System.out.println("(n="+n+","+start+","+sps+","+top+")");
		if(sps==m)
		{
			if(n<=18)
				System.out.println('*');
			return top!=0?1:0;
		}
		if(start>=n)
		{
			return 0;
		}
		int count=0;
		int total=0;
		for(int i=0;i<=l && start+i<=n;i++)
		{
			if(i>=1 && total>=a && total<=b)
			{
				int newtop;
				if(top!=1)
				{
					newtop=i==l?1:0;
				}
				else
					newtop=top;
				int sub=dp2(start+i,sps+1,newtop);
				count+=sub;
				count%=MOD;
			}
			if(start+i<n)
			{
				total+=vp[start+i];
			}
		}
		if(start<n && top!=0)
		{
			int sub=dp2(start+1,sps,2);
			count+=sub;
			count%=MOD;
		}
		memo.put(canon,count);
		return count;
	}
}
//SRM576 div1 medium