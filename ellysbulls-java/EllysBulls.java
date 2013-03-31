import java.util.*;
public class EllysBulls {
	int n;
	int d;
	String[] guesses;
	int[] bulls;
	public String getNumber(String[] guesses, int[] bulls) {
		this.guesses=guesses;
		this.bulls=bulls;
		n=guesses.length;
		d=guesses[0].length();
		int d10=1;
		int mid = Math.max(d-3,1);
		for(int i=0;i<d && i<mid;i++)
		{
			d10*=10;
		}
		if(d<=mid)
			return naive(d10);
		//matches first mid digits
		boolean[] list=partial(mid);
		for(int i=0;i<list.length;i++)
		{
			if(!list[i])continue;
			String result=search(i2s(i,mid),mid,d);
			if(result==null)continue;
			if(result.equals("Liar"))return result;
			if(result.equals("Ambiguity"))return result;
		}
		return match==null?"Liar":match;
	}
	String match=null;
	int pow(int val)
	{
		int d10=1;
		for(int i=0;i<val;i++)
		{
			d10*=10;
		}
		return d10;
		
	}
	String search(String prefix,int d0,int d1)
	{
		int d10=pow(d1-d0);
		for(int i=0;i<d10;i++)
		{
			String cur=i2s(i,d1-d0);
			boolean ok=true;
			for(int j=0;j<n&&ok;j++)
			{
				ok=coincide(prefix+cur,guesses[j],d1)==bulls[j];
			}
			if(ok)
			{
				if(match==null)
				{
					match=prefix+cur;
					System.out.println(match+" matches");
				}
				else
					return "Ambiguity";
			}
		}
		return match;
	}
	String naive(int d10)
	{
		String match=null;
		for(int i=0;i<d10;i++)
		{
			String cur=i2s(i,d);
			boolean ok=true;
			for(int j=0;j<n&&ok;j++)
			{
				ok=coincide(cur,guesses[j],d)==bulls[j];
			}
			if(ok)
			{
				if(match==null)
				{
					match=cur;
					System.out.println(match+" matches");
				}
				else
					return "Ambiguity";
			}
		}
		return match==null?"Liar":match;
	}
	boolean[] partial(int mid)//p=10^6
	{
		int p=pow(mid);
		boolean[] out=new boolean[p];
		for(int i=0;i<p;i++)
		{
			String cur=i2s(i,mid);
			boolean ok=true;
			for(int j=0;j<n&&ok;j++)
			{
				int co=coincide(cur,guesses[j],mid);
				ok=co<=bulls[j] && co>=bulls[j]-d+mid;
			}
			if(ok)
			{
				out[i]=true;
			}
		}
		return out;
	}
	int coincide(String a,String b,int d)
	{
		int count=0;
		for(int i=0;i<d;i++)
		{
			count+=a.charAt(i)==b.charAt(i)?1:0;
		}
		return count;
	}
	String i2s(int v,int d)
	{
		char[] out=new char[d];
		for(int i=0;i<d;i++)
		{
			out[d-1-i]=(char)('0'+(v%10));
			v/=10;
		}
		return new String(out);
	}

}
//SRM 572 div1 medium