import java.util.*;
public class SwitchesAndLamps {
	int m,n;
	public int theMin(String[] switches, String[] lamps) {
		m=switches.length;
		n=switches[0].length();
		HashMap<Long, Integer> sw=new HashMap<Long, Integer>();
		HashMap<Long, Integer> lm=new HashMap<Long, Integer>();
		for(int i=0;i<n;i++)
		{
			long a=0,b=0;
			for(int j=0;j<m;j++)
			{
				a|=switches[j].charAt(i)=='Y'?1L<<j:0;
				b|=lamps[j].charAt(i)=='Y'?1L<<j:0;
			}
			if(sw.containsKey(a))
			{
				sw.put(a, sw.get(a)+1);
			}
			else
			{
				sw.put(a, 1);
			}
			if(lm.containsKey(b))
			{
				lm.put(b, lm.get(b)+1);
			}
			else
			{
				lm.put(b,1);
			}
		}
		if(!sw.equals(lm))return -1;
		int max=0;
		for(int v:sw.values())
		{
			if(max<v)max=v;
		}
		int res=0;
		for(;(1L<<res)<max;res++){}
		return res;
	}
	public int theMin2(String[] switches, String[] lamps) {
		m=switches.length;
		n=switches[0].length();
		long[] sw=new long[m],lm=new long[m];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				sw[i]|=switches[i].charAt(j)=='Y'?1L<<j:0;
				lm[i]|=lamps[i].charAt(j)=='Y'?1L<<j:0;
			}
		}
		HashMap<Long, Long> dat=new HashMap<Long, Long>();
		long rem=(1L<<n)-1;
		dat.put(rem,rem);
		for(int i=0;i<m;i++)
		{
			HashMap<Long,Long> tmp=new HashMap<Long, Long>();
			boolean added=false;
			for(Iterator<Map.Entry<Long, Long>> iter=dat.entrySet().iterator();iter.hasNext();)
			{
				Map.Entry<Long, Long> entry=iter.next();
				long a=entry.getKey();
				long b=entry.getValue();
				if((a&sw[i])==0)
				{
					if((b&lm[i])!=0)
					{
						return -1;//contradiction
					}
					continue;
				}
				if(Long.bitCount(a&sw[i])!=Long.bitCount(b&lm[i]))
				{
					return -1;
				}
				tmp.put(a&sw[i],b&lm[i]);
				if((a&~sw[i])!=0)
					tmp.put(a&~sw[i],b&~lm[i]);
				if(((~a)&sw[i])!=0)
					tmp.put((~a)&sw[i],(~b)&lm[i]);
				iter.remove();
				added=true;
			}
			dat.putAll(tmp);
			rem&=~sw[i];
		}
		System.out.println("n="+n+", m="+m);
		for(final Map.Entry<Long, Long> entry:dat.entrySet())
		{
			//System.out.printf("(%x,%x)\n",entry.getKey(),entry.getValue());
		}
		int max=0;
		for(int i=0;i<n;i++)
		{
			long comm=(1L<<n)-1;
			for(int j=0;j<m;j++)
			{
				if((sw[j]&(1L<<i))!=0)
				{
					comm&=sw[j];
				}
				else
				{
					comm&=~sw[j];
				}
			}
			int bc=Long.bitCount(comm);
			if(max<bc)max=bc;
			
		}
		int ret=0;
		for(;(1L<<ret)<(long)max;ret++);
		return ret;
	}
	void swap(long[] array,int u,int v)
	{
		if(u!=v)
		{
			long t=array[u];
			array[u]=array[v];
			array[v]=t;
		}
	}
	int ge(long[] a,long[] b)
	{
		int c=0;
		int r=0;
		for(;c<n && r<m;c++)
		{
			{
				int x=r;
				for(;x<m;)
				{
					if((a[x]&(1L<<c))!=0)
					{
						swap(a,r,x);
						swap(b,r,x);
						break;
					}
					x++;
				}
				if(x==m)
				{
					continue;
				}
			}
			for(int k=0;k<m;k++)
			{
				if(k!=r && (a[k]&(1L<<c))!=0)
				{
					a[k]^=a[r];
					b[k]^=b[r];
				}
			}
			r++;
		}
		System.out.println("n="+n+", m="+m);
		for(int i=0;i<m;i++)
		{
			System.out.printf("(%x,%x)\n",a[i],b[i]);
		}
		return r;
	}
}
//TCO 2012 Round A Div 1 300
