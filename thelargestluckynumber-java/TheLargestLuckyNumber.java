public class TheLargestLuckyNumber {

	public int find(int n) {
		if(n<=3)return 0;
		if(n%10<=3)return find(n/10-1)*10+7;
		if(n%10<=6)
		{
			int f=find(n/10);
			if(n/10==f)
				return f*10+4;
			return f*10+7;
		}
		return find(n/10)*10+7;
	}

}
//srm 403 div 2 easy