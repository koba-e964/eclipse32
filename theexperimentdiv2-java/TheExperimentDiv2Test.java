import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheExperimentDiv2Test {

    protected TheExperimentDiv2 solution;

    @Before
    public void setUp() {
        solution = new TheExperimentDiv2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] intensity = new int[]{3, 4, 1, 1, 5, 6};
        int L = 3;
        int[] leftEnd = new int[]{3, 1, 0};

        int[] expected = new int[]{12, 5, 3};
        int[] actual = solution.determineHumidity(intensity, L, leftEnd);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] intensity = new int[]{5, 5};
        int L = 2;
        int[] leftEnd = new int[]{0, 0};

        int[] expected = new int[]{10, 0};
        int[] actual = solution.determineHumidity(intensity, L, leftEnd);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] intensity = new int[]{92, 11, 1000, 14, 3};
        int L = 2;
        int[] leftEnd = new int[]{0, 3};

        int[] expected = new int[]{103, 17};
        int[] actual = solution.determineHumidity(intensity, L, leftEnd);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] intensity = new int[]{2, 6, 15, 10, 8, 11, 99, 2, 4, 4, 4, 13};
        int L = 4;
        int[] leftEnd = new int[]{1, 7, 4, 5, 8, 0};

        int[] expected = new int[]{39, 14, 110, 0, 13, 2};
        int[] actual = solution.determineHumidity(intensity, L, leftEnd);

        Assert.assertArrayEquals(expected, actual);
    }

}
