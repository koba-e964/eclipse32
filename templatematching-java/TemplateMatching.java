import java.lang.annotation.Inherited;
import java.util.*;
public class TemplateMatching {
	String text,pre,suf;
	int pl,sl;
	public String bestMatch(String text, String prefix, String suffix) {
		this.text=text;
		pre=prefix;
		pl=pre.length();
		suf=suffix;
		sl=suf.length();
		int n=text.length();
		Res max=null;
		String maxs=null;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<=n;j++)
			{
				String tmp=text.substring(i,j);
				Res res=judge(tmp);
				if(max==null || max.compareTo(res)<0)
				{
					max=res;
				}
			}
		}
		System.out.println("p="+max.p+", s="+max.s+", str="+max.str);
		return max.str;
	}
	Res judge(String a)
	{
		int p=0;int s=0;
		int al=a.length();
		for(int i=1;i<=Math.min(al, pl);i++)
		{
			if(pre.substring(pl-i).equals(a.substring(0,i)))
			{
				p=i;
			}
		}
		for(int i=1;i<=Math.min(al, sl);i++)
		{
			if(suf.substring(0,i).equals(a.substring(al-i)))
			{
				s=i;
			}
		}
		return new Res(p,s,a);
	}
	static class Res implements Comparable<Res>
	{
		int p,s;
		String str;
		Res(int p,int s,String str)
		{
			this.p=p;
			this.s=s;
			this.str=str;
		}
		public int compareTo(Res o) {
			if(p+s!=o.p+o.s)
			{
				return p+s-o.p-o.s;
			}
			if(p!=o.p)
				return p-o.p;
			return -str.compareTo(o.str);
		}
		
	}
}
//SRM