import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheLuckyNumbersTest {

    protected TheLuckyNumbers solution;

    @Before
    public void setUp() {
        solution = new TheLuckyNumbers();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int a = 1;
        int b = 10;

        int expected = 2;
        int actual = solution.count(a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int a = 11;
        int b = 20;

        int expected = 0;
        int actual = solution.count(a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int a = 74;
        int b = 77;

        int expected = 2;
        int actual = solution.count(a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int a = 1000000;
        int b = 5000000;

        int expected = 64;
        int actual = solution.count(a, b);

        Assert.assertEquals(expected, actual);
    }

}
