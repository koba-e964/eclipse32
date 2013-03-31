package kobae964_app.algo;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Factory;
import static org.hamcrest.CoreMatchers.*;

public class RangeTest {
	class Positive extends BaseMatcher<Integer>
	{
		@Override
		public void describeTo(Description description) {}

		@Override
		public boolean matches(Object item) {
			return (item instanceof Integer)&& ((Integer)item)>0;
		}
	}
	class Negative extends BaseMatcher<Integer>
	{
		

		@Override
		public void describeTo(Description description) {
		}

		@Override
		public boolean matches(Object item) {
			return (item instanceof Integer)&& ((Integer)item)<0;
		}
		
	}
	@Before
	public void setUp()
	{
		this.rnd=new Random();
		start=rnd.nextInt(0x10000);
		end=start+rnd.nextInt(0x10000);
		range=Range.valueOf(start,end);
		assertThat(end-start,not(new Negative()));
		for(int i=start;i<end;i++)
		{
			counter.add(i);
		}
	}
	Random rnd;
	int start,end;
	Range range;
	SortedSet<Integer> counter=new TreeSet<Integer>();


	@Test
	public void testSize() {
		int start,end;
		start=rnd.nextInt(0x10000000);
		end=start+rnd.nextInt(0x10000000);
		Range range=Range.valueOf(start, end);
		assertEquals(end-start,range.size());
	}

	@Test
	public void testIsEmpty() {
		boolean isEmpty=rnd.nextBoolean();
		int start=0;
		int end=isEmpty?0:1;
		Range range=Range.valueOf(start, end);
		assertEquals(isEmpty,range.isEmpty());
	}

	@Test
	public void testValueOf()
	{
		assertEquals(counter,range);
	}


	@Test
	public void testContainsObject() {
		for(int i=0;i<1000;i++)
		{
			Object value=(Integer)rnd.nextInt(0x100000);
			assertEquals(counter.contains(value),range.contains(value));
		}
	}



	@Test
	public void testSubSetIntegerInteger() {
		for(int i=0;i<10000;i++)
		{
			Integer from=(Integer)rnd.nextInt(0x1000);
			Integer to=rnd.nextInt(0x1000);
			if(from>to)
			{
				int tmp=to;
				to=from;
				from=tmp;
			}
			assertEquals(counter.subSet(from, to),range.subSet(from, to));
		}
		
	}


	@Test
	public void testHeadSet() {
		for(int i=0;i<10000;i++)
		{
			Integer toElement=rnd.nextInt(0x1000);
			assertEquals(counter.headSet(toElement),range.headSet(toElement));
		}
	}

	@Test
	public void testTailSet() {
		for(int i=0;i<100;i++)
		{
			Integer fromElement=rnd.nextInt(0x1000);
			assertEquals(counter.tailSet(fromElement),range.tailSet(fromElement));
		}
	}

	@Test
	public void testComparator() {
		assertEquals(null,range.comparator());
	}

	@Test
	public void testFirst() {
		for(int i=0;i<100;i++)
		{
			if(range.isEmpty())continue;
			assertEquals(counter.first(),range.first());
		}
	}

	@Test
	public void testLast() {
		for(int i=0;i<100;i++)
		{
			if(range.isEmpty())continue;
			assertEquals(counter.last(),range.last());
		}
	}

	@Test
	public void testIterator() {
		for(int k=0;k<100;k++)
		{
			Iterator<Integer> iter=range.iterator();
			for(int i=start;i<end;i++)
			{
				assertEquals((Integer)i,iter.next());
				assertEquals(i!=end-1,iter.hasNext());
			}
			assertEquals(false,iter.hasNext());
		}
	}

}
