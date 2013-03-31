import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumScoredNumberTest {

    protected MaximumScoredNumber solution;

    @Before
    public void setUp() {
        solution = new MaximumScoredNumber();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int lowerBound = 0;
        int upperBound = 2;

        int expected = 2;
        int actual = solution.getNumber(lowerBound, upperBound);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int lowerBound = 0;
        int upperBound = 30;

        int expected = 25;
        int actual = solution.getNumber(lowerBound, upperBound);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int lowerBound = 0;
        int upperBound = 0;

        int expected = 0;
        int actual = solution.getNumber(lowerBound, upperBound);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int lowerBound = 5;
        int upperBound = 99;

        int expected = 85;
        int actual = solution.getNumber(lowerBound, upperBound);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int lowerBound = 0;
        int upperBound = 10000;

        int expected = 9425;
        int actual = solution.getNumber(lowerBound, upperBound);

        Assert.assertEquals(expected, actual);
    }

}
