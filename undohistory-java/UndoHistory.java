import java.util.*;
public class UndoHistory {

	public int minPresses(String[] lines) {
		int sum=0;
		memo.put("", 0);
		for(String l:lines)
		{
			int res=get(l)+1;
			sum+=res;
			cur=l;
		}
		return sum;
	}
	String cur="";
	HashMap<String,Integer> memo=new HashMap<String, Integer>();
	int get(String buff)
	{
		int c=longest(buff);
		boolean nodel=false;
		if(buff.startsWith(cur)&&c<cur.length()+2)
		{
			nodel=true;
		}
		for(int i=c;i<=buff.length();i++)
		{
			memo.put(buff.substring(0,i),0);
		}
		return buff.length()+(nodel?-cur.length():-c+2);
	}
	int longest(String str)
	{
		int c;
		for(c=0;c<=str.length()&&memo.containsKey(str.substring(0,c));c++){}
		if(c==0)
			throw new AssertionError();
		return c-1;
		
	}
}
//SRM 579 div1 easy
