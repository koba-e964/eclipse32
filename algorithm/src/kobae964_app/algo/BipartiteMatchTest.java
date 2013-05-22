package kobae964_app.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class BipartiteMatchTest {
	static boolean[] toBooleans(int n,long val)
	{
		boolean[] ret=new boolean[n];
		for(int i=0;i<n;i++)
		{
			ret[i]=(val&(1L<<i))!=0;
		}
		return ret;
	}
	@Test
	public void testMatch0() {
		boolean[][] graph={
				{true,true,false},
				{false,true,true},
				{true,false,false}};
		BipartiteMatch inst=new BipartiteMatch(graph);
		int[] actuals=inst.match();
		int[] expecteds={1,2,0};
		assertArrayEquals(expecteds, actuals);
	}
	@Test
	public void testMatch1() {
		boolean[][] graph={
				toBooleans(4,9L),
				toBooleans(4,6L),
				toBooleans(4,2L),
				toBooleans(4,1L)};
		BipartiteMatch inst=new BipartiteMatch(graph);
		int[] actuals=inst.match();
		int[] expecteds={3,2,1,0};
		assertArrayEquals(expecteds, actuals);
	}

}
