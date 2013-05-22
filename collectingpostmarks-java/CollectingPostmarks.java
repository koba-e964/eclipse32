import java.util.*;
public class CollectingPostmarks {
	static class PV implements Comparable<PV>
	{
		int price,value;
		PV(int p,int v)
		{
			price=p;
			value=v;
		}
		PV(PV another)
		{
			price=another.price;
			value=another.value;
		}
		@Override
		public String toString()
		{
			return "("+price+","+value+")";
		}
		public int compareTo(PV o) {
			return value-o.value;
		}
		@Override
		public int hashCode()
		{
			return price<<16|value;
		}
	}
	static final Comparator<PV> priceComp=new Comparator<CollectingPostmarks.PV>() {
		
		public int compare(PV o1, PV o2) {
			return o1.price-o2.price;
		}
	};
	public int amountOfMoney(int[] prices, int[] have, int[] values, int K) {
		int n=prices.length;
		int m=n/2;
		PV[] former=new PV[1<<m];
		PV[] latter=new PV[1<<(n-m)];
		for(int i=0;i<1<<m;i++)
		{
			int p=0,v=0;
			for(int j=0;j<m;j++)
			{
				if((i&(1<<j))!=0)
				{
					p+=prices[j];
					v+=values[j];
				}
			}
			former[i]=new PV(p, v);
		}
		for(int i=0;i<1<<(n-m);i++)
		{
			int p=0,v=0;
			for(int j=m;j<n;j++)
			{
				if((i&(1<<(j-m)))!=0)
				{
					p+=prices[j];
					v+=values[j];
				}
			}
			latter[i]=new PV(p, v);
		}
		if(n<12)
		{
			for(int i=0;i<former.length;i++)
				System.out.print(i+":"+former[i].toString()+" ");
			for(int i=0;i<latter.length;i++)
				System.out.print(i+":"+latter[i].toString()+" ");
			System.out.println();
		}
		Arrays.sort(former);//sort by value
		Arrays.sort(latter);
		int li=latter.length;//index in latter
		TreeSet<PV> set=new TreeSet<CollectingPostmarks.PV>(priceComp);
		int mini=-1;
		int minp=Integer.MAX_VALUE;
		for(int i=0;i<former.length;i++)//pv.value increases
		{
			int oldli=li;
			PV pv=former[i];
			while(li>=1 && latter[li-1].value>=K-pv.value){li--;}
			//li...oldli
			for(int x=li;x<oldli;x++)
			{
				set.add(latter[x]);
			}
			if(set.size()==0)
			{
				continue;
			}
			PV second=new PV(set.first());
			if(second!=null)
			{
				second.price++;
				set.tailSet(second).clear();
			}
			int tp=pv.price+set.first().price;
			if(minp>tp)
			{
				minp=tp;
			}
		}
		int sp=0;
		for(int h:have)
		{
			sp+=prices[h];
		}
		return minp==Integer.MAX_VALUE?-1:Math.max(minp-sp,0);
	}

}
//SRM415 div1 medium