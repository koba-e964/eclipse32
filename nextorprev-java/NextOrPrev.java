import java.util.*;
public class NextOrPrev {
	int n;
	public int getMinimum(int nextCost, int prevCost, String start, String goal) {
		n=start.length();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i!=j && incl(start.charAt(i),goal.charAt(i),start.charAt(j),goal.charAt(j)))
				{
					return -1;
				}
			}
		}
		int total=0;
		for(int i=0;i<n;i++)
		{
			int diff=goal.charAt(i)-start.charAt(i);
			if(diff<0)total+=-prevCost*diff;
			else total+=nextCost*diff;
		}
		return total;
	}
	boolean incl(int a,int b,int c,int d)//[a,b] is included in [c,d]
	{
		return c<=a && b<=d;
	}
}
//SRM 572 div 2 medium