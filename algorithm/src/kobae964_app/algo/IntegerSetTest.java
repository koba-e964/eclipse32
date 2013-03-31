package kobae964_app.algo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class IntegerSetTest {

	@Test
	public void testSize() {
		int range=30000;//!(32|range)
		Set<Integer> mirror=new HashSet<Integer>();
		Set<Integer> inst=new IntegerSet(range);
		Random rand=new Random();
		for(int i=0;i<10000;i++)
		{
			int val=rand.nextInt(range);
			mirror.add(val);
			inst.add(val);
		}
		Assert.assertEquals(mirror.size(), inst.size());
	}

	@Test
	public void testIsEmpty() {
		Set<Integer> inst=new IntegerSet(100);
		inst.add((int)(Math.random()*99));
		Assert.assertFalse(inst.isEmpty());
		Assert.assertTrue(new IntegerSet(100).isEmpty());
	}


	@Test
	public void testContainsObject() {
		int range=30000;//!(32|range)
		Set<Integer> mirror=new HashSet<Integer>();
		Set<Integer> inst=new IntegerSet(range);
		Random rand=new Random();
		for(int i=0;i<10000;i++)
		{
			int val=rand.nextInt(range);
			mirror.add(val);
			inst.add(val);
		}
		for(int i=0;i<300;i++)
		{
			int val=rand.nextInt(range);
			Assert.assertEquals(mirror.contains(val), inst.contains(val));
		}
	}


	@Test(timeout=2000)
	public void testIterator() {
		for(int k=0;k<100;k++)
		{
			int range=30016;//(32|range)
			Set<Integer> mirror=new HashSet<Integer>();
			Set<Integer> inst=new IntegerSet(range);
			Random rand=new Random();
			mirror.add(0);
			inst.add(0);
			for(int i=0;i<100;i++)
			{
				int val=rand.nextInt(range);
				mirror.add(val);
				inst.add(val);
			}
			Iterator<Integer> iter=inst.iterator();
			List<Integer> ordnung=new ArrayList<Integer>();
			int rem=inst.size();
			assertEquals(mirror,inst);
			for(;iter.hasNext();)
			{
				Integer val=iter.next();
				if(rand.nextBoolean())
				{
					continue;
				}
				ordnung.add(val);
				iter.remove();
				assertEquals("removing "+val,true,mirror.remove(val));
				rem--;
			}
			assertEquals(rem,mirror.size());
			assertEquals(rem,inst.size());
			//check if ordnung is sorted
			int cur=-1;
			for(int i=0,s=ordnung.size();i<s;i++)
			{
				if(cur>ordnung.get(i))
					fail("cur > ordnung[i]");
				cur=ordnung.get(i);
			}
		}
	}

	@Test(timeout=2000)
	public void testAddInteger() {
		int range=30000;//!(32|range)
		Set<Integer> mirror=new HashSet<Integer>();
		Set<Integer> inst=new IntegerSet(range);
		Random rand=new Random();
		for(int i=0;i<10000;i++)
		{
			int val=rand.nextInt(range);
			boolean expected=mirror.add(val);
			boolean actual=inst.add(val);
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testRemoveObject() {
		int range=30000;//!(32|range)
		Set<Integer> mirror=new HashSet<Integer>();
		Set<Integer> inst=new IntegerSet(range);
		Random rand=new Random();
		for(int i=0;i<10000;i++)
		{
			int val=rand.nextInt(range);
			mirror.add(val);
			inst.add(val);
		}
		for(int i=0;i<300;i++)
		{
			int val=rand.nextInt(range);
			Assert.assertEquals(mirror.remove(val), inst.remove(val));
		}
	}


}
