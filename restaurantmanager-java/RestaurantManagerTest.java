import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaurantManagerTest {

    protected RestaurantManager solution;

    @Before
    public void setUp() {
        solution = new RestaurantManager();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] tables = new int[]{4};
        int[] groupSizes = new int[]{4, 8, 4, 2, 2, 4};
        int[] arrivals = new int[]{0, 10, 12, 16, 18, 26};
        int[] departures = new int[]{10, 20, 18, 26, 36, 28};

        int expected = 14;
        int actual = solution.allocateTables(tables, groupSizes, arrivals, departures);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] tables = new int[]{4, 4};
        int[] groupSizes = new int[]{4, 8, 4, 2, 2, 4};
        int[] arrivals = new int[]{0, 10, 12, 16, 18, 26};
        int[] departures = new int[]{10, 20, 18, 26, 36, 28};

        int expected = 8;
        int actual = solution.allocateTables(tables, groupSizes, arrivals, departures);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] tables = new int[]{4, 8};
        int[] groupSizes = new int[]{4, 8, 4, 2, 2, 4};
        int[] arrivals = new int[]{0, 10, 12, 16, 18, 26};
        int[] departures = new int[]{10, 20, 18, 26, 36, 28};

        int expected = 2;
        int actual = solution.allocateTables(tables, groupSizes, arrivals, departures);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] tables = new int[]{10, 8, 11, 16};
        int[] groupSizes = new int[]{14, 1, 15, 1, 19, 15, 9, 15, 20, 2};
        int[] arrivals = new int[]{4, 5, 7, 18, 21, 25, 29, 31, 46, 49};
        int[] departures = new int[]{8, 37, 11, 36, 36, 46, 40, 42, 47, 50};

        int expected = 69;
        int actual = solution.allocateTables(tables, groupSizes, arrivals, departures);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] tables = new int[]{18, 15, 2, 6};
        int[] groupSizes = new int[]{7, 9, 16, 3, 10, 3, 2, 10, 16, 16};
        int[] arrivals = new int[]{10, 15, 19, 20, 21, 22, 27, 35, 37, 43};
        int[] departures = new int[]{13, 24, 22, 32, 32, 32, 35, 48, 41, 44};

        int expected = 10;
        int actual = solution.allocateTables(tables, groupSizes, arrivals, departures);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] tables = new int[]{13, 9, 6, 1, 9, 8, 6, 2, 8, 20};
        int[] groupSizes = new int[]{20, 10, 11, 10, 1, 5, 16, 2, 9, 17};
        int[] arrivals = new int[]{12, 14, 64, 78, 100, 121, 151, 155, 162, 164};
        int[] departures = new int[]{19, 26, 159, 96, 155, 134, 169, 199, 169, 174};

        int expected = 17;
        int actual = solution.allocateTables(tables, groupSizes, arrivals, departures);

        Assert.assertEquals(expected, actual);
    }

}
