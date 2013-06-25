import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomPaintingOnABoardTest {

    protected RandomPaintingOnABoard solution;

    @Before
    public void setUp() {
        solution = new RandomPaintingOnABoard();
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
        String[] prob = new String[]{"10", "01"};

        double expected = 3.0;
        double actual = solution.expectedSteps(prob);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] prob = new String[]{"11", "11"};

        double expected = 3.6666666666666665;
        double actual = solution.expectedSteps(prob);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] prob = new String[]{"11", "12"};

        double expected = 3.9166666666666665;
        double actual = solution.expectedSteps(prob);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] prob = new String[]{"0976", "1701", "7119"};

        double expected = 11.214334077031307;
        double actual = solution.expectedSteps(prob);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] prob = new String[]{"000000000000001000000", "888999988889890999988", "988889988899980889999", "889898998889980999898", "988889999989880899999", "998888998988990989998", "998988999898990889899"};

        double expected = 1028.7662876159634;
        double actual = solution.expectedSteps(prob);

        assertEquals(expected, actual);
    }

}
