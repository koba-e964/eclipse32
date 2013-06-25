import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EelAndRabbitTest {

    protected EelAndRabbit solution;

    @Before
    public void setUp() {
        solution = new EelAndRabbit();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] l = new int[]{2, 4, 3, 2, 2, 1, 10};
        int[] t = new int[]{2, 6, 3, 7, 0, 2, 0};

        int expected = 6;
        int actual = solution.getmax(l, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] l = new int[]{1, 1, 1};
        int[] t = new int[]{2, 0, 4};

        int expected = 2;
        int actual = solution.getmax(l, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] l = new int[]{1};
        int[] t = new int[]{1};

        int expected = 1;
        int actual = solution.getmax(l, t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] l = new int[]{8, 2, 1, 10, 8, 6, 3, 1, 2, 5};
        int[] t = new int[]{17, 27, 26, 11, 1, 27, 23, 12, 11, 13};

        int expected = 7;
        int actual = solution.getmax(l, t);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        int[] l = new int[]{8, 2, 1, 10, 8, 6, 3, 1, 2, 5,8, 2, 1, 10, 8, 6, 3, 1, 2, 5,8, 2, 1, 10, 8, 6, 3, 1, 2, 5,8, 2, 1, 10, 8, 6, 3, 1, 2, 5,8, 2, 1, 10, 8, 6, 3, 1, 2, 5,};
        int[] t = new int[]{17, 27, 26, 11, 1, 27, 23, 12, 11, 13,8, 2, 1, 10, 8, 6, 3, 1, 2, 5,8, 2, 1, 10, 8, 6, 3, 1, 2, 5,8, 2, 1, 10, 8, 6, 3, 1, 2, 5,8, 2, 1, 10, 8, 6, 3, 1, 2, 5};

        int expected = 7;
        int actual = solution.getmax(l, t);

        //Assert.assertEquals(expected, actual);
    }

}
