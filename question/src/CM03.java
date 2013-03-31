import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 次のコードには高速化が望める場所が何箇所か存在します。
 * それを修正し、挙動を変えぬままできるだけ高速化しましょう。
 * @author koba-e964
 *
 */
public final class CM03 {
	/**
	 * sum of (1..n)^2
	 * @return 
	 */
	static long process0(int n)
	{
		List<Integer> sq=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			sq.add(i*i);
		}
		long count=0;
		for(int i=0;i<sq.size();i++)
		{
			count+=sq.get(i);
		}
		return(count);
	}
	static String process1(int n)
	{
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);
		String out="";
		for(int i=0;i<list.size();i++)
		{
			out+=list.get(i);
		}
		return(out);
	}
	static int process2(List<Integer> list)
	{
		int sum=0;
		for(int i=0;i<list.size();i++)
		{
			sum+=list.get(i);
		}
		return sum;
	}
	static void process3(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			array[i]/=5;
		}
		return ;
	}
	/**
	 * This method should not be modified.
	 * @param args {@code args} are just ignored and therefore null will be accepted.
	 */
	public static void main(String[] args) {
		Random rand=new Random();
		int n=rand.nextInt(0xbedfed/100);
		/*It is strongly recommended NOT to invoke this method unless you optimize it...*/
		long res=CM03.process0(n);
		System.out.println(n+":"+res);

		n=rand.nextInt(20);//0..19999
		String res1=process1(n);
		System.out.println(res1);

		List<Integer> randList=new LinkedList<Integer>();
		for(int i=0;i<20;i++)
		{
			randList.add(rand.nextInt(300)+1);
		}
		int res2=process2(randList);
		System.out.println(res2);
	}

}
