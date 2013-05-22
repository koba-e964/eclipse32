import java.util.*;
public class DrawingMarbles {

	public double sameColor(int[] colors, int n) {
		int c=0;
		for(int cl:colors)
		{
			c+=cl;
		}
		double sum=0;
		double div=1;
		for(int i=0;i<n;i++)
		{
			div*=c-i;
		}
		if(div==0.0)
		{
			return 0.0;
		}
		for(int cl:colors)
		{
			double tmp=1;
			for(int i=0;i<n;i++)
			{
				tmp*=cl-i;
			}
			sum+=tmp;
		}
		return sum/div;
	}

}
//SRM 370 div2
