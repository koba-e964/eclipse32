import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnclosingTriangleTest {

    protected EnclosingTriangle solution;

    @Before
    public void setUp() {
        solution = new EnclosingTriangle();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int m = 4;
        int[] x = new int[]{1, 2, 3};
        int[] y = new int[]{1, 3, 2};

        long expected = 19L;
        long actual = solution.getNumber(m, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int m = 7;
        int[] x = new int[]{1, 1, 6, 6};
        int[] y = new int[]{1, 6, 1, 6};

        long expected = 0L;
        long actual = solution.getNumber(m, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int m = 4;
        int[] x = new int[]{2};
        int[] y = new int[]{2};

        long expected = 224L;
        long actual = solution.getNumber(m, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int m = 10;
        int[] x = new int[]{2, 6, 7, 6};
        int[] y = new int[]{7, 7, 9, 3};

        long expected = 81L;
        long actual = solution.getNumber(m, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int m = 15;
        int[] x = new int[]{7, 6, 5, 4, 3};
        int[] y = new int[]{1, 4, 7, 10, 13};

        long expected = 283L;
        long actual = solution.getNumber(m, x, y);

        Assert.assertEquals(expected, actual);
    }

}
