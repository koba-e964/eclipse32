/**
 * 
 */
package kobae964_app.algo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author 2adc
 *
 */
public class RandomContractionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solution=new RandomContraction();
	}
	protected RandomContraction solution;

	/**
	 * Test method for {@link kobae964_app.algo.RandomContraction#action(int[][])}.
	 */
	@Test
	public void testCase0()
	{
		int[][] graph=new int[][]{{0,1,1,0,},{1,0,1,1,},{1,1,0,1,},{0,1,1,0}};
		int[] actual=solution.action(graph);
		assertEquals(2, actual.length);
	}

}
