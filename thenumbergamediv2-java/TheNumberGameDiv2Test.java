import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheNumberGameDiv2Test {

    protected TheNumberGameDiv2 solution;

    @Before
    public void setUp() {
        solution = new TheNumberGameDiv2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int A = 25;
        int B = 5;

        int expected = 2;
        int actual = solution.minimumMoves(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int A = 5162;
        int B = 16;

        int expected = 4;
        int actual = solution.minimumMoves(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int A = 334;
        int B = 12;

        int expected = -1;
        int actual = solution.minimumMoves(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int A = 218181918;
        int B = 9181;

        int expected = 6;
        int actual = solution.minimumMoves(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int A = 9798147;
        int B = 79817;

        int expected = -1;
        int actual = solution.minimumMoves(A, B);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        int A = 979814725;
        int B = 7;

        int expected = 9;
        int actual = solution.minimumMoves(A, B);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase1() {
        int A = 979814725;
        int B = 3;

        int expected = -1;
        int actual = solution.minimumMoves(A, B);

        Assert.assertEquals(expected, actual);
    }

}
