import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DistinctRemaindersTest {

    protected DistinctRemainders solution;

    @Before
    public void setUp() {
        solution = new DistinctRemainders();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        long N = 3L;
        int M = 2;

        int expected = 5;
        int actual = solution.howMany(N, M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        long N = 3L;
        int M = 3;

        int expected = 9;
        int actual = solution.howMany(N, M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        long N = 58L;
        int M = 1;

        int expected = 1;
        int actual = solution.howMany(N, M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        long N = 572L;
        int M = 7;

        int expected = 922572833;
        int actual = solution.howMany(N, M);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        long N = 1000000000000000000L;
        int M = 20;

        int expected = 240297629;
        int actual = solution.howMany(N, M);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void mytestCase0() {
        long N =173767058179049L;
        int M=4;

        int expected = 
        		487236212;
        int actual = solution.howMany(N, M);

        //Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void systestCase0() {
        long N =173767058179049L;
        int M=35;

        int expected = 
        		487236212;
        int actual = solution.howMany(N, M);

        Assert.assertEquals(expected, actual);
    }
}
