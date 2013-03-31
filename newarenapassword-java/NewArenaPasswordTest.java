import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewArenaPasswordTest {

    protected NewArenaPassword solution;

    @Before
    public void setUp() {
        solution = new NewArenaPassword();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String oldPassword = "topcoderopen";
        int K = 5;

        int expected = 3;
        int actual = solution.minChange(oldPassword, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String oldPassword = "puyopuyo";
        int K = 4;

        int expected = 0;
        int actual = solution.minChange(oldPassword, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String oldPassword = "loool";
        int K = 3;

        int expected = 1;
        int actual = solution.minChange(oldPassword, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String oldPassword = "arena";
        int K = 5;

        int expected = 0;
        int actual = solution.minChange(oldPassword, K);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String oldPassword = "amavckdkz";
        int K = 7;

        int expected = 5;
        int actual = solution.minChange(oldPassword, K);

        Assert.assertEquals(expected, actual);
    }

}
