import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheExperimentTest {

    protected TheExperiment solution;

    @Before
    public void setUp() {
        solution = new TheExperiment();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] intensity = new String[]{"341156"};
        int M = 3;
        int L = 3;
        int A = 6;
        int B = 10;

        int expected = 2;
        int actual = solution.countPlacements(intensity, M, L, A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] intensity = new String[]{"999112999"};
        int M = 2;
        int L = 4;
        int A = 21;
        int B = 30;

        int expected = 2;
        int actual = solution.countPlacements(intensity, M, L, A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] intensity = new String[]{"111"};
        int M = 2;
        int L = 2;
        int A = 2;
        int B = 3;

        int expected = 0;
        int actual = solution.countPlacements(intensity, M, L, A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] intensity = new String[]{"59059", "110", "1132230231"};
        int M = 1;
        int L = 5;
        int A = 10;
        int B = 20;

        int expected = 6;
        int actual = solution.countPlacements(intensity, M, L, A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] intensity = new String[]{"111111111111111111111111", "111111111111111111111111111", "11111111111111111111111"};
        int M = 12;
        int L = 8;
        int A = 4;
        int B = 2700;

        int expected = 418629948;
        int actual = solution.countPlacements(intensity, M, L, A, B);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        String[] intensity = new String[]{"111111111111111111111111"};
        int M = 2;
        int L = 8;
        int A = 6;
        int B = 2700;

        int expected = 45+10+10+22;
        int actual = solution.countPlacements(intensity, M, L, A, B);

        Assert.assertEquals(expected, actual);
    }

}
