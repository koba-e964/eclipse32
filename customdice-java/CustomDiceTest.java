import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomDiceTest {

    protected CustomDice solution;

    @Before
    public void setUp() {
        solution = new CustomDice();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int M = 3;

        int expected = 0;
        int actual = solution.countDice(M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int M = 4;

        int expected = 210;
        int actual = solution.countDice(M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int M = 10;

        int expected = 863010;
        int actual = solution.countDice(M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int M = 50;

        int expected = 375588112;
        int actual = solution.countDice(M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void myTestCase0() {
        int M = 1000000;

        int expected = 375588112;
        int actual = solution.countDice(M);

        //Assert.assertEquals(expected, actual);
    }
}
