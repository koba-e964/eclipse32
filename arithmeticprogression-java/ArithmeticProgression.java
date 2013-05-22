import java.util.*;
public class ArithmeticProgression {

	public double minCommonDifference(int a0, int[] seq) {
		if(seq.length==0)return 0;
		double s=-1.0,t=-1.0;
		s=seq[0]-a0;
		t=s+1.0;
		for(int i=0;i<seq.length;i++)
		{
			double a=(seq[i]-a0)/(double)(i+1);
			double b=(seq[i]-a0+1)/(double)(i+1);
			if(t<=a)return -1;
			if(s>=b)return -1;
			s=Math.max(s, a);
			t=Math.min(t, b);
			if(s>=t)return -1;
		}
		if(t<=0.0)return -1.0;
		return s;
	}

}
//SRM