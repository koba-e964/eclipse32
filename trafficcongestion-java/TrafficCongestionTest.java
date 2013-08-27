import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrafficCongestionTest {

    protected TrafficCongestion solution;

    @Before
    public void setUp() {
        solution = new TrafficCongestion();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int treeHeight = 1;

        int expected = 1;
        int actual = solution.theMinCars(treeHeight);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int treeHeight = 2;

        int expected = 3;
        int actual = solution.theMinCars(treeHeight);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int treeHeight = 3;

        int expected = 5;
        int actual = solution.theMinCars(treeHeight);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int treeHeight = 585858;

        int expected = 548973404;
        int actual = solution.theMinCars(treeHeight);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void testCase4() {
        int treeHeight = 1000000;

        int expected = 548973404;
        int actual = solution.theMinCars(treeHeight);

        //Assert.assertEquals(expected, actual);
    }

}
