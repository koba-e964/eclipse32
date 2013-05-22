import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArithmeticProgressionTest {

    protected ArithmeticProgression solution;

    @Before
    public void setUp() {
        solution = new ArithmeticProgression();
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
        int a0 = 0;
        int[] seq = new int[]{6, 13, 20, 27};

        double expected = 6.75;
        double actual = solution.minCommonDifference(a0, seq);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int a0 = 1;
        int[] seq = new int[]{2, 3, 4, 5, 6};

        double expected = 1.0;
        double actual = solution.minCommonDifference(a0, seq);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int a0 = 3;
        int[] seq = new int[]{};

        double expected = 0.0;
        double actual = solution.minCommonDifference(a0, seq);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int a0 = 3;
        int[] seq = new int[]{3, 3, 3, 3, 4};

        double expected = 0.2;
        double actual = solution.minCommonDifference(a0, seq);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int a0 = 1;
        int[] seq = new int[]{-3};

        double expected = -1.0;
        double actual = solution.minCommonDifference(a0, seq);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int a0 = 0;
        int[] seq = new int[]{6, 14};

        double expected = -1.0;
        double actual = solution.minCommonDifference(a0, seq);

        assertEquals(expected, actual);
    }

}
