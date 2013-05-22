import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheSwapsDivOneTest {

    protected TheSwapsDivOne solution;

    @Before
    public void setUp() {
        solution = new TheSwapsDivOne();
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
        String[] sequence = new String[]{"4", "77"};
        int k = 1;

        double expected = 10.0;
        double actual = solution.find(sequence, k);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] sequence = new String[]{"4", "77"};
        int k = 47;

        double expected = 10.0;
        double actual = solution.find(sequence, k);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] sequence = new String[]{"1", "1", "1", "1", "1", "1", "1"};
        int k = 1000000;

        double expected = 3.0;
        double actual = solution.find(sequence, k);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] sequence = new String[]{"572685085149095989026478064633266980348504469", "19720257361", "9", "69"};
        int k = 7;

        double expected = 98.3238536775161;
        double actual = solution.find(sequence, k);

        assertEquals(expected, actual);
    }

}
