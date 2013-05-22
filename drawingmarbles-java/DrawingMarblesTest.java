import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrawingMarblesTest {

    protected DrawingMarbles solution;

    @Before
    public void setUp() {
        solution = new DrawingMarbles();
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
        int[] colors = new int[]{13};
        int n = 8;

        double expected = 1.0;
        double actual = solution.sameColor(colors, n);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] colors = new int[]{5, 7};
        int n = 1;

        double expected = 1.0;
        double actual = solution.sameColor(colors, n);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] colors = new int[]{5, 6, 7};
        int n = 2;

        double expected = 0.3006535947712418;
        double actual = solution.sameColor(colors, n);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] colors = new int[]{12, 2, 34, 13, 17};
        int n = 4;

        double expected = 0.035028830818304504;
        double actual = solution.sameColor(colors, n);

        assertEquals(expected, actual);
    }

}
