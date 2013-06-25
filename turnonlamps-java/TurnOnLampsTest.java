import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnOnLampsTest {

    protected TurnOnLamps solution;

    @Before
    public void setUp() {
        solution = new TurnOnLamps();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] roads = new int[]{0, 0, 1, 1};
        String initState = "0001";
        String isImportant = "0111";

        int expected = 1;
        int actual = solution.minimize(roads, initState, isImportant);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] roads = new int[]{0, 0, 1, 1};
        String initState = "0000";
        String isImportant = "0111";

        int expected = 2;
        int actual = solution.minimize(roads, initState, isImportant);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] roads = new int[]{0, 0, 1, 1, 4, 4};
        String initState = "000100";
        String isImportant = "111111";

        int expected = 2;
        int actual = solution.minimize(roads, initState, isImportant);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] roads = new int[]{0, 0, 1, 1, 4, 4};
        String initState = "100100";
        String isImportant = "011101";

        int expected = 2;
        int actual = solution.minimize(roads, initState, isImportant);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] roads = new int[]{0, 0, 2, 2, 3, 1, 6, 3, 1};
        String initState = "010001110";
        String isImportant = "000110100";

        int expected = 1;
        int actual = solution.minimize(roads, initState, isImportant);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] roads = new int[]{0, 0, 1, 2, 4, 4, 6, 1, 2, 5, 2, 8, 8, 3, 6, 4, 14, 7, 18, 14, 11, 7, 1, 12, 7, 5, 18, 23, 0, 14, 11, 10, 2, 2, 6, 1, 30, 11, 9, 12, 5, 35, 25, 11, 23, 17, 14, 45, 15};
        String initState = "0000000000010000000000000010000010100000000000000";
        String isImportant = "1010111111111011011111000110111111111111111110111";

        int expected = 14;
        int actual = solution.minimize(roads, initState, isImportant);

        Assert.assertEquals(expected, actual);
    }

}
