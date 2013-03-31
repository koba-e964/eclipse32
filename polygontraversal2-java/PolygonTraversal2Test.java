import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolygonTraversal2Test {

    protected PolygonTraversal2 solution;

    @Before
    public void setUp() {
        solution = new PolygonTraversal2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 5;
        int[] points = new int[]{1, 3, 5};

        int expected = 1;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 6;
        int[] points = new int[]{1, 4, 2};

        int expected = 1;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 7;
        int[] points = new int[]{2, 4, 7};

        int expected = 2;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 7;
        int[] points = new int[]{1, 2, 3, 4, 6, 5};

        int expected = 0;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int N = 11;
        int[] points = new int[]{1, 5, 10};

        int expected = 1412;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        int N = 13;
        int[] points = new int[]{1, 5};

        int expected = 0;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase1() {
        int N = 4;
        int[] points = new int[]{1, 2};

        int expected = 0;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase2() {
        int N = 4;
        int[] points = new int[]{1, 2,4};

        int expected = 0;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase3() {
        int N = 5;
        int[] points = new int[]{1, 3,4};

        int expected = 0;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase4() {
        int N = 6;
        int[] points = new int[]{1, 5,3};

        int expected = 1;
        int actual = solution.count(N, points);

        Assert.assertEquals(expected, actual);
    }

}
