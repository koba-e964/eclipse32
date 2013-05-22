import java.util.*;
public class CardsCheating {
	int[] cards;

	public int numberOfShuffles(int[] cards, int[] shuffle) {
		int n=shuffle.length;
		this.cards=cards;
		Set<List<Integer>> loops=new HashSet<List<Integer>>();
		boolean vis[]=new boolean[n];
		for(int i=0;i<n;i++)
		{
			List<Integer> loop=new ArrayList<Integer>();
			int c=i;
			while(vis[c]==false)
			{
				loop.add(c);
				vis[c]=true;
				c=shuffle[c];
			}
			if(loop.size()>=1)
				loops.add(loop);
		}
		System.out.println(loops);
		long x=0,mod=1;
		for(List<Integer> loop:loops)
		{
			int[] cons=getConstraint(loop);
			if(cons==null)
			{
				return -1;
			}
			long res[]=merge(x, mod, cons[0], cons[1]);
			if(res==null)
				return -1;
			x=res[0];
			mod=res[1];
		}
		return (int)x;
	}
	int[] getConstraint(List<Integer> cyc)
	{
		List<Integer> ok=new ArrayList<Integer>();
		int size=cyc.size();
		ArrayList<Integer> pts=new ArrayList<Integer>();
		ArrayList<Integer> correct=new ArrayList<Integer>();
		for(int c:cyc)
		{
			pts.add(cards[c]);
			correct.add(c%3);
		}
		for(int i=0;i<size;i++)
		{
			if(pts.equals(correct))
			{
				ok.add(i);
			}
			pts.add(0,pts.remove(pts.size()-1));
		}
		//System.out.println("ok="+ok);
		if(ok.size()==0)
			return null;
		if(ok.size()>=2)
		{
			int diff=ok.get(1)-ok.get(0);
			return new int[]{ok.get(0),diff};
		}
		return new int[]{ok.get(0),size};
	}
	long[] merge(long x,long mod,int y,int l)
	{
		long newmod=mod*(l/gcd(mod,l));
		for(int i=0,s=(int)(l/gcd(mod,l));i<s;i++)
		{
			long z=x+mod*i;
			if(z%l==y)
			{
				return new long[]{z,newmod};
			}
		}
		return null;
	}
	static long gcd(long x,long y)
	{
		while(y!=0)
		{
			long r=x%y;
			x=y;
			y=r;
			
		}
		return x;
	}
}
//SRM415 div2 hard