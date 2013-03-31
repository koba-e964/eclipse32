import java.util.*;
public class SwitchesAndLamps {
	int m,n;
	public int theMin(String[] switches, String[] lamps) {
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
		int pr=ge(sw,lm);
		return n-pr-1;
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
