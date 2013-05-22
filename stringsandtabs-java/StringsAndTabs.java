import java.util.*;
public class StringsAndTabs {
	public class Str implements Comparable<Str>
	{
		int num;
		int[] pitch;
		Str(int[] pitch,int n)
		{
			this.pitch=pitch;
			num=n;
		}
		boolean accept(int p)
		{
			int diff=p-pitch[num];
			return diff>=0 && diff<36;
		}
		public int compareTo(Str o) {
			if(pitch!=o.pitch)
			{
				throw new IllegalArgumentException();
			}
			if(pitch[num]!=pitch[o.num])
			{
				return -pitch[num]+pitch[o.num];
			}
			return -num+o.num;
		}
		@Override
		public boolean equals(Object o)
		{
			if(!(o instanceof Str))
			{
				return false;
			}
			Str another=(Str)o;
			return pitch==another.pitch && num==another.num;
		}
		
	}
	int n;
	String[] tab;
	int[] sb;
	TreeSet<Str> sbs;
	public String[] transformTab(String[] tab, int[] stringsA, int[] stringsB, int d) {
		this.n=tab.length;
		this.tab=tab;
		int []sa=stringsA;
		sb=stringsB;
		char[][] res=new char[sb.length][tab[0].length()];
		sbs=new TreeSet<StringsAndTabs.Str>();
		for(int i=0;i<sb.length;i++)
		{
			sbs.add(new Str(sb,i));
		}
		for(int i=0,l=tab[0].length();i<l;i++)
		{
			TreeSet<Integer> notes=new TreeSet<Integer>();
			List<Integer> notes2=new ArrayList<Integer>();
			for(int j=0;j<n;j++)
			{
				char ch=tab[j].charAt(i);
				if(ch!='-')
				{
					notes.add(dec(ch)+sa[j]+d);
					notes2.add(dec(ch)+sa[j]+d);
				}
			}
			Collections.sort(notes2);
			char[] map=map(notes2);
			for(int k=0;k<sb.length;k++)
			{
				res[k][i]=map[k];
			}
			notes.clear();
			notes=null;
		}
		String[] out=new String[sb.length];
		for(int i=0;i<sb.length;i++)
		{
			out[i]=new String(res[i]);
		}
		return out;
	}
	char[] map(List<Integer> notes)
	{
		char[] err=new char[sb.length];
		for(int i=0;i<err.length;i++)
		{
			err[i]='x';
		}
		if(notes.size()>sb.length)
		{
			return err;
		}
		if(notes.size()==0)
		{
			char[] out=new char[sb.length];
			for(int i=0;i<out.length;i++)
			{
				out[i]='-';
			}
			return out;
		}
		int ar[]=new int[notes.size()];
		int c=0;
		Collections.reverse(notes);
		for(final int nm:notes)
		{
			ar[c]=nm;
			c++;
		}
		char[] out=new char[sb.length];
		for(int i=0;i<out.length;i++)
		{
			out[i]='-';
		}
		int x=0;
		Iterator<Str> y=sbs.iterator();
		Str cur=null;
		while(x<ar.length)
		{
			if(cur==null)
			{
				if(!y.hasNext())
					break;
				cur=y.next();
			}
			if(cur.accept(ar[x]))
			{
				out[cur.num]=enc(ar[x]-sb[cur.num]);
				cur=null;
				x++;
				continue;
			}
			cur=null;
		}
		if(x<ar.length)
			return err;
		return out;
	}
	int dp(int[] nt,int start,long bits)
	{
		return 0;
	}
	static int dec(char ch)
	{
		if(ch>='0' && ch<='9')
		{
			return ch-'0';
		}
		if(ch>='A' && ch<='Z')
			return ch-'A'+10;
		throw new IllegalArgumentException();
	}
	static char enc(int val)
	{
		if(0<=val && val<=9)
			return (char)('0'+val);
		if(10<=val && val<=35)
		{
			return (char)('A'+(val-10));
		}
		throw new IllegalArgumentException();
	}
}
//SRM412 div2 hard