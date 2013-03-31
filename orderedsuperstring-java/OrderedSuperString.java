import java.util.*;
public class OrderedSuperString {

	public int getLength(String[] words) {
		String cur="";
		int pos=0;
		int n=words.length;
		for(int i=0;i<n;i++)
		{
			int tmp=search(cur,words[i],pos);
			if(tmp<=cur.length()-words[i].length())
			{
				pos=tmp;
				continue;
			}
			pos=tmp;
			cur=cur.substring(0,tmp)+words[i];
	}
		return cur.length();
	}
	int search(String str,String key,int start)
	{
		int sub=str.substring(start).indexOf(key);
		if(sub!=-1)
		{
			return start+sub;
		}
		final int keylen=key.length();
		final int strlen=str.length();
		for(int i=Math.max(0, keylen-strlen+start);i<keylen;i++)
		{
			if(str.substring(strlen-keylen+i).equals(key.substring(0, keylen-i)))
			{
				return strlen-keylen+i;
			}
		}
		return strlen;
	}
}
//SRM