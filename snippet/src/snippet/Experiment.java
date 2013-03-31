package snippet;

import java.util.HashSet;
import java.util.Set;

public class Experiment {
	void crown(int i){
    i=        2;       int
    j =      i  +      5 *
    2  +    3    <    2  ?
    i   /  2      *  7   :
    i    *4        -2    ;
    System.out.println(j);
	}
	static int[] digits(int val,int dig)
	{
		int[] out=new int[dig];
		for(int i=0;i<dig;i++)
		{
			out[i]=val%10;
			val/=10;
		}
		if(val!=0)
			return null;
		return out;
	}
	public static void main(String[] args)
	{
		if(null instanceof Object)
		{
			System.out.println("null is Object");
			return;
		}
		HashSet<Integer> right=new HashSet<Integer>();
		for(int i=1;i<=9;i++)
		{
			right.add(i);
		}
		for(int i=100;i<=999;i++)
		{
			int[] divisor=digits(i,3);
			int[] divided=digits(1978*i,6);
			HashSet<Integer> cur=new HashSet<Integer>();
			if(divided==null)
			{
				break;
			}
			for(int v:divisor)cur.add(v);
			for(int v:divided)cur.add(v);
			if(right.equals(cur))
			{
				System.out.println((1978*i)+"/"+i+"=1978");
			}
		}
	}
}
