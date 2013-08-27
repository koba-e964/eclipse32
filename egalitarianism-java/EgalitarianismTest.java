import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EgalitarianismTest {

    protected Egalitarianism solution;

    @Before
    public void setUp() {
        solution = new Egalitarianism();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] isFriend = new String[]{"NYN", "YNY", "NYN"};
        int d = 10;

        int expected = 20;
        int actual = solution.maxDifference(isFriend, d);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] isFriend = new String[]{"NN", "NN"};
        int d = 1;

        int expected = -1;
        int actual = solution.maxDifference(isFriend, d);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] isFriend = new String[]{"NNYNNN", "NNYNNN", "YYNYNN", "NNYNYY", "NNNYNN", "NNNYNN"};
        int d = 1000;

        int expected = 3000;
        int actual = solution.maxDifference(isFriend, d);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] isFriend = new String[]{"NNYN", "NNNY", "YNNN", "NYNN"};
        int d = 584;

        int expected = -1;
        int actual = solution.maxDifference(isFriend, d);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] isFriend = new String[]{"NYNYYYN", "YNNYYYN", "NNNNYNN", "YYNNYYN", "YYYYNNN", "YYNYNNY", "NNNNNYN"};
        int d = 5;

        int expected = 20;
        int actual = solution.maxDifference(isFriend, d);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] isFriend = new String[]{"NYYNNNNYYYYNNNN", "YNNNYNNNNNNYYNN", "YNNYNYNNNNYNNNN", "NNYNNYNNNNNNNNN", "NYNNNNYNNYNNNNN", "NNYYNNYNNYNNNYN", "NNNNYYNNYNNNNNN", "YNNNNNNNNNYNNNN", "YNNNNNYNNNNNYNN", "YNNNYYNNNNNNNNY", "YNYNNNNYNNNNNNN", "NYNNNNNNNNNNNNY", "NYNNNNNNYNNNNYN", "NNNNNYNNNNNNYNN", "NNNNNNNNNYNYNNN"};
        int d = 747;

        int expected = 2988;
        int actual = solution.maxDifference(isFriend, d);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String[] isFriend = new String[]{"NY", "YN"};
        int d = 0;

        int expected = 0;
        int actual = solution.maxDifference(isFriend, d);

        Assert.assertEquals(expected, actual);
    }

}
