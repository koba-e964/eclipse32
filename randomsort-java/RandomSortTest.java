import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomSortTest {

    protected RandomSort solution;

    @Before
    public void setUp() {
        solution = new RandomSort();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] permutation = new int[]{1, 3, 2};

        double expected = 1.0;
        double actual = solution.getExpected(permutation);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] permutation = new int[]{4, 3, 2, 1};

        double expected = 4.066666666666666;
        double actual = solution.getExpected(permutation);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] permutation = new int[]{1};

        double expected = 0.0;
        double actual = solution.getExpected(permutation);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] permutation = new int[]{2, 5, 1, 6, 3, 4};

        double expected = 5.666666666666666;
        double actual = solution.getExpected(permutation);

        assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase3() {
        int[] permutation = new int[]{2, 5, 8, 6, 3, 4,1,7};

        double actual = solution.getExpected(permutation);

    }

}
