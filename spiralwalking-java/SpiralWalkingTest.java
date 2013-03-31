import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpiralWalkingTest {

    protected SpiralWalking solution;

    @Before
    public void setUp() {
        solution = new SpiralWalking();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] levelMap = new String[]{"111", "111", "111"};

        int expected = 5;
        int actual = solution.totalPoints(levelMap);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] levelMap = new String[]{"101", "110"};

        int expected = 3;
        int actual = solution.totalPoints(levelMap);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] levelMap = new String[]{"00", "10"};

        int expected = 1;
        int actual = solution.totalPoints(levelMap);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] levelMap = new String[]{"86850", "76439", "15863", "24568", "45679", "71452", "05483"};

        int expected = 142;
        int actual = solution.totalPoints(levelMap);

        Assert.assertEquals(expected, actual);
    }

}
