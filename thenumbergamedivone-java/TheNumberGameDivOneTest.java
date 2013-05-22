import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheNumberGameDivOneTest {

    protected TheNumberGameDivOne solution;

    @Before
    public void setUp() {
        solution = new TheNumberGameDivOne();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        long n = 6L;

        String expected = "John";
        String actual = solution.find(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        long n = 2L;

        String expected = "Brus";
        String actual = solution.find(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        long n = 747L;

        String expected = "Brus";
        String actual = solution.find(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        long n = 128L;

        String expected = "Brus";
        String actual = solution.find(n);

        Assert.assertEquals(expected, actual);
    }

}
