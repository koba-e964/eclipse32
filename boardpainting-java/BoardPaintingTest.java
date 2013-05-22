import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardPaintingTest {

    protected BoardPainting solution;

    @Before
    public void setUp() {
        solution = new BoardPainting();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] target = new String[]{"#####"};

        int expected = 1;
        int actual = solution.minimalSteps(target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] target = new String[]{"#####", ".....", "#####", ".....", "#####"};

        int expected = 3;
        int actual = solution.minimalSteps(target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] target = new String[]{"..#..", "..#..", "#####", "..#..", "..#.."};

        int expected = 3;
        int actual = solution.minimalSteps(target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] target = new String[]{"#####", "..#..", "#####", "..#..", "#####"};

        int expected = 5;
        int actual = solution.minimalSteps(target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] target = new String[]{".#.#.", "#####", ".#.#.", "#####", ".#.#."};

        int expected = 8;
        int actual = solution.minimalSteps(target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] target = new String[]{".##.####.####.#########.##..", "##.#.####################.##", ".##.###.##.###.###.###.###..", "#..###..#########..###.##.##", "####..#######.#.#####.######", "##.######.#..#.#############", "##.######.###########.######", "#######.#######.#..###.#.###", "#####..#######.#####.#.###.#", "#..#################.#.####.", "##.######..#.#####.######.##", "..#.#############.#.##....#.", "....##..##..#.#####.#.###.##", "##.#########...#..#.#.######", "##.#..###########..#..####.#", "#.####.###.########.########", "#####.#########.##.##.######", ".##.####..###.###...######.#"};

        int expected = 88;
        int actual = solution.minimalSteps(target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String[] target = new String[]{"...................."};

        int expected = 0;
        int actual = solution.minimalSteps(target);

        Assert.assertEquals(expected, actual);
    }

}
