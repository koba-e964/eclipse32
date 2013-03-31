import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SwitchesAndLampsTest {

    protected SwitchesAndLamps solution;

    @Before
    public void setUp() {
        solution = new SwitchesAndLamps();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] switches = new String[]{"NYNN", "NNYN"};
        String[] lamps = new String[]{"NNNY", "NNYN"};

        int expected = 1;
        int actual = solution.theMin(switches, lamps);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] switches = new String[]{"YYN", "YNY", "YYN"};
        String[] lamps = new String[]{"YNY", "NYY", "YNY"};

        int expected = 0;
        int actual = solution.theMin(switches, lamps);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] switches = new String[]{"NYYYNYNNYYYNYNNNNY", "NYYYNYNNYYYNYNNNNY"};
        String[] lamps = new String[]{"YYYNNNYNNYNYNYNYNY", "YYYNNNYNNYNYYNNYNY"};

        int expected = -1;
        int actual = solution.theMin(switches, lamps);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] switches = new String[]{"YYNNN", "NNYYN"};
        String[] lamps = new String[]{"NYNNY", "NNNYY"};

        int expected = -1;
        int actual = solution.theMin(switches, lamps);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] switches = new String[]{"YNNYNNYNYY", "NYNNYNYNYN", "YNYNYYYYYN", "NNYYNYNYNN"};
        String[] lamps = new String[]{"NYYNYNNYNY", "NYYYNNYNNN", "YYYYNYNNYY", "YNNNNYNYYN"};

        int expected = 2;
        int actual = solution.theMin(switches, lamps);

        Assert.assertEquals(expected, actual);
    }

}
