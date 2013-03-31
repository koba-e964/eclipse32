import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChildlessNumbersTest {

    protected ChildlessNumbers solution;

    @Before
    public void setUp() {
        solution = new ChildlessNumbers();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int A = 4;
        int B = 7;

        int expected = 0;
        int actual = solution.howMany(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int A = 37;
        int B = 37;

        int expected = 0;
        int actual = solution.howMany(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int A = 61;
        int B = 65;

        int expected = 3;
        int actual = solution.howMany(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int A = 275;
        int B = 300;

        int expected = 1;
        int actual = solution.howMany(A, B);

        Assert.assertEquals(expected, actual);
    }

}
