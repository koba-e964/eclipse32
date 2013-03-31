import java.util.*;
public class AddElectricalWires {
	int disj[];

	public int maxNewWires(String[] wires, int[] gridConnections) {
		int n=wires.length;
		disj=new int[n];
		for(int i=0;i<n;i++)
		{
			disj[i]=i;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(wires[i].charAt(j)=='1')
				{
					link(i,j);
				}
			}
		}
		int m=gridConnections.length;
		int[] conn=new int[m];
		boolean []gc=new boolean[n];
		for(int i=0;i<n;i++)gc[i]=false;
		int rem=n;
		for(int i=0;i<m;i++)
		{
			conn[i]=0;
		}
		for(int i=0;i<n;i++)
		{
			in:
			for(int j=0;j<m;j++)
			{
				if(sameSet(i, gridConnections[j]))
				{
					if(gc[i])throw new IllegalArgumentException();
					conn[j]++;
					gc[i]=true;
					rem--;
					break in;
				}
			}
		}
		int count=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(sameSet(i,j) || ((!gc[i]) && (!gc[j])))
				{
					if(wires[i].charAt(j)!='1')
						count++;
				}
			}
		}
		{
			int rem2=0;
			for(boolean g:gc)if(g)rem2++;
			if(n-rem2!=rem)throw new IllegalStateException();
		}
		int max=0;
		for(final int c:conn)
		{
			if(max<c)
			{
				max=c;
			}
		}
		count+=max*rem;
		return (count);
	}
	int root(int v)
	{
		if(disj[v]==v)return v;
		disj[v]=root(disj[v]);
		return disj[v];
	}
	void link(int a,int b)
	{
		disj[root(b)]=root(a);
	}
	boolean sameSet(int a,int b)
	{
		return root(a)==root(b);
	}
}
//SRM410 div2 medium
