import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WolfPackDivTwoTest {

    protected WolfPackDivTwo solution;

    @Before
    public void setUp() {
        solution = new WolfPackDivTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] x = new int[]{3, 5};
        int[] y = new int[]{0, 0};
        int m = 1;

        int expected = 1;
        int actual = solution.calc(x, y, m);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] x = new int[]{0, 1};
        int[] y = new int[]{0, 0};
        int m = 1;

        int expected = 0;
        int actual = solution.calc(x, y, m);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] x = new int[]{0, 2, 4};
        int[] y = new int[]{0, 0, 0};
        int m = 2;

        int expected = 4;
        int actual = solution.calc(x, y, m);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] x = new int[]{7, 8};
        int[] y = new int[]{8, 7};
        int m = 1;

        int expected = 2;
        int actual = solution.calc(x, y, m);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] x = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        int[] y = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        int m = 12;

        int expected = 0;
        int actual = solution.calc(x, y, m);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] x = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        int[] y = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        int m = 31;

        int expected = 573748580;
        int actual = solution.calc(x, y, m);

        Assert.assertEquals(expected, actual);
    }

}
