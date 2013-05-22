import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterBoard2Test {

    protected CharacterBoard2 solution;

    @Before
    public void setUp() {
        solution = new CharacterBoard2();
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
        int W = 882;
        int i0 = 10;
        int j0 = 62;

        int expected = 361706985;
        int actual = solution.countGenerators(fragment, W, i0, j0);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] fragment = new String[]{"asjkffqw", "basjkffq", "qbasjkff", "qqbasjkf"};
        int W = 9031;
        int i0 = 9024;
        int j0 = 1959;

        int expected = 173947456;
        int actual = solution.countGenerators(fragment, W, i0, j0);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        String[] fragment = new String[]{"aaaaaaaaaa", "aaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaa","aaaaaaaaab",};
        int W = 10000;
        int i0 = 1000;
        int j0 = 1959;

        int expected = 173947456;
        int actual = solution.countGenerators(fragment, W, i0, j0);

        //Assert.assertEquals(expected, actual);
    }

}
