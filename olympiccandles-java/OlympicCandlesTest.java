import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OlympicCandlesTest {

    protected OlympicCandles solution;

    @Before
    public void setUp() {
        solution = new OlympicCandles();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] candles = new int[]{2, 2, 2};

        int expected = 3;
        int actual = solution.numberOfNights(candles);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] candles = new int[]{2, 2, 2, 4};

        int expected = 4;
        int actual = solution.numberOfNights(candles);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] candles = new int[]{5, 2, 2, 1};

        int expected = 3;
        int actual = solution.numberOfNights(candles);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] candles = new int[]{1, 2, 3, 4, 5, 6};

        int expected = 6;
        int actual = solution.numberOfNights(candles);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] candles = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int expected = 4;
        int actual = solution.numberOfNights(candles);

        Assert.assertEquals(expected, actual);
    }

}
