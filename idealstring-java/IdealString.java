import java.util.*;
public class IdealString {

	public String construct(int length) {
		init();
		StringBuilder sb=new StringBuilder();
		dp(length);
		if(back[length]==-1)
		{
			return "";
		}
		List<Integer> list=new ArrayList<Integer>();
		int back=length;
		while(back>0)
		{
			int back2=this.back[back];
			if(back2<=0)
			{
				if(back!=1 || back<0)
				{
					throw new AssertionError();
				}
				list.add(0,1);
			}
			else
				list.add(0, back-back2);
			back=back2;
		}
		for(int i=0,ls=list.size();i<ls;i++)
		{
			int li=list.get(i);
			sb.insert(li-1, (char)('A'+i));
			for(int j=1;j<li;j++)
			{
				sb.append((char)('A'+i));
			}
		}
		return sb.toString();
	}
	int memo[];
	int back[];
	void init()
	{
		memo=new int[101];
		back=new int[101];
		for(int i=0;i<=100;i++)
		{
			memo[i]=-1;
			back[i]=-1;
		}
	}
	int dp(int len)
	{
		if(len==0)
		{
			return 0;
		}
		if(len==1)
		{
			memo[len]=1;
			back[len]=0;
			return 1;
		}
		if(memo[len]>=0)
			return memo[len];
		int min=-1;
		for(int i=1;i<len;i++)
		{
			int diff=len-i;
			int sub=dp(i);
			if(sub<=0 || diff<=i-back[i] || diff >= i+2)
				continue;
			if(min==-1 || memo[min]>=memo[i])
				min=i;
		}
		if(min<0)
		{
			memo[len]=0;
			back[len]=-1;
			return 0;
		}
		int count=memo[min]+1;
		memo[len]=count;
		back[len]=min;
		return memo[len];
	}
}
//SRM405 div2 hard