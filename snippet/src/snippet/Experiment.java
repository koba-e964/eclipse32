package snippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

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
		dust2();
		"".contentEquals("");
		Double.compare(0,0);
		new java.util.Scanner((Readable)null).hasNext((Pattern)null);
	}
	public static void code()
	{
		if(null instanceof Object)
		{
			System.out.println("null is Object");
			return;
		}
		char ch=60000;
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
		String.CASE_INSENSITIVE_ORDER.compare(null, null);
		HashMap<Integer, Integer> a;
		HashSet<Object> b;
		new ArrayList<Integer>().toArray(new Integer[0]);
	}
	class Generic<Type>
	{
		@Override
		public String toString()
		{
			Type[] a;
			a=(Type[]) new Object[0];
			
			return super.toString();
		}
	}
	static void arrayCast()
	{
		String[] ary=(String[])new String[]{"iterate","wii"};
		ary[0]="aa";
		System.out.println(ary.getClass());
	}
	static void dust2()
	{
		int x=20;
		int sum=0;
		int cur=1;
		for(int i=0;i<=x;i++)
		{
			sum+=cur;
			cur*=5;
		}
		int res0=sum%31;
		int res1=6%res0;
		int res2=x%res1;
		System.out.println("x="+x+", res0="+res0+", res1="+res1+", res2="+res2);
	}
}
