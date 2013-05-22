import java.util.*;
import java.util.Map.Entry;
public class BirthdayReminders {
	int [] bd;
	int days[];
	public String[] remind(String[] friendNames, int[] birthDates, int currentDate, String[] occasions, int[] days, int k) {
		bd=birthDates;
		this.days=days;
		TreeSet<Occ> occs=new TreeSet<BirthdayReminders.Occ>();
		for(int i=0;i<friendNames.length;i++)
		{
			for(int d=0;d<days.length;d++)
			{
				int bi=birthDates[i];
				int bias=0;
				if(bi<currentDate)
				{
					bias=(currentDate-bi+days[d]-1)/days[d];
					bi+=bias*days[d];
				}
				for(int j=0;j<k;j++)
				{
					(occs).add(new Occ(i, d, bias+j));
					if(occs.size()>k)
					{
						occs.remove(occs.last());
					}
				}
			}
		}
		String[] result=new String[k];
		int count=0;
		for(Occ occ:occs)
		{
			if(count>=k)break;
			int date=occ.date;
			int i,d,j;
			i=occ.i;
			d=occ.d;
			j=occ.j;
			System.out.println("date="+date+"(i="+i+", d="+d+", j="+j+")");
			result[count]=date+". "+friendNames[i]+" "+occasions[d]+" ("+(j)+")";
			count++;
		}
		return result;
	}
	public class Occ implements Comparable<Occ>
	{
		public int date,i,d,j;
		public Occ(int i,int d,int j)
		{
			date=bd[i]+days[d]*j;
			this.i=i;
			this.d=d;
			this.j=j;
		}
		public int compareTo(Occ o) {
			if(date!=o.date)
			{
				return date-o.date;
			}
			if(d!=o.d)
			{
				return d-o.d;
			}
			return i-o.i;
		}
		
	}
}
//SRM412 div2 medium
