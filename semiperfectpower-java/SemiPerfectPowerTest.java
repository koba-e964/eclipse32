import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SemiPerfectPowerTest {

    protected SemiPerfectPower solution;

    @Before
    public void setUp() {
        solution = new SemiPerfectPower();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        long L = 18L;
        long R = 58L;

        long expected = 9L;
        long actual = solution.count(L, R);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        long L = 1L;
        long R = 10L;

        long expected = 3L;
        long actual = solution.count(L, R);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        long L = 60L;
        long R = 70L;

        long expected = 1L;
        long actual = solution.count(L, R);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        long L = 319268319114310L;
        long R = 35860463407469139L;

        long expected = 95023825161L;
        long actual = solution.count(L, R);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        long L = 1L;
        long R = 80000000000000000L;

        long expected = 169502909978L;
        long actual = solution.count(L, R);

        Assert.assertEquals(expected, actual);
    }

}
