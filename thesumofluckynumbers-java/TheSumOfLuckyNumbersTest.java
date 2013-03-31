import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheSumOfLuckyNumbersTest {

    protected TheSumOfLuckyNumbers solution;

    @Before
    public void setUp() {
        solution = new TheSumOfLuckyNumbers();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 11;

        int[] expected = new int[]{4, 7};
        int[] actual = solution.sum(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 12;

        int[] expected = new int[]{4, 4, 4};
        int[] actual = solution.sum(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 13;

        int[] expected = new int[]{};
        int[] actual = solution.sum(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 100;

        int[] expected = new int[]{4, 4, 4, 44, 44};
        int[] actual = solution.sum(n);

        Assert.assertArrayEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        int n = 44448;

        int[] expected = new int[]{4, n-4};
        int[] actual = solution.sum(n);

        Assert.assertArrayEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void sysTestCase0()
    {
    	int n=895;

    int expected[]=
    {4, 444, 447};

        int[] actual = solution.sum(n);

        Assert.assertArrayEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void sysTestCase1()
    {
    	int n=1000000;


        int[] actual = solution.sum(n);

    }

    @Test(timeout=2000)
    public void sysTestCase2()
    {
    	int n=998368;
    	int[] expected={44, 44, 444, 4444, 44444, 474474, 474474};
        int[] actual = solution.sum(n);
        Assert.assertArrayEquals(expected, actual);
    }

}
