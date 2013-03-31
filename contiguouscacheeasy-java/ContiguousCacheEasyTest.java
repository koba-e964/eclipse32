import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContiguousCacheEasyTest {

    protected ContiguousCacheEasy solution;

    @Before
    public void setUp() {
        solution = new ContiguousCacheEasy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 100;
        int k = 5;
        int[] addresses = new int[]{6, 0, 3, 20, 22, 16};

        int expected = 13;
        int actual = solution.bytesRead(n, k, addresses);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 100;
        int k = 1;
        int[] addresses = new int[]{0, 4, 6, 6, 4, 10};

        int expected = 4;
        int actual = solution.bytesRead(n, k, addresses);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 1000;
        int k = 999;
        int[] addresses = new int[]{0, 4, 123, 987, 999, 500, 0};

        int expected = 2;
        int actual = solution.bytesRead(n, k, addresses);

        Assert.assertEquals(expected, actual);
    }

}
