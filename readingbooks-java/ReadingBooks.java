import java.util.Arrays;

public class ReadingBooks {
	int res[];
	int n;
	public int countBooks(String[] readParts) {
		res=parse(readParts);
		memo=new int[res.length+1];
		n=res.length;
		for(int i=0;i<n+1;i++)
		{
			memo[i]=-1;
		}
		int result=dp(n);
		for(int r:res)
		{
			System.out.println("r:"+r);
		}
		return result;
	}
	int memo[];
	int dp(int end)
	{
		if(memo[end]>=0)
			return memo[end];
		if(end<=2)
			return 0;
		int max=dp(end-1);
		boolean[] comp=new boolean[3];
		for(int i=0;i<3;i++)
		{
			comp[res[end-3+i]]=true;
		}
		if(comp[0]&&comp[1]&&comp[2])
		{
			max=Math.max(max,dp(end-3)+1);
		}
		memo[end]=max;
		return max;
	}
	int[] parse(String readParts[])
	{
		int n=readParts.length;
		int[] res=new int[n];
		for(int k=0;k<n;k++)
		{
			switch(readParts[k].charAt(0))
			{
			case 'i':res[k]=0;break;
			case 's':res[k]=1;break;
			case 'e':res[k]=2;break;
			}
		}
		return res;
	}

}

//srm404 div2 easy