public class TheLuckyNumbers {

	public int count(int a, int b) {
		return dp(b)-dp(a-1);
	}
	public int dp(int val)
	{
		int[]tbl={0,0,0,0,1,1,1,2,2,2};
		if(val<=9)return tbl[val];
		int d=dp(val/10);
		if(lucky(val/10))
		{
			return 2*d-2+tbl[val%10]+2;
		}
		return 2*d+2;
		
	}
	boolean lucky(int val)
	{
		if(val<=9)return val==4 || val==7;
		return lucky(val/10)&&lucky(val%10);
	}
}
//srm 403 div 2 medium