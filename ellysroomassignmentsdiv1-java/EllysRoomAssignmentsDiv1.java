import java.util.*;
public class EllysRoomAssignmentsDiv1 {

	public double getAverage(String[] ratings) {
		StringBuilder conc=new StringBuilder();
		for(String r:ratings)
		{
			conc.append(r);
		}
		String[] spl=conc.toString().split("\\s");
		int n=spl.length;
		int r=(n+19)/20;
		int[] rate=new int[n];
		for(int i=0;i<n;i++)
		{
			rate[i]=Integer.parseInt(spl[i]);
		}
		int er=rate[0];//Elly's rating
		Arrays.sort(rate);
		int g=(n+r-1)/r;//20
		int s=g*r-n;
		int sum=0;
		boolean found=false;
		for(int i=r-s;i<n;i+=r)
		{
			boolean cur=false;
			for(int j=0;j<r;j++)
			{
				if(rate[i+j]==er)
				{
					found=true;
					cur=true;
				}
			}
			for(int j=0;j<r;j++)
			{
				sum+=cur?er:rate[i+j];
			}
			cur=false;
		}
		if(!found)
		{
			return (sum/(double)r+er)/g;
		}
		int ssum=0;
		for(int i=0;i<r-s;i++)
		{
			ssum+=rate[i];
		}
		return sum*(s/(double)(g-1)+(r-s)/(double)g)/(r*r)+ssum/(double)g/r;
	}

}
//SRM