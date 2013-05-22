import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpiralRouteTest {

    protected SpiralRoute solution;

    @Before
    public void setUp() {
        solution = new SpiralRoute();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int width = 6;
        int length = 4;

        int[] expected = new int[]{1, 2};
        int[] actual = solution.thronePosition(width, length);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int width = 6;
        int length = 5;

        int[] expected = new int[]{3, 2};
        int[] actual = solution.thronePosition(width, length);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int width = 1;
        int length = 11;

        int[] expected = new int[]{0, 10};
        int[] actual = solution.thronePosition(width, length);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int width = 12;
        int length = 50;

        int[] expected = new int[]{5, 6};
        int[] actual = solution.thronePosition(width, length);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int width = 5000;
        int length = 5000;

        int[] expected = new int[]{2499, 2500};
        int[] actual = solution.thronePosition(width, length);

        Assert.assertArrayEquals(expected, actual);
    }

}
