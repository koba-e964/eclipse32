import java.util.*;

public class DancingCouples {
	int n,m;
	int k;
	String[] cd;
	public int countPairs(String[] canDance, int K) {
		k=K;
		n=canDance.length;
		m=canDance[0].length();
		cd=canDance;
		return dp(0,0,0);
	}
	HashMap<Integer,Integer> memo=new HashMap<Integer, Integer>();
	int dp(int b,int depth,int occ)
	{
		if(b>=n)
		{
			return depth==k?1:0;
		}
		if(depth==k)
		{
			return 1;
		}
		int canon=b+k*11+occ*121;
		if(memo.containsKey(canon))
		{
			return memo.get(canon);
		}
		int t=0;
		for(int i=0;i<m;i++)
		{
			if(cd[b].charAt(i)=='Y' && (occ&(1<<i))==0)
			{
				int sub=dp(b+1,depth+1,occ|(1<<i));
				t+=sub;
			}
		}
		t+=dp(b+1,depth,occ);
		memo.put(canon, t);
		return t;
	}
}
//SRM416 div2 hard