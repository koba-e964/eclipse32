import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationsTest {

    protected Excavations solution;

    @Before
    public void setUp() {
        solution = new Excavations();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] kind = new int[]{1, 1, 2, 2};
        int[] depth = new int[]{10, 15, 10, 20};
        int[] found = new int[]{1};
        int K = 2;

        long expected = 3L;
        long actual = solution.count(kind, depth, found, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] kind = new int[]{1, 1, 2, 2};
        int[] depth = new int[]{10, 15, 10, 20};
        int[] found = new int[]{1, 2};
        int K = 2;

        long expected = 4L;
        long actual = solution.count(kind, depth, found, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] kind = new int[]{1, 2, 3, 4};
        int[] depth = new int[]{10, 10, 10, 10};
        int[] found = new int[]{1, 2};
        int K = 3;

        long expected = 0L;
        long actual = solution.count(kind, depth, found, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] kind = new int[]{1, 2, 2, 3, 1, 3, 2, 1, 2};
        int[] depth = new int[]{12512, 12859, 125, 1000, 99, 114, 125, 125, 114};
        int[] found = new int[]{1, 2, 3};
        int K = 7;

        long expected = 35L;
        long actual = solution.count(kind, depth, found, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] kind = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
        int[] depth = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3};
        int[] found = new int[]{50};
        int K = 18;

        long expected = 9075135300L;
        long actual = solution.count(kind, depth, found, K);

        Assert.assertEquals(expected, actual);
    }

}
