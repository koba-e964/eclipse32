package kobae964_app.algo;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
/**
 * Immutable range
 *
 */
public class Range extends AbstractSet<Integer> implements SortedSet<Integer> {

	private int start,end;//inclusive,exclusive
	private static final Range EMPTY_CACHE=new Range(0,0);
	/**
	 * [start,end)
	 * @param start
	 * @param end the maximum element of the set (exclusive);
	 */
	public Range(int start,int end)
	{
		if(start>end)
		{
			throw new IllegalArgumentException("start>end");
		}
		this.start=start;
		this.end=end;
	}
	public static Range valueOf(int start,int end)
	{
		if(start>=end)
			return EMPTY_CACHE;
		return new Range(start,end);
	}
	@Override
	public int size() {
		return end-start;
	}

	@Override
	public boolean isEmpty() {
		return start==end;
	}

	@Override
	public boolean contains(Object o) {
		return (o instanceof Integer) && contains((int)(Integer)o);
	}
	public boolean contains(int value)
	{
		return start<=value && value<end;
	}




	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}


	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(Integer e) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		throw new UnsupportedOperationException();
	}
	@Override
	public Range subSet(Integer fromElement, Integer toElement) {
		return subSet((int)fromElement,(int)toElement);
	}
	public Range subSet(int from,int to)
	{
		if(from>to)return EMPTY_CACHE;
		if(this.isEmpty())return EMPTY_CACHE;
		if(from<=this.start && this.end<=to)return this;
		if(this.end<=from || to<=this.start)return EMPTY_CACHE;
		if(this.start<=from)return valueOf(from,Math.min(end,to));
		if(to<=this.end)return valueOf(this.start,to);
		throw new AssertionError();
	}
	@Override
	public Range headSet(Integer toElement) {
		return subSet(start,(int)toElement);
	}
	@Override
	public Range tailSet(Integer fromElement) {
		return subSet((int)fromElement,end);
	}
	@Override
	public Comparator<? super Integer> comparator() {
		return null;
	}
	@Override
	public Integer first() {
		if(this.isEmpty())throw new NoSuchElementException();
		return start;
	}
	@Override
	public Integer last() {
		if(this.isEmpty())throw new NoSuchElementException();
		return end-1;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new Itr();
	}
	private class Itr implements Iterator<Integer>
	{
		private int cur;
		Itr()
		{
			cur=start;
		}
		@Override
		public boolean hasNext() {
			return cur<end;
		}
		@Override
		public Integer next() {
			if(cur>=end)
				throw new NoSuchElementException();
			return cur++;
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}
