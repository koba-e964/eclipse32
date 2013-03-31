import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TunnelsTest {

    protected Tunnels solution;

    @Before
    public void setUp() {
        solution = new Tunnels();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] frame = new String[]{"XXX.XXXX.....X", "..X....XXX...X", "XXX......X...."};

        int expected = 3;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] frame = new String[]{".......X.....", ".............", "XXX.XXXXXXXXX"};

        int expected = 3;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] frame = new String[]{".............", "XXXXXXXXXXXXX", ".............", "XXX.......XXX", "..........X..", "..........XXX"};

        int expected = 2;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] frame = new String[]{"XXXX...X..", "....XXXX.X", "XX.......X", "..........", "....XXXXXX"};

        int expected = 4;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] frame = new String[]{"X........X..", ".........XXX", "............", "XXXXXXXXXXXX", "............", "XXXXXXXXXXXX", "............", ".........XXX", "..XXXXXXXX.."};

        int expected = 2;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] frame = new String[]{"...............X.X....X", "XXXXX..........X.......", "....X..................", "XXX.X.........XXXXXXXXX", "..X.X.........X........", "XXX.X.........XXXXXXXXX", "....X..................", "XXXXX......XXXXXXXXXXXX"};

        int expected = 5;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String[] frame = new String[]{".", "X", "X", ".", "X"};

        int expected = 1;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase7() {
        String[] frame = new String[]{"X.XX", "X...", "...X", "X...", "X..X"};

        int expected = 3;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase8() {
        String[] frame = new String[]{"...", "..."};

        int expected = 0;
        int actual = solution.minimumTunnels(frame);

        Assert.assertEquals(expected, actual);
    }

}
