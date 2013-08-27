import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GooseTattarrattatDiv1Test {

    protected GooseTattarrattatDiv1 solution;

    @Before
    public void setUp() {
        solution = new GooseTattarrattatDiv1();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String S = "geese";

        int expected = 2;
        int actual = solution.getmin(S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String S = "tattarrattat";

        int expected = 0;
        int actual = solution.getmin(S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String S = "xyyzzzxxx";

        int expected = 2;
        int actual = solution.getmin(S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String S = "xrepayuyubctwtykrauccnquqfuqvccuaakylwlcjuyhyammag";

        int expected = 11;
        int actual = solution.getmin(S);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String S = "abaabb";

        int expected = 3;
        int actual = solution.getmin(S);

        Assert.assertEquals(expected, actual);
    }

}
