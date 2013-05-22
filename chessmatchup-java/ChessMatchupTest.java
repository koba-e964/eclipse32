import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessMatchupTest {

    protected ChessMatchup solution;

    @Before
    public void setUp() {
        solution = new ChessMatchup();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] us = new int[]{5, 8};
        int[] them = new int[]{7, 3};

        int expected = 4;
        int actual = solution.maximumScore(us, them);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] us = new int[]{7, 3};
        int[] them = new int[]{5, 8};

        int expected = 2;
        int actual = solution.maximumScore(us, them);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] us = new int[]{10, 5, 1};
        int[] them = new int[]{10, 5, 1};

        int expected = 4;
        int actual = solution.maximumScore(us, them);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] us = new int[]{1, 10, 7, 4};
        int[] them = new int[]{15, 3, 8, 7};

        int expected = 5;
        int actual = solution.maximumScore(us, them);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 10000)
    public void sysYestCase28() {
        int[] us ={1, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 1, 1, 1};
        int[] them = {2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 1};

        int expected = 42;
        int actual = solution.maximumScore(us, them);

        Assert.assertEquals(expected, actual);
    }
    

}
