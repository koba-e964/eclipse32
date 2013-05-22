package kobae964_app.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssignmentTest {

	@Test
	public void testMatch0() {
		int[][] cost={{1,4,5},{5,7,6},{5,8,8}};
		Assignment sol=new Assignment();
		int[] result=sol.match(cost);
		int[] expected={1,2,0};
		assertArrayEquals(expected, result);
	}
	@Test
	public void testMatch1() {
		int[][] cost={{1,4,5},{5,7,6},{5,8,8}};
		Assignment sol=new Assignment();
		int[] result=sol.match(cost);
		int[] expected={1,2,0};
		assertArrayEquals(expected, result);
	}

}
