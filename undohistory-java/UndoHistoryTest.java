import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UndoHistoryTest {

    protected UndoHistory solution;

    @Before
    public void setUp() {
        solution = new UndoHistory();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] lines = new String[]{"tomorrow", "topcoder"};

        int expected = 18;
        int actual = solution.minPresses(lines);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] lines = new String[]{"a", "b"};

        int expected = 6;
        int actual = solution.minPresses(lines);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] lines = new String[]{"a", "ab", "abac", "abacus"};

        int expected = 10;
        int actual = solution.minPresses(lines);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] lines = new String[]{"pyramid", "sphinx", "sphere", "python", "serpent"};

        int expected = 39;
        int actual = solution.minPresses(lines);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] lines = new String[]{"ba", "a", "a", "b", "ba"};

        int expected = 13;
        int actual = solution.minPresses(lines);

        Assert.assertEquals(expected, actual);
    }

}
