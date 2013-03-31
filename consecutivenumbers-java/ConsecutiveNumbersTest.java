import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsecutiveNumbersTest {

    protected ConsecutiveNumbers solution;

    @Before
    public void setUp() {
        solution = new ConsecutiveNumbers();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] numbers = new int[]{10, 7, 12, 8, 11};

        int[] expected = new int[]{9};
        int[] actual = solution.missingNumber(numbers);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] numbers = new int[]{3, 6};

        int[] expected = new int[]{};
        int[] actual = solution.missingNumber(numbers);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] numbers = new int[]{5, 6, 7, 8};

        int[] expected = new int[]{4, 9};
        int[] actual = solution.missingNumber(numbers);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] numbers = new int[]{1000000000};

        int[] expected = new int[]{999999999, 1000000001};
        int[] actual = solution.missingNumber(numbers);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] numbers = new int[]{1, 6, 9, 3, 8, 12, 7, 4, 11, 5, 10};

        int[] expected = new int[]{2};
        int[] actual = solution.missingNumber(numbers);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] numbers = new int[]{1};

        int[] expected = new int[]{2};
        int[] actual = solution.missingNumber(numbers);

        Assert.assertArrayEquals(expected, actual);
    }

}
