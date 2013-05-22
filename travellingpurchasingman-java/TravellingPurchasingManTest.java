import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TravellingPurchasingManTest {

    protected TravellingPurchasingMan solution;

    @Before
    public void setUp() {
        solution = new TravellingPurchasingMan();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 3;
        String[] interestingStores = new String[]{"1 10 10", "1 55 31", "10 50 100"};
        String[] roads = new String[]{"1 2 10"};

        int expected = 1;
        int actual = solution.maxStores(N, interestingStores, roads);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 3;
        String[] interestingStores = new String[]{"1 10 10", "1 55 30", "10 50 100"};
        String[] roads = new String[]{"1 2 10"};

        int expected = 2;
        int actual = solution.maxStores(N, interestingStores, roads);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 5;
        String[] interestingStores = new String[]{"0 1000 17"};
        String[] roads = new String[]{"2 3 400", "4 1 500", "4 3 300", "1 0 700", "0 2 400"};

        int expected = 0;
        int actual = solution.maxStores(N, interestingStores, roads);

        Assert.assertEquals(expected, actual);
    }

}
