import java.util.*;
public class SentenceDecomposition {
	String[] vw;
	String sent;
	final static int INF=0x7fffffff;
	public int decompose(String sentence, String[] validWords) {
		Arrays.sort(validWords);
		vw=validWords;
		sent=sentence;
		int res=dp(0);
		return res==INF?-1:res;
	}
	HashMap<Integer, Integer> memo=new HashMap<Integer, Integer>();
	int dp(int start)
	{
		if(sent.length()==start)
		{
			return 0;
		}
		if(memo.containsKey(start))
		{
			return memo.get(start);
		}
		int min=0x7fffffff;
		for(int i=0;i<vw.length;i++)
		{
			int l=vw[i].length();
			if(sent.length()<start+l)
			{
				continue;
			}
			String str1=sent.substring(start,start+l);
			if(rear(str1,vw[i]))
			{
				int sub=dp(start+l);
				if(sub==INF)continue;
				sub+=diff(str1,vw[i]);
				if(min>sub)
					min=sub;
			}
		}
		memo.put(start, min);
		return min;
	}
	boolean rear(String a,String b)
	{
		if(a.length()!=b.length())return false;
		int count[]=new int[0x100];
		for(char ch:a.toCharArray())
		{
			count[ch]++;
		}
		for(char ch:b.toCharArray())
		{
			count[ch]--;
		}
		for(int c:count)
		{
			if(c!=0)return false;
		}
		return true;
	}
	int diff(String a,String b)
	{
		int count=0;
		for(int i=0,l=a.length();i<l;i++)
		{
			count+=a.charAt(i)!=b.charAt(i)?1:0;
		}
		return count;
	}
}
//SRM411 div2 medium