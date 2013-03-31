import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolygonTraversalTest {

    protected PolygonTraversal solution;

    @Before
    public void setUp() {
        solution = new PolygonTraversal();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 5;
        int[] points = new int[]{1, 3, 5};

        long expected = 1L;
        long actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 6;
        int[] points = new int[]{1, 4, 2};

        long expected = 1L;
        long actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 7;
        int[] points = new int[]{2, 4, 7};

        long expected = 2L;
        long actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 7;
        int[] points = new int[]{1, 2, 3, 4, 6, 5};

        long expected = 0L;
        long actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int N = 18;
        int[] points = new int[]{1, 7, 18};

        long expected = 4374612736L;
        long actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

}
