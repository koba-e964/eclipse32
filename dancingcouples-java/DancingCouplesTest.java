import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DancingCouplesTest {

    protected DancingCouples solution;

    @Before
    public void setUp() {
        solution = new DancingCouples();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] canDance = new String[]{"YYYY", "YYYY", "YYYY"};
        int K = 3;

        int expected = 24;
        int actual = solution.countPairs(canDance, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] canDance = new String[]{"YYNN", "NYYN", "NNYY"};
        int K = 3;

        int expected = 4;
        int actual = solution.countPairs(canDance, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] canDance = new String[]{"YY", "YY", "YY"};
        int K = 3;

        int expected = 0;
        int actual = solution.countPairs(canDance, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] canDance = new String[]{"YYNNNN", "NYYNNN", "NNYYNN", "NNNYYN", "NNNNYY", "YNNNNY"};
        int K = 3;

        int expected = 112;
        int actual = solution.countPairs(canDance, K);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        String[] canDance = {"YYYYYYYYYY","YYYYYYYYYY","YYYYYYYYYY","YYYYYYYYYY","YYYYYYYYYY","YYYYYYYYYY","YYYYYYYYYY","YYYYYYYYYY","YYYYYYYYYY","YYYYYYYYYY",};
        int K = 10;

        int expected = 3628800;
        int actual = solution.countPairs(canDance, K);

        Assert.assertEquals(expected, actual);
    }

}
