import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetToTheTopTest {

    protected GetToTheTop solution;

    @Before
    public void setUp() {
        solution = new GetToTheTop();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int K = 2;
        int[] sweets = new int[]{1, 2, 3, 4, 3, 5};
        int[] x = new int[]{1, 1, 1, 4, 5, 5};
        int[] y = new int[]{1, 3, 4, 1, 2, 3};
        int[] stairLength = new int[]{2, 1, 1, 2, 1, 1};

        int expected = 13;
        int actual = solution.collectSweets(K, sweets, x, y, stairLength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int K = 4;
        int[] sweets = new int[]{2, 8, 7, 4, 1, 4, 7, 5, 11, 4};
        int[] x = new int[]{2, 9, 4, 6, 10, 5, 2, 8, 1, 10};
        int[] y = new int[]{1, 1, 3, 3, 3, 5, 6, 6, 8, 9};
        int[] stairLength = new int[]{2, 2, 1, 2, 2, 2, 4, 3, 2, 2};

        int expected = 47;
        int actual = solution.collectSweets(K, sweets, x, y, stairLength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int K = 10;
        int[] sweets = new int[]{1, 3, 5, 7};
        int[] x = new int[]{1, 6, 2, 8};
        int[] y = new int[]{2, 4, 1, 2};
        int[] stairLength = new int[]{4, 1, 7, 4};

        int expected = 16;
        int actual = solution.collectSweets(K, sweets, x, y, stairLength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int K = 3;
        int[] sweets = new int[]{80, 20, 15, 13, 10, 7, 8, 9, 1, 4, 3, 15, 14, 19, 22, 12, 6, 15, 10, 30, 1, 1};
        int[] x = new int[]{2, 8, 11, 17, 20, 14, 10, 16, 8, 14, 19, 6, 6, 6, 6, 15, 15, 15, 14, 20, 20, 20};
        int[] y = new int[]{1, 2, 3, 2, 1, 4, 6, 7, 8, 8, 8, 9, 10, 11, 12, 9, 10, 11, 12, 9, 10, 11};
        int[] stairLength = new int[]{2, 2, 2, 2, 2, 2, 3, 2, 3, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int expected = 129;
        int actual = solution.collectSweets(K, sweets, x, y, stairLength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int K = 10;
        int[] sweets = new int[]{0, 10, 11, 2, 0};
        int[] x = new int[]{1, 26, 29, 22, 3};
        int[] y = new int[]{1, 83, 88, 22, 5};
        int[] stairLength = new int[]{11, 1, 23, 15, 8};

        int expected = 0;
        int actual = solution.collectSweets(K, sweets, x, y, stairLength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int K = 5;
        int[] sweets = new int[]{2, 0, 5};
        int[] x = new int[]{1, 8, 9};
        int[] y = new int[]{6, 6, 1};
        int[] stairLength = new int[]{3, 6, 3};

        int expected = 7;
        int actual = solution.collectSweets(K, sweets, x, y, stairLength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        int K = 2;
        int[] sweets = new int[]{2, 9, 9, 1, 9, 9, 8};
        int[] x = new int[]{10, 8, 6, 6, 8, 7, 3};
        int[] y = new int[]{6, 7, 5, 4, 5, 2, 5};
        int[] stairLength = new int[]{1, 1, 1, 1, 1, 1, 1};

        int expected = 47;
        int actual = solution.collectSweets(K, sweets, x, y, stairLength);

        Assert.assertEquals(expected, actual);
    }

}
