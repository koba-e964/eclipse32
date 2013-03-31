import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeleportsNetworkTest {

    protected TeleportsNetwork solution;

    @Before
    public void setUp() {
        solution = new TeleportsNetwork();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int teleportCount = 2;
        int[] citiesX = new int[]{0, 1, 1, 1, 2, 2};
        int[] citiesY = new int[]{1, 0, 1, 2, 0, 2};

        int expected = 1;
        int actual = solution.distribute(teleportCount, citiesX, citiesY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int teleportCount = 1;
        int[] citiesX = new int[]{0, 1, 1, 1, 2, 2};
        int[] citiesY = new int[]{1, 0, 1, 2, 0, 2};

        int expected = 2;
        int actual = solution.distribute(teleportCount, citiesX, citiesY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int teleportCount = 0;
        int[] citiesX = new int[]{0, 1, 1, 1, 2, 3, 3, 4};
        int[] citiesY = new int[]{1, 1, 2, 0, 0, 0, 2, 1};

        int expected = 5;
        int actual = solution.distribute(teleportCount, citiesX, citiesY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int teleportCount = 1;
        int[] citiesX = new int[]{0, 1, 2, 3, 4};
        int[] citiesY = new int[]{0, 0, 0, 0, 0};

        int expected = 1;
        int actual = solution.distribute(teleportCount, citiesX, citiesY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int teleportCount = 4;
        int[] citiesX = new int[]{64, 200, 384, 294, 175, 107, 303, 374, 224, 220, 223, 99, 442};
        int[] citiesY = new int[]{79, 161, 83, 281, 344, 217, 184, 336, 431, 262, 75, 474, 257};

        int expected = 1;
        int actual = solution.distribute(teleportCount, citiesX, citiesY);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase12() {
        int teleportCount = 4;
        int[] citiesX = new int[]{246, 66, 385, 14, 110, 318, 437, 316, 107, 38, 146, 239, 385, 328, 436, 188, 15, 9, 68, 34, 102, 8, 94, 175, 260, 377, 350, 413, 440, 428, 454, 339, 320, 358, 140, 204, 318, 287, 303, 233, 181, 114, 194, 249, 307, 400, 431, 448, 79, 151};
        int [] citiesY={16, 53, 42, 92, 86, 104, 94, 193, 169, 212, 216, 233, 247, 319, 317, 299, 259, 318, 330, 372, 368, 443, 440, 435, 359, 364, 410, 410, 220, 385, 375, 378, 399, 391, 467, 455, 48, 54, 24, 119, 57, 233, 193, 276, 255, 88, 75, 75, 427, 161};

        int expected = 4;
        int actual = solution.distribute(teleportCount, citiesX, citiesY);

        Assert.assertEquals(expected, actual);
    }

}
