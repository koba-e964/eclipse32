import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CollectingPostmarksTest {

    protected CollectingPostmarks solution;

    @Before
    public void setUp() {
        solution = new CollectingPostmarks();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] prices = new int[]{2, 15};
        int[] have = new int[]{};
        int[] values = new int[]{2, 21};
        int K = 13;

        int expected = 15;
        int actual = solution.amountOfMoney(prices, have, values, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] prices = new int[]{9, 18, 7, 6, 18};
        int[] have = new int[]{4, 0};
        int[] values = new int[]{12, 27, 10, 10, 25};
        int K = 67;

        int expected = 22;
        int actual = solution.amountOfMoney(prices, have, values, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] prices = new int[]{14, 14, 12, 6};
        int[] have = new int[]{3, 2, 1};
        int[] values = new int[]{19, 23, 20, 7};
        int K = 10;

        int expected = 0;
        int actual = solution.amountOfMoney(prices, have, values, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] prices = new int[]{43, 33, 14, 31, 42, 37, 17, 42, 40, 20};
        int[] have = new int[]{6};
        int[] values = new int[]{116, 71, 38, 77, 87, 106, 48, 107, 91, 41};
        int K = 811;

        int expected = -1;
        int actual = solution.amountOfMoney(prices, have, values, K);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase111() {
        int[] prices = new int[]{5, 964, 97, 2603, 16633958, 8, 160, 85, 8507, 18192998, 21266, 468, 8, 39024, 82, 938683, 3859544, 11, 851832, 10053116, 1045, 624, 1528, 121084, 1216, 4144, 228, 11519, 357, 76969, 340103, 1463};
        int[] have = new int[]{0, 2, 3, 5, 6};
        int[] values = new int[]{2, 424, 38, 1212, 16544404, 3, 64, 33, 4260, 18317652, 11312, 198, 3, 21656, 32, 675712, 3210487, 4, 607617, 9362803, 462, 268, 690, 73118, 542, 1984, 93, 5882, 149, 44892, 223464, 659};
        int K = 13000000;

        int expected = 14761619;
        int actual = solution.amountOfMoney(prices, have, values, K);

        Assert.assertEquals(expected, actual);
    }

}
