import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterBoardTest {

    protected CharacterBoard solution;

    @Before
    public void setUp() {
        solution = new CharacterBoard();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] fragment = new String[]{"dea", "abc"};
        int W = 7;
        int i0 = 1;
        int j0 = 1;

        int expected = 1;
        int actual = solution.countGenerators(fragment, W, i0, j0);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] fragment = new String[]{"xyxxy"};
        int W = 6;
        int i0 = 1;
        int j0 = 0;

        int expected = 28;
        int actual = solution.countGenerators(fragment, W, i0, j0);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] fragment = new String[]{"gogogo", "jijiji", "rarara"};
        int W = 6;
        int i0 = 0;
        int j0 = 0;

        int expected = 0;
        int actual = solution.countGenerators(fragment, W, i0, j0);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] fragment = new String[]{"abababacac", "aaacacacbb", "ccabababab"};
        int W = 8827;
        int i0 = 104;
        int j0 = 6022;

        int expected = 829146844;
        int actual = solution.countGenerators(fragment, W, i0, j0);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase5() {
        String[] fragment = new String[]{"aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa"};
        int W = 1000000000;
        int i0 = 0;
        int j0 = 0;

        int expected = 471477008;
        int actual = solution.countGenerators(fragment, W, i0, j0);

        Assert.assertEquals(expected, actual);
    }

}
