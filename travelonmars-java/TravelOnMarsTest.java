import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TravelOnMarsTest {

    protected TravelOnMars solution;

    @Before
    public void setUp() {
        solution = new TravelOnMars();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] range = new int[]{2, 1, 1, 1, 1, 1};
        int startCity = 1;
        int endCity = 4;

        int expected = 2;
        int actual = solution.minTimes(range, startCity, endCity);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] range = new int[]{2, 1, 1, 1, 1, 1};
        int startCity = 4;
        int endCity = 1;

        int expected = 3;
        int actual = solution.minTimes(range, startCity, endCity);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] range = new int[]{2, 1, 1, 2, 1, 2, 1, 1};
        int startCity = 2;
        int endCity = 6;

        int expected = 3;
        int actual = solution.minTimes(range, startCity, endCity);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] range = new int[]{3, 2, 1, 1, 3, 1, 2, 2, 1, 1, 2, 2, 2, 2, 3};
        int startCity = 6;
        int endCity = 13;

        int expected = 4;
        int actual = solution.minTimes(range, startCity, endCity);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void myTestCase0(){
    	int range[]=new int[50];
    	Arrays.fill(range, 1);
    	int expected=25;
    	int actual=solution.minTimes(range, 0, 25);
    	Assert.assertEquals(expected, actual);
    }
}
