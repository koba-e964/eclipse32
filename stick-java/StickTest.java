import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StickTest {

    protected Stick solution;

    @Before
    public void setUp() {
        solution = new Stick();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int x = 32;

        int expected = 1;
        int actual = solution.pieces(x);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int x = 48;

        int expected = 2;
        int actual = solution.pieces(x);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int x = 23;

        int expected = 4;
        int actual = solution.pieces(x);

        Assert.assertEquals(expected, actual);
    }

}
