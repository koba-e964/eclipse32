import java.util.*;
public class TheNumberGameDiv2 {

	HashMap<Integer,Integer> memo=new HashMap<Integer, Integer>();
	int b;
	final int INF=0x7fffffff;
	public int minimumMoves(int A, int B) {
		b=B;
		int res=dp(A);
		if(res==INF)
			return -1;
		return res;
	}
	int dp(int val)
	{
		if(val==b)
		{
			memo.put(b,0);
			return 0;
		}
		if(val<=b/10)
		{
			return 0x7fffffff;
		}
		if(rev(val)==b)
		{
			return 1;
		}
		if(memo.containsKey(val))
		{
			return memo.get(val);
		}
		int min=0x7fffffff;
		int sub;
		sub=dp(rev(val)/10);
		if(sub!=INF)
		{
			min=sub+2;
		}
		sub=dp(val/10);
		if(sub != INF && min>sub+1)
		{
			min=sub+1;
		}
		memo.put(val,min);
		return min;
	}
	static int rev(int val)
	{
		int tmp=0;
		while(val>0)
		{
			tmp*=10;
			tmp+=val%10;
			val/=10;
		}
		return tmp;
	}
}
//SRM