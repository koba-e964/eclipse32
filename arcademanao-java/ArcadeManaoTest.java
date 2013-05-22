import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArcadeManaoTest {

    protected ArcadeManao solution;

    @Before
    public void setUp() {
        solution = new ArcadeManao();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] level = new String[]{"XXXX....", "...X.XXX", "XXX..X..", "......X.", "XXXXXXXX"};
        int coinRow = 2;
        int coinColumn = 4;

        int expected = 2;
        int actual = solution.shortestLadder(level, coinRow, coinColumn);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] level = new String[]{"XXXX", "...X", "XXXX"};
        int coinRow = 1;
        int coinColumn = 1;

        int expected = 1;
        int actual = solution.shortestLadder(level, coinRow, coinColumn);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] level = new String[]{"..X..", ".X.X.", "X...X", ".X.X.", "..X..", "XXXXX"};
        int coinRow = 1;
        int coinColumn = 3;

        int expected = 4;
        int actual = solution.shortestLadder(level, coinRow, coinColumn);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] level = new String[]{"X"};
        int coinRow = 1;
        int coinColumn = 1;

        int expected = 0;
        int actual = solution.shortestLadder(level, coinRow, coinColumn);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] level = new String[]{"XXXXXXXXXX", "...X......", "XXX.......", "X.....XXXX", "..XXXXX..X", ".........X", ".........X", "XXXXXXXXXX"};
        int coinRow = 1;
        int coinColumn = 1;

        int expected = 2;
        int actual = solution.shortestLadder(level, coinRow, coinColumn);

        Assert.assertEquals(expected, actual);
    }

}
