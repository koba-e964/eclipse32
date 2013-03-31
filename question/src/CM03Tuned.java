import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public final class CM03Tuned  {
	/**
	 * sum of (1..n)^2
	 * @return 
	 */
	static long process0(int n)
	{
		long count=0;
		for(int i=0;i<n;i++)
		{
			count+=i*i;
		}
		return(count);
	}
	static String process1(int n)
	{
		List<Integer> list=new ArrayList<Integer>(n);
		for(int i=0;i<n;i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);
		StringBuilder out=new StringBuilder(2*n);
		/*for(int i=0;i<list.size();i++)
		{
			out.append(list.get(i));
		}*/
		for(final int val:list)
		{
			out.append(val);
		}
		return(out).toString();
	}
	static int process2(List<Integer> list)
	{
		int sum=0;
		for(final int i:list)
		{
			sum+=i;
		}
		return sum;
	}
	static int process2slow(List<Integer> list)
	{
		int sum=0;
		for(int i=0,s=list.size();i<s;i++)
		{
			sum+=list.get(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		CM03.main(args);
	}
	public static final void process3(int[] array) {
		for(int i=0,l=array.length;i<l;i++)
		{
			array[i]=(int)((array[i]*0x33333334L)>>>32);
		}
	}

}
