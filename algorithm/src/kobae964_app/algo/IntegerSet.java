package kobae964_app.algo;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class IntegerSet extends AbstractSet<Integer> implements Cloneable {
	private int range;
	private int[] dat;
	/**
	 * Constructs a new, empty set. All elements inserted into
     * the set must be from 0 (inclusive) to {@code range} (exclusive).
     * Null elements are prohibited.
	 * @param range a nonnegative integer
	 * @exception IllegalArgumentException if {@code range<0}
	 */
	public IntegerSet(int range)
	{
		if(range<0)
		{
			throw new IllegalArgumentException("range:"+range);
		}
		this.range=range;
		this.dat=new int[(range+31)/32];
		this.modCount=0;
	}
	/*
	 * I have never heard of the rule that 
	 * if this set contains more than Integer.MAX_VALUE elements, it has to return Integer.MAX_VALUE.
	 * Compliance to this rule may cause a slowdown.
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		int count=0;
		for(final int d:dat)
		{
			count+=Integer.bitCount(d);
			//Integer.bitCount(d)<=32, so if {@code count} would overflow, <t>count</t> satisfies {@code count<=(int)0x8000001f(==Integer.MAX_VALUE+32)}, therefore count is negative.
			if(count<0)
			{
				return Integer.MAX_VALUE;
			}
		}
		return count;
	}
	/*
	 * O(range)
	 */
	@Override
	public boolean isEmpty() {
		for(final int d:dat)
		{
			if(d!=0)return false;
		}
		return true;
	}
	/*
	 * O(1)
	 */
	@Override
	public boolean contains(Object o) {
		return (o instanceof Integer) && contains((int)(Integer)o);
	}
	/*
	 * O(1)
	 * @param val
	 * @return
	 */
	public boolean contains(int val)
	{
		if(val<0 || val>=range)
		{
			return false;
		}
		return (dat[val/32]&(1<<(val%32)))!=0;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new Itr();
	}
	/**
	 * @param e An {@link Integer} to be added (null is not permitted)
	 * @exception NullPointerException if specified integer ({@code e}) is null
	 * @exception IndexOutOfBoundsException if {@code e<0 || e>=range}
	 */
	@Override
	public boolean add(Integer e) {
		int val=e.intValue();
		if(val<0 || val>=range)
		{
			throw new IndexOutOfBoundsException("val:"+val);
		}
		boolean modified=!contains(val);
		dat[val/32]|=(1<<(val%32));
		modCount+=modified?1:0;
		return modified;
	}

	/*
	 * O(1)
	 */
	@Override
	public boolean remove(Object o) {
		return (o instanceof Integer) && remove((int)(Integer)o);
	}
	/**
	 * O(1)
	 * @param val An {@link Integer} to be removed
	 * @return true if {@code val} was removed
	 */
	public boolean remove(int val)
	{
		if(val<0 || val>=range)
		{
			return false;
		}
		boolean result=contains(val);
		dat[val/32]&=~(1<<(val%32));
		modCount+=result?1:0;
		return result;
	}



	@Override
	public boolean retainAll(Collection<?> c) {
		if(c instanceof IntegerSet)
		{
			return retainAll((IntegerSet)c);
		}
		return super.retainAll(c);
	}
	public boolean retainAll(IntegerSet another)
	{
		if(this==another)
		{
			return false;
		}
		boolean modified=false;
		for(int i=0,s=Math.min(this.dat.length,another.dat.length);i<s;i++)
		{
			int old=this.dat[i];
			this.dat[i]&=another.dat[i];
			modified=modified|| this.dat[i]!=old;
		}
		modCount+=modified?1:0;
		return modified;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if(c instanceof IntegerSet)
		{
			return removeAll((IntegerSet)c);
		}
		return super.removeAll(c);
	}
	public boolean removeAll(IntegerSet another)
	{
		boolean modified=false;
		for(int i=0,s=Math.min(this.dat.length,another.dat.length);i<s;i++)
		{
			int old=this.dat[i];
			this.dat[i]&=~another.dat[i];
			modified=modified|| this.dat[i]!=old;
		}
		modCount+=modified?1:0;
		return modified;
	}
	@Override
	public void clear() {
		for(int i=0;i<dat.length;i++)
		{
			dat[i]=0;
		}
		modCount++;
	}
	@Override
	public IntegerSet clone()
	{
		IntegerSet clobj;
		try {
			clobj = (IntegerSet) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Cloneable");
		}
		clobj.dat=new int[dat.length];
		System.arraycopy(this.dat, 0, clobj.dat, 0, this.dat.length);
		return clobj;
	}
	int modCount;
	private class Itr implements Iterator<Integer>
	{
		int cur;
		int last;
		int mc;
		Itr()
		{
			cur=-1;
			cur=nextIndex();
			last=-1;
			mc=modCount;
		}
		private int nextIndex()
		{
			int x=cur+1;
			while(x<range)
			{
				int mask=(-1)<<(x%32);
				int ind=x/32;
				int masked = dat[ind]&mask;
				if(masked!=0)
				{
					int tz=Integer.numberOfTrailingZeros(masked);
					if(tz==32)
						throw new AssertionError();
					return (x&-32)|tz;
				}
				x=x&-32;
				x+=32;
			}
			return range;
		}
		@Override
		public boolean hasNext() {
			checkUnmodified();
			return cur!=range;
		}

		@Override
		public Integer next() {
			checkUnmodified();
			if(cur==range)
				throw new NoSuchElementException();
			last=cur;
			cur=nextIndex();
			return last;
		}

		@Override
		public void remove() {
			checkUnmodified();
			if(last<0)
				throw new IllegalStateException();
			boolean result=IntegerSet.this.remove(last);//modCount will be incremented
			if(!result)
			{
				throw new AssertionError();
			}
			last=-1;
			mc++;//mc must be equal to modCount
		}
		private void checkUnmodified()
		{
			if(modCount!=mc)
			{
				throw new ConcurrentModificationException();
			}
		}
	}
}
