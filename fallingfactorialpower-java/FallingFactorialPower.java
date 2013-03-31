import java.util.*;
public class FallingFactorialPower {

	public double compute(int n, int k) {
		if(k>=1)
		{
			long cur=n;
			for(int i=1;i<k;i++)
			{
				cur*=n-i;
			}
			return cur;
		}
		double cur=1.0;
		for(int i=0;i<-k;i++)
		{
			cur/=n+i+1;
		}
		return cur;
	}

}
//SRM 405 div 2 easy