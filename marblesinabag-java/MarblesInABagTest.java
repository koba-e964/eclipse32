import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MarblesInABagTest {

    protected MarblesInABag solution;

    @Before
    public void setUp() {
        solution = new MarblesInABag();
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
        int redCount = 1;
        int blueCount = 2;

        double expected = 0.3333333333333333;
        double actual = solution.getProbability(redCount, blueCount);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int redCount = 2;
        int blueCount = 3;

        double expected = 0.13333333333333333;
        double actual = solution.getProbability(redCount, blueCount);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int redCount = 2;
        int blueCount = 5;

        double expected = 0.22857142857142856;
        double actual = solution.getProbability(redCount, blueCount);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int redCount = 11;
        int blueCount = 6;

        double expected = 0.0;
        double actual = solution.getProbability(redCount, blueCount);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int redCount = 4;
        int blueCount = 11;

        double expected = 0.12183372183372182;
        double actual = solution.getProbability(redCount, blueCount);

        assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        int redCount = 1999;
        int blueCount = 4000;

        double expected = 0.12183372183372182;
        double actual = solution.getProbability(redCount, blueCount);

        //assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase8() {
        int redCount = 3999;
        int blueCount = 4000;

        double expected = 0.;
        double actual = solution.getProbability(redCount, blueCount);

        assertEquals(expected, actual);
    }

}
