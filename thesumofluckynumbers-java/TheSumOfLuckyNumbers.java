import java.util.ArrayList;
import java.util.List;

public class TheSumOfLuckyNumbers {
	int [] memo;
	int [] back;
	public int[] sum(int n) {
		memo=new int[1000001];
		back=new int[1000001];
		mkLucky();
		for(int i:lucky)
		{
			System.out.println(i);
		}
		for(int i=0;i<memo.length;++i)
		{
			memo[i]=-1;
			back[i]=-1;
		}
		memo[0]=0;
		back[0]=0;
		for(int i=4;i<n;i++)
		{
			dp(i);
		}
		List<Integer> list=new ArrayList<Integer>();
		if(dp(n)==0)
			return new int[0];
		while(n>0)
		{
			list.add(n-back[n]);
			n=back[n];
		}
		int[] res=new int[list.size()];
		for(int i=0;i<res.length;i++)
		{
			res[i]=list.get(i);
		}
		return res;
	}
	int dp(int val)//0:impossible
	{
		if(val<=3)return 0;
		if(memo[val]>=0)return memo[val];
		int l=4;
		int min=-1;
		int minval=-1;
		int c=0;
		for(;c<S && lucky[c]<=val;c++)
		{
			l=lucky[c];
			if(l==val)
			{
				memo[val]=1;
				back[val]=0;
				return 1;
			}
			int sub=dp(val-l);
			if(sub==0)continue;
			if(min==-1 || minval>sub )
			{
				min=val-l;
				minval=sub;
			}
		}
		if(min==-1)
		{
			memo[val]=0;
			back[val]=-1;
			return 0;
		}
		memo[val]=minval+1;
		back[val]=min;
		return memo[val];
	}
	int next(int l)
	{
		if(l%10==4)return l+3;
		if(l%10==7)return next(l/10)*10+4;
		//l==0
		return 4;
	}
	int lucky[];
	int S=126;
	void mkLucky()
	{
		lucky=new int[S];
		int l=4;
		for(int i=0;i<S;i++)
		{
			lucky[i]=l;
			l=next(l);
		}
	}
}
//srm 403 div 2 hard