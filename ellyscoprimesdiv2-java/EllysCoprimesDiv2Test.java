import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EllysCoprimesDiv2Test {

    protected EllysCoprimesDiv2 solution;

    @Before
    public void setUp() {
        solution = new EllysCoprimesDiv2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] numbers = new int[]{2200, 42, 2184, 17};

        int expected = 3;
        int actual = solution.getCount(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] numbers = new int[]{13, 1, 6, 20, 33};

        int expected = 0;
        int actual = solution.getCount(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] numbers = new int[]{7, 42};

        int expected = 1;
        int actual = solution.getCount(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] numbers = new int[]{55780, 44918, 55653, 4762, 41536, 40083, 79260, 7374, 24124, 91858, 7856, 12999, 64025, 12706, 19770, 71495, 32817, 79309, 53779, 8421, 97984, 34586, 893, 64549, 77792, 12143, 52732, 94416, 54207, 51811, 80845, 67079, 14829, 25350, 22976, 23932, 62273, 58871, 82358, 13283, 33667, 64263, 1337, 42666};

        int expected = 15;
        int actual = solution.getCount(numbers);

        Assert.assertEquals(expected, actual);
    }

}
