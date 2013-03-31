import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheLargestLuckyNumberTest {

    protected TheLargestLuckyNumber solution;

    @Before
    public void setUp() {
        solution = new TheLargestLuckyNumber();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 100;

        int expected = 77;
        int actual = solution.find(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 75;

        int expected = 74;
        int actual = solution.find(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 5;

        int expected = 4;
        int actual = solution.find(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 474747;

        int expected = 474747;
        int actual = solution.find(n);

        Assert.assertEquals(expected, actual);
    }

}
