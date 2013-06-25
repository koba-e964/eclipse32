package kobae964_app.algo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PrimTest {
	private Set<Integer> toSet(int[] array){
		Set<Integer> ret=new HashSet<Integer>();
		for(int e:array){
			ret.add(e);
		}
		return ret;
	}
	private Set<Set<Integer>> toSet(int[][] darray){
		Set<Set<Integer>> ret=new HashSet<Set<Integer>>();
		for(int[] row:darray){
			ret.add(toSet(row));
		}
		return ret;
	}
	@Test
	public void testSolve0() {
		int n=3;
		int[][] einfo={
				{0,1,2},
				{1,2,3},
				{2,0,6},
		};
		Prim sol=new Prim(n, einfo);
		Set<Set<Integer>> expected=toSet(new int[][]{{0,1},{1,2}});
		for(int i=0;i<n;i++){
			int[][] actual=sol.solve(i);
			Set<Set<Integer>> aset=toSet(actual);
			assertEquals(expected, aset);
		}
	}
	@Test
	public void testSolve1() {
		//Wikipedia
		int n=7;
		int[][] einfo={
				{0,1,7},
				{1,2,8},
				{0,3,5},
				{1,3,9},
				{1,4,7},
				{2,4,5},
				{3,4,15},
				{3,5,6},
				{4,5,8},
				{4,6,9},
				{5,6,11},
		};
		Prim sol=new Prim(n, einfo);
		Set<Set<Integer>> expected=toSet(new int[][]{{2,4},{4,1},{1,0},{0,3},{3,5},{4,6}});
		for(int i=0;i<n;i++){
			int[][] actual=sol.solve(i);
			Set<Set<Integer>> aset=toSet(actual);
			assertEquals(expected, aset);
		}
	}
	@Test
	public void testSolve2() {
		int n=2;
		int[][] einfo={
		};
		Prim sol=new Prim(n, einfo);
		try{
			int[][] actual=sol.solve(0);
		}catch(Exception ex){
			//ok
			System.out.println(ex);
			return;
		}
		fail();
	}
}
