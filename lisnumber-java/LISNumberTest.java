import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LISNumberTest {

    protected LISNumber solution;

    @Before
    public void setUp() {
        solution = new LISNumber();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] cardsnum = new int[]{1, 1, 1};
        int K = 2;

        int expected = 4;
        int actual = solution.count(cardsnum, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] cardsnum = new int[]{2};
        int K = 1;

        int expected = 0;
        int actual = solution.count(cardsnum, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] cardsnum = new int[]{36, 36, 36, 36, 36};
        int K = 36;

        int expected = 1;
        int actual = solution.count(cardsnum, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] cardsnum = new int[]{3, 2, 11, 5, 7};
        int K = 20;

        int expected = 474640725;
        int actual = solution.count(cardsnum, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] cardsnum = new int[]{31, 4, 15, 9, 26, 5, 35, 8, 9, 7, 9, 32, 3, 8, 4, 6, 26};
        int K = 58;

        int expected = 12133719;
        int actual = solution.count(cardsnum, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] cardsnum = new int[]{27, 18, 28, 18, 28, 4, 5, 9, 4, 5, 23, 5, 36, 28, 7, 4, 7, 13, 5, 26, 6, 24, 9, 7, 7, 5, 7, 24, 7, 9, 36, 9, 9, 9, 5, 9};
        int K = 116;

        int expected = 516440918;
        int actual = solution.count(cardsnum, K);

        Assert.assertEquals(expected, actual);
    }

}
