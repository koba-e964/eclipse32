import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RussianCheckersTest {

    protected RussianCheckers solution;

    @Before
    public void setUp() {
        solution = new RussianCheckers();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{".b.b.b.b", "b.b.b.b.", ".b.b.b.b", "........", "........", "w.w.w.w.", ".w.w.w.w", "w.w.w.w."};
        String turn = "WHITE";

        String[] expected = new String[]{"a3-b4", "c3-b4", "c3-d4", "e3-d4", "e3-f4", "g3-f4", "g3-h4"};
        String[] actual = solution.listMoves(board, turn);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{".......B", "......w.", "........", "........", ".......W", "........", "...W.W..", "........"};
        String turn = "BLACK";

        String[] expected = new String[]{"h8:c3:e1:g3", "h8:d4:g1"};
        String[] actual = solution.listMoves(board, turn);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{"........", "........", "...b....", "........", "...b.b..", "..w.....", ".....w..", "........"};
        String turn = "WHITE";

        String[] expected = new String[]{"c3:e5:c7", "c3:e5:g3"};
        String[] actual = solution.listMoves(board, turn);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"........", "..b.....", ".w......", "......B.", "........", "........", "........", "........"};
        String turn = "WHITE";

        String[] expected = new String[]{"b6:d8:h4"};
        String[] actual = solution.listMoves(board, turn);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] board = new String[]{"........", "......b.", "........", "........", "...W....", "........", ".b......", "........"};
        String turn = "WHITE";

        String[] expected = new String[]{"d4:a1", "d4:h8"};
        String[] actual = solution.listMoves(board, turn);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] board = new String[]{"........", "..w.w...", "........", "....w...", "........", "..B.w...", "........", "........"};
        String turn = "BLACK";

        String[] expected = new String[]{"c3:f6:d8:b6:f2", "c3:f6:d8:b6:g1"};
        String[] actual = solution.listMoves(board, turn);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String[] board = new String[]{".......b", "....w.w.", "........", "....b...", ".w.w.w..", "........", "...w.w..", "........"};
        String turn = "BLACK";

        String[] expected = new String[]{"e5:c3:a5", "e5:c3:e1:g3:d6:a3", "e5:c3:e1:g3:d6:f8:h6", "e5:c3:e1:h4:d8", "e5:g3:e1:c3:a5", "e5:g3:e1:c3:f6:d8", "h8:f6:d8"};
        String[] actual = solution.listMoves(board, turn);

        Assert.assertArrayEquals(expected, actual);
    }

}
