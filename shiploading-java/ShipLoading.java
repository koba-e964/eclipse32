import java.util.*;
public class ShipLoading {

	public int minimumTime(int[] cranes, String[] boxes) {
		int n=cranes.length;
		List<Integer> box=new ArrayList<Integer>();
		{
			StringBuilder sb=new StringBuilder();
			for(String b:boxes)
			{
				sb.append(b);
			}
			String split[]=sb.toString().split("\\s");
			for(String s:split)
			{
				if(s.length()>=1)
				{
					box.add(Integer.parseInt(s));
				}
			}
		}
		Arrays.sort(cranes);
		int[] capable=new int[n];
		for(int i=0;i<n;i++)
		{
			capable[i]=0;
		}
		Collections.sort(box);
		if(cranes[n-1]<box.get(box.size()-1))
		{
			return -1;
		}
		for(final int bw:box)
		{
			inn:
			for(int i=0;i<n;i++)
			{
				if(bw<=cranes[i])
				{
					capable[i]++;
					break inn;
				}
			}
		}
		int count=0;
		while(true)
		{
			boolean b=true;
			for(int i=0;i<n&&b;i++)
			{
				b=capable[i]==0;
			}
			if(b)break;
			int remc=0;
			for(int i=n-1;i>=0;i--)
			{
				remc++;
				int c=Math.min(capable[i],remc);
				capable[i]-=c;
				remc-=c;
			}
			count++;
		}
		return count;
	}

}
//SRM