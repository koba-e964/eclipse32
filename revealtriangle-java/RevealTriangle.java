public class RevealTriangle {

	public String[] calcTriangle(String[] quest) {
		int n=quest.length;
		for(int i=n-2;i>=0;i--)
		{
			quest[i]=solve(quest[i],quest[i+1]);
		}
		return quest;
	}
	String solve(String up,String low)
	{
		int dis=-1;
		char[] res=up.toCharArray();
		for(int i=0;i<res.length;i++)
		{
			if(res[i]!='?')dis=i;
		}
		for(int i=dis-1;i>=0;i--)
		{
			int diff=low.charAt(i)-res[i+1];
			res[i]=(char)('0'+((diff+10)%10));
		}
		for(int i=dis+1;i<res.length;i++)
		{
			int diff=low.charAt(i-1)-res[i-1];
			res[i]=(char)('0'+((diff+10)%10));
		}
		System.out.println(new String(res));
		return new String(res);
	}
}
//srm 404 div2 medium