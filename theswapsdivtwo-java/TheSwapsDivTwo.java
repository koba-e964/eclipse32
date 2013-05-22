import java.util.*;
public class TheSwapsDivTwo {

	public int find(int[] sequence) {
		Arrays.sort(sequence);
		List<Integer> tmp=new ArrayList<Integer>();
		int cur=-1;
		int cnt=0;
		for(final int a:sequence)
		{
			if(cur!=a)
			{
				if(cur!=-1)
				{
					tmp.add(cnt);
				}
				cur=a;
				cnt=1;
			}
			else
				cnt++;
		}
		tmp.add(cnt);
		int count=0;
		for(final int t:tmp)
		{
			if(t>=2)
			{
				count=1;
				break;
			}
		}
		for(int i=0,l=tmp.size();i<l;i++)
		{
			for(int j=i+1;j<l;j++)
			{
				count+=tmp.get(i)*tmp.get(j);
			}
		}
		return count;
	}

}
//SRM