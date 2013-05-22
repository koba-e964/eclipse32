import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EllysChessboardTest {

    protected EllysChessboard solution;

    @Before
    public void setUp() {
        solution = new EllysChessboard();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{"........", "........", "...#....", ".#......", ".......#", "........", "........", "........"};

        int expected = 10;
        int actual = solution.minCost(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{"........", "........", "........", "........", "........", "........", "........", "........"};

        int expected = 0;
        int actual = solution.minCost(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{".#......", "........", "..#..#.#", "...#..#.", "........", "...#...#", "...#...#", "........"};

        int expected = 58;
        int actual = solution.minCost(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"##..####", "#####..#", "..#.#...", "#..##.##", ".#.###.#", "####.###", "#.#...#.", "##....#."};

        int expected = 275;
        int actual = solution.minCost(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] board = new String[]{"########", "########", "########", "########", "########", "########", "########", "########"};

        int expected = 476;
        int actual = solution.minCost(board);

        Assert.assertEquals(expected, actual);
    }

}
