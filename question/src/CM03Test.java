import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class CM03Test {
	List<Integer> testList;
	int[] testArray;
	@Before
	public void setUp()
	{
		List<Integer> linked=new LinkedList<Integer>();
		Random rnd=new Random();
		for(int i=0;i<0x8000;i++)
		{
			linked.add(rnd.nextInt());
		}
		testList=linked;
		
		int array[]=new int[0x80000];
		for(int i=0;i<0x80000;i++)
		{
			array[i]=rnd.nextInt();
		}
		testArray=array;
	}
	@Test(timeout=10000)
	public void testProcess0() {
		CM03.process0(0x100000);
	}
	/*
	 * About 100x optimization
	 */
	@Test
	public void testTunedProcess0() {
		CM03Tuned.process0(0x100000);
	}
	@Test(timeout=10000)
	public void testProcess1()
	{
		CM03.process1(10000);
	}
	@Test(timeout=10000)
	public void testTunedProcess1()
	{
		CM03Tuned.process1(10000);
	}
	@Test
	public void testProcess2()
	{
		CM03.process2(testList);
	}
	@Test
	public void testTunedProcess2()
	{
		CM03Tuned.process2(testList);
	}
	@Test
	public void testProcess3()
	{
		for(int i=0;i<100;i++)
			CM03.process3(testArray);
	}
	@Test
	public void testTunedProcess3()
	{
		for(int i=0;i<100;i++)
			CM03Tuned.process3(testArray);
	}

}
