import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HoleCakeCutsTest {

    protected HoleCakeCuts solution;

    @Before
    public void setUp() {
        solution = new HoleCakeCuts();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int cakeLength = 5;
        int holeLength = 3;
        int[] horizontalCuts = new int[]{1, -4};
        int[] verticalCuts = new int[]{1};

        int expected = 6;
        int actual = solution.cutTheCake(cakeLength, holeLength, horizontalCuts, verticalCuts);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int cakeLength = 10;
        int holeLength = 5;
        int[] horizontalCuts = new int[]{};
        int[] verticalCuts = new int[]{-2, 2};

        int expected = 4;
        int actual = solution.cutTheCake(cakeLength, holeLength, horizontalCuts, verticalCuts);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int cakeLength = 10;
        int holeLength = 5;
        int[] horizontalCuts = new int[]{1};
        int[] verticalCuts = new int[]{-5, 5};

        int expected = 6;
        int actual = solution.cutTheCake(cakeLength, holeLength, horizontalCuts, verticalCuts);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int cakeLength = 50;
        int holeLength = 5;
        int[] horizontalCuts = new int[]{40, -40};
        int[] verticalCuts = new int[]{20, 0, -20};

        int expected = 12;
        int actual = solution.cutTheCake(cakeLength, holeLength, horizontalCuts, verticalCuts);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase105() {
        int cakeLength = 58;
        int holeLength = 16;
        int[] horizontalCuts = new int[]{-31, 40};
        int[] verticalCuts = new int[]{8,13};

        int expected = 10;
        int actual = solution.cutTheCake(cakeLength, holeLength, horizontalCuts, verticalCuts);

        Assert.assertEquals(expected, actual);
    }

}
