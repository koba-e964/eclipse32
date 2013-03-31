import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkiResortsEasyTest {

    protected SkiResortsEasy solution;

    @Before
    public void setUp() {
        solution = new SkiResortsEasy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] altitude = new int[]{30, 20, 20, 10};

        int expected = 0;
        int actual = solution.minCost(altitude);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] altitude = new int[]{5, 7, 3};

        int expected = 2;
        int actual = solution.minCost(altitude);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] altitude = new int[]{6, 8, 5, 4, 7, 4, 2, 3, 1};

        int expected = 6;
        int actual = solution.minCost(altitude);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] altitude = new int[]{749, 560, 921, 166, 757, 818, 228, 584, 366, 88};

        int expected = 2284;
        int actual = solution.minCost(altitude);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] altitude = new int[]{712, 745, 230, 200, 648, 440, 115, 913, 627, 621, 186, 222, 741, 954, 581, 193, 266, 320, 798, 745};

        int expected = 6393;
        int actual = solution.minCost(altitude);

        Assert.assertEquals(expected, actual);
    }

}
