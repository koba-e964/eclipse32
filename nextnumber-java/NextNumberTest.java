import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NextNumberTest {

    protected NextNumber solution;

    @Before
    public void setUp() {
        solution = new NextNumber();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 1717;

        int expected = 1718;
        int actual = solution.getNextNumber(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 4;

        int expected = 8;
        int actual = solution.getNextNumber(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 7;

        int expected = 11;
        int actual = solution.getNextNumber(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 12;

        int expected = 17;
        int actual = solution.getNextNumber(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int N = 555555;

        int expected = 555557;
        int actual = solution.getNextNumber(N);

        Assert.assertEquals(expected, actual);
    }

}
