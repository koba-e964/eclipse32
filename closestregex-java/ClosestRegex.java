import java.util.*;
public class ClosestRegex {
	class Pair
	{
		String text;
		int start;
		Pair(String t,int s)
		{
			text=t;
			start=s;
		}
		public boolean equals(Pair another)
		{
			return start==another.start && text.equals(another.text);
		}
		public int hashCode()
		{
			return text.hashCode()^start;
		}
	}
	String regex;
	String text;
	HashMap<Integer,String> memo=new HashMap<Integer, String>(0x10000);
	public String closestString(String text, String regex) {
		this.regex=regex;
		this.text=text;
		String res=sub(0,0);
		return res==null?"":res;
	}
	
	String sub(int tst,int start)
	{
		int canon=tst*64+start;
		if(regex.length()==start)
		{
			return text.length()==tst?"":null;
		}
		if(text.length()==tst)
		{
			boolean matches=true;
			for(int i=start,l=regex.length();i<l;i+=2)
			{
				if(i+1>=l || regex.charAt(i+1)!='*')
					return null;
			}
			String res="";
			return res;
		}
		if(memo.containsKey(canon))
		{
			return memo.get(canon);
		}
		String min=null;
		char c=regex.charAt(start);
		if(regex.length() >= start+2 && regex.charAt(start+1)=='*')
		{
			{
				String sub=sub(tst+1,start);
				if(sub!=null)
				{
					min=c+sub;
				}
				sub=sub(tst,start+2);
				if(sub!=null)
				{
					if(min==null)
					{
						min=sub;
					}
					else
					{
						int dst=diff(sub,text.substring(tst));
						int dmt=diff(min,text.substring(tst));
						if(dst<dmt||(dst==dmt && sub.compareTo(min)<0))
						{
							min=sub;
						}
					}
				}
			}
			memo.put(canon, min);
			return min;
		}
		//regex:ab????
		String sub=sub(tst+1,start+1);
		if(sub==null)
		{
			min=null;
		}
		else
			min=c+sub;
		memo.put(canon, min);
		return min;
		
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
//SRM