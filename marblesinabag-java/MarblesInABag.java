import java.util.*;
public class MarblesInABag {

	public double getProbability(int red, int blue) {
		memo=new double[]{1,0};
		for(int i=1;i<red+blue;i+=2)
		{
			next();
		}
		return memo[red];
	}
	double memo[];
	double sub(int r,int b)
	{
		if(r>b)return 0.0;
		if(r<=0)
			return 1.0;
		int c=canon(r,b);
		if(memo[c]>=0)
		{
			return memo[c];
		}
		if(r+b==1)
		{
			return r==0?1.0:0.0;
		}
		double s1=sub(r-1,b-1);
		double s2=sub(r,b-2);
		double res=(s1*r+s2*b)/(r+b);
		memo[c]=res;
		return res;
	}
	int canon(int r,int b)
	{//r+b odd, 1<=r<b,b>=2
		int sum=0;
		for(int i=2;i<b;i++)
		{
			sum+=i-1;
		}
		return sum+r-1;
	}
	void next()
	{//memo [i][rb-i];0<=i<=rb
		int rb=memo.length-1;
		double[] next=new double[rb+3];
		for(int i=0;i<rb;i++)
		{
			double s1=memo[i];//sub(r-1,b-1);
			double s2=memo[i+1];//sub(r,b-2);
			double res=(s1*(i+1)+s2*(rb+1-i))/(rb+2);
			next[i+1]=res;
		}
		next[0]=1.0;
		next[rb+1]=0;
		next[rb+2]=0;
		memo=next;
	}
}
//SRM