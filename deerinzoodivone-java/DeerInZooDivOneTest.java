import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeerInZooDivOneTest {

    protected DeerInZooDivOne solution;

    @Before
    public void setUp() {
        solution = new DeerInZooDivOne();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] a = new int[]{0, 1, 2};
        int[] b = new int[]{1, 2, 3};

        int expected = 2;
        int actual = solution.getmax(a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] a = new int[]{1, 8, 1, 7, 4, 2, 5, 2};
        int[] b = new int[]{5, 3, 6, 8, 2, 6, 8, 0};

        int expected = 4;
        int actual = solution.getmax(a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] a = new int[]{0};
        int[] b = new int[]{1};

        int expected = 1;
        int actual = solution.getmax(a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] a = new int[]{0, 11, 10, 10, 19, 17, 6, 17, 19, 10, 10, 11, 9, 9, 14, 2, 13, 11, 6};
        int[] b = new int[]{7, 5, 2, 12, 8, 9, 16, 8, 4, 18, 8, 13, 15, 13, 17, 16, 3, 1, 7};

        int expected = 8;
        int actual = solution.getmax(a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] a = new int[]{14, 13, 28, 15, 20, 4, 9, 6, 1, 23, 19, 25, 25, 8, 14, 16, 2, 8, 15, 25, 22, 22, 28, 10, 10, 14, 24, 27, 8};
        int[] b = new int[]{21, 5, 12, 13, 27, 1, 24, 17, 27, 17, 23, 14, 18, 26, 7, 26, 11, 0, 25, 23, 3, 29, 22, 11, 22, 29, 15, 28, 29};

        int expected = 11;
        int actual = solution.getmax(a, b);

        Assert.assertEquals(expected, actual);
    }

}
