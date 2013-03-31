import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StrongPrimePowerTest {

    protected StrongPrimePower solution;

    @Before
    public void setUp() {
        solution = new StrongPrimePower();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String n = "27";

        int[] expected = new int[]{3, 3};
        int[] actual = solution.baseAndExponent(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String n = "10";

        int[] expected = new int[]{};
        int[] actual = solution.baseAndExponent(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String n = "7";

        int[] expected = new int[]{};
        int[] actual = solution.baseAndExponent(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String n = "1296";

        int[] expected = new int[]{};
        int[] actual = solution.baseAndExponent(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String n = "576460752303423488";

        int[] expected = new int[]{2, 59};
        int[] actual = solution.baseAndExponent(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String n = "999999874000003969";

        int[] expected = new int[]{999999937, 2};
        int[] actual = solution.baseAndExponent(n);

        Assert.assertArrayEquals(expected, actual);
    }

}
