import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DreamingAboutCarrotsTest {

    protected DreamingAboutCarrots solution;

    @Before
    public void setUp() {
        solution = new DreamingAboutCarrots();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int x1 = 1;
        int y1 = 1;
        int x2 = 5;
        int y2 = 5;

        int expected = 3;
        int actual = solution.carrotsBetweenCarrots(x1, y1, x2, y2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 1;
        int y2 = 1;

        int expected = 0;
        int actual = solution.carrotsBetweenCarrots(x1, y1, x2, y2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int x1 = 50;
        int y1 = 48;
        int x2 = 0;
        int y2 = 0;

        int expected = 1;
        int actual = solution.carrotsBetweenCarrots(x1, y1, x2, y2);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 42;
        int y2 = 36;

        int expected = 5;
        int actual = solution.carrotsBetweenCarrots(x1, y1, x2, y2);

        Assert.assertEquals(expected, actual);
    }

}
