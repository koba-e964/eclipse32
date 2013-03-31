import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheapestRouteTest {

    protected CheapestRoute solution;

    @Before
    public void setUp() {
        solution = new CheapestRoute();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] cellPrice = new int[]{100};
        int[] enterCell = new int[]{0};
        int[] exitCell = new int[]{0};
        int teleportPrice = 1000;

        int[] expected = new int[]{0, 0};
        int[] actual = solution.routePrice(cellPrice, enterCell, exitCell, teleportPrice);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] cellPrice = new int[]{0, -1, 0, 0};
        int[] enterCell = new int[]{0};
        int[] exitCell = new int[]{2};
        int teleportPrice = 1000;

        int[] expected = new int[]{1000, 2};
        int[] actual = solution.routePrice(cellPrice, enterCell, exitCell, teleportPrice);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] cellPrice = new int[]{1, 2, 3};
        int[] enterCell = new int[]{};
        int[] exitCell = new int[]{};
        int teleportPrice = 100;

        int[] expected = new int[]{5, 2};
        int[] actual = solution.routePrice(cellPrice, enterCell, exitCell, teleportPrice);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] cellPrice = new int[]{1, 0, -1};
        int[] enterCell = new int[]{0};
        int[] exitCell = new int[]{2};
        int teleportPrice = 0;

        int[] expected = new int[]{};
        int[] actual = solution.routePrice(cellPrice, enterCell, exitCell, teleportPrice);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] cellPrice = new int[]{4, 2, 1, 0, 5, 6, 0, 3, 0};
        int[] enterCell = new int[]{4, 4, 3, 7, 5, 4, 2, 5, 8, 4};
        int[] exitCell = new int[]{7, 3, 5, 0, 5, 4, 5, 0, 8, 3};
        int teleportPrice = 8;

        int[] expected = new int[]{14, 6};
        int[] actual = solution.routePrice(cellPrice, enterCell, exitCell, teleportPrice);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void sysTestCase23() {
        int[] cellPrice = new int[]{26, -1, -1, 88, 28, -1, -1, 30, 62};
        int[] enterCell = new int[]{7,7,7};
        int[] exitCell = new int[]{4,6,0};
        int teleportPrice = 48;

        int[] expected = new int[]{};
        int[] actual = solution.routePrice(cellPrice, enterCell, exitCell, teleportPrice);

        Assert.assertArrayEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase128() {
        int[] cellPrice = new int[]{64, 55, 73, 4, 97, 43, 87, 48, 68, 3, 32, 68, 53, 35, 66, 27, -1, 12, 57, 5, 36, 65, 44, 36};

        int[] enterCell = new int[]{12, 11, 23, 3, 18, 7, 0, 16, 11, 13, 15, 1, 4, 10, 21, 4, 7, 20, 10, 0, 1, 7, 0, 13, 5, 16, 3, 23, 1, 16, 4, 23, 16, 11, 18, 19, 16, 1, 18, 15, 12, 21, 8, 11, 20, 4, 23, 6, 3, 1};
        int[] exitCell = new int[]{21, 20, 18, 15, 19, 5, 4, 13, 19, 14, 18, 17, 10, 3, 15, 6, 17, 13, 14, 16, 22, 8, 19, 2, 0, 9, 7, 6, 4, 6, 16, 21, 1, 6, 16, 15, 19, 19, 5, 21, 6, 21, 1, 4, 8, 9, 11, 13, 20, 17};
        int teleportPrice = 0;

        int[] expected = new int[]{50, 7};
        int[] actual = solution.routePrice(cellPrice, enterCell, exitCell, teleportPrice);

        Assert.assertArrayEquals(expected, actual);
    }
    
}
