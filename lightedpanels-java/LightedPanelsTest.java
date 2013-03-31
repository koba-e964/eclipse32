import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LightedPanelsTest {

    protected LightedPanels solution;

    @Before
    public void setUp() {
        solution = new LightedPanels();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{"*****", "*...*", "*...*", "*...*", "*****"};

        int expected = 1;
        int actual = solution.minTouch(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{".*"};

        int expected = -1;
        int actual = solution.minTouch(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{"**.", "**.", "..."};

        int expected = 2;
        int actual = solution.minTouch(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"*...", "**..", "..**", "...*"};

        int expected = 10;
        int actual = solution.minTouch(board);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        String[] board = new String[]{"*.."};

        int expected = 1;
        int actual = solution.minTouch(board);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void sysTestCase0()
    {
    	String[] board={"*******", "*.....*", "*.....*", "*.....*", "*.....*", "*.....*", "*******"};

    	int expected=
    	49;

    	int received=
    	solution.minTouch(board);
    	Assert.assertEquals(expected, received);
    }
    @Test(timeout=2000)
    public void sysTestCase1()
    {
    	String[] board={"......*", ".*.....", ".......", ".......", "..**...", "......*", "*.....*"};

    int expected=
    32;
    int actual=solution.minTouch(board);

    Assert.assertEquals(expected, actual);

    }
    @Test(timeout=2000)
    public void sysTestCase2()
    {
    	String[] board={"***.."};

    	int expected=1;
        int actual = solution.minTouch(board);

        Assert.assertEquals(expected, actual);

    }
    @Test(timeout=2000)
    public void sysTestCase3()
    {
    	String[] board=
    	{".**.**..", "*****...", "..*.***.", "..****..", ".**...*.", "*...**..", ".**.*...", "*.*...*."};


    	int expected=24;
        int actual = solution.minTouch(board);

        Assert.assertEquals(expected, actual);

    }
}
