import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactoVisorsTest {

    protected FactoVisors solution;

    @Before
    public void setUp() {
        solution = new FactoVisors();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] divisors = new int[]{1};
        int[] multiples = new int[]{100};

        int expected = 9;
        int actual = solution.getNum(divisors, multiples);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] divisors = new int[]{6, 9};
        int[] multiples = new int[]{18};

        int expected = 1;
        int actual = solution.getNum(divisors, multiples);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] divisors = new int[]{6, 9};
        int[] multiples = new int[]{96, 180};

        int expected = 0;
        int actual = solution.getNum(divisors, multiples);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] divisors = new int[]{2, 4};
        int[] multiples = new int[]{256};

        int expected = 7;
        int actual = solution.getNum(divisors, multiples);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] divisors = new int[]{1000, 10000, 100000};
        int[] multiples = new int[]{1000000000};

        int expected = 25;
        int actual = solution.getNum(divisors, multiples);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysCase4() {
        int[] divisors = new int[]{1};
        int[] multiples = new int[]{982451653};

        int expected = 2;
        int actual = solution.getNum(divisors, multiples);

        Assert.assertEquals(expected, actual);
    }

}
