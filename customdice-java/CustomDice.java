import java.util.*;
public class CustomDice {
	final static int MOD=1000000007;
	int MAX;
	public int countDice(int M) {
		long res=0;//dp(6,M*6);
		MAX=6*M-5;
		memo2=new int[MAX];
		alt=new int[MAX];
		for(int i=0;i<memo2.length;i++)
		{
			memo2[i]=i;
		}
		for(int i=1;i<5;i++)
		{
			next(i+1);
		}
		for(int i=1;i<M;i++)
		{
			res+=memo2[6*i];
		}
		System.out.println();
		return (int)((res*30L%MOD));
	}
	int[] memo2;
	int[] alt;
	void next(int deg)
	{
		int[] neu=alt;
		for(int i=0;i<MAX;i++)
		{
			int c=0;
			if(i>=deg)
			{
				c=(memo2[i-deg]+neu[i-deg])%MOD;
			}
			neu[i]=c;
		}
		alt=memo2;
		memo2=neu;
	}
}
//SRM416 div1 medium
