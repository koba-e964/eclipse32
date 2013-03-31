package kobae964_app.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class DijkstraTest {

	@Test
	public void test0Shortest() {
		int[][] mat=
			{
				{0,2},
				{3,0},
			};
		int start=0;
		int end=1;
		Dijkstra inst=new Dijkstra(mat);
		int[] expected={0,2};
		int[] actual=inst.shortests(start);
		assertArrayEquals(expected, actual);
	}
	@Test
	public void test1Shortest() {
		int[][] mat=
			{
				{0,2,-1,5,3,-1},
				{2,0,4,3,-1,-1},
				{-1,4,0,2,4,3},
				{-1,-1,2,0,-1,-1},
				{-1,-1,4,3,0,-1},
				{-1,-1,3,-1,-1,-1}
			};
		int start=0;
		Dijkstra inst=new Dijkstra(mat);
		int[] expected={0,2,6,5,3,9};
		int[] actual=inst.shortests(start);
		assertArrayEquals(expected, actual);
	}
}
