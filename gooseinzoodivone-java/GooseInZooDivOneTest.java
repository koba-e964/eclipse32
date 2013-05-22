import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GooseInZooDivOneTest {

    protected GooseInZooDivOne solution;

    @Before
    public void setUp() {
        solution = new GooseInZooDivOne();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] field = new String[]{"vvv"};
        int dist = 0;

        int expected = 3;
        int actual = solution.count(field, dist);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] field = new String[]{"."};
        int dist = 100;

        int expected = 0;
        int actual = solution.count(field, dist);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] field = new String[]{"vvv"};
        int dist = 1;

        int expected = 0;
        int actual = solution.count(field, dist);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] field = new String[]{"v.v..................v............................", ".v......v..................v.....................v", "..v.....v....v.........v...............v......v...", ".........vvv...vv.v.........v.v..................v", ".....v..........v......v..v...v.......v...........", "...................vv...............v.v..v.v..v...", ".v.vv.................v..............v............", "..vv.......v...vv.v............vv.....v.....v.....", "....v..........v....v........v.......v.v.v........", ".v.......v.............v.v..........vv......v.....", "....v.v.......v........v.....v.................v..", "....v..v..v.v..............v.v.v....v..........v..", "..........v...v...................v..............v", "..v........v..........................v....v..v...", "....................v..v.........vv........v......", "..v......v...............................v.v......", "..v.v..............v........v...............vv.vv.", "...vv......v...............v.v..............v.....", "............................v..v.................v", ".v.............v.......v..........................", "......v...v........................v..............", ".........v.....v..............vv..................", "................v..v..v.........v....v.......v....", "........v.....v.............v......v.v............", "...........v....................v.v....v.v.v...v..", "...........v......................v...v...........", "..........vv...........v.v.....................v..", ".....................v......v............v...v....", ".....vv..........................vv.v.....v.v.....", ".vv.......v...............v.......v..v.....v......", "............v................v..........v....v....", "................vv...v............................", "................v...........v........v...v....v...", "..v...v...v.............v...v........v....v..v....", "......v..v.......v........v..v....vv..............", "...........v..........v........v.v................", "v.v......v................v....................v..", ".v........v................................v......", "............................v...v.......v.........", "........................vv.v..............v...vv..", ".......................vv........v.............v..", "...v.............v.........................v......", "....v......vv...........................v.........", "....vv....v................v...vv..............v..", "..................................................", "vv........v...v..v.....v..v..................v....", ".........v..............v.vv.v.............v......", ".......v.....v......v...............v.............", "..v..................v................v....v......", ".....v.....v.....................v.v......v......."};
        int dist = 3;

        int expected = 898961330;
        int actual = solution.count(field, dist);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase6() {
        String[] field = {".v...", "v.v.v", ".....", "....."};
        int dist=2;

        int expected = 1;
        int actual = solution.count(field, dist);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase73() {
        String[] field = {"vv"};
        int dist=100;

        int expected = 1;
        int actual = solution.count(field, dist);

        Assert.assertEquals(expected, actual);
    }

}
