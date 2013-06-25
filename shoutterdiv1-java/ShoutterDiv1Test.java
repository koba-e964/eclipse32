import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoutterDiv1Test {

    protected ShoutterDiv1 solution;

    @Before
    public void setUp() {
        solution = new ShoutterDiv1();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] s1000 = new String[]{"22", "2"};
        String[] s100 = new String[]{"00", "0"};
        String[] s10 = new String[]{"11", "1"};
        String[] s1 = new String[]{"21", "4"};
        String[] t1000 = new String[]{"22", "2"};
        String[] t100 = new String[]{"00", "0"};
        String[] t10 = new String[]{"11", "1"};
        String[] t1 = new String[]{"43", "6"};

        int expected = 2;
        int actual = solution.count(s1000, s100, s10, s1, t1000, t100, t10, t1);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] s1000 = new String[]{"00"};
        String[] s100 = new String[]{"00"};
        String[] s10 = new String[]{"00"};
        String[] s1 = new String[]{"13"};
        String[] t1000 = new String[]{"00"};
        String[] t100 = new String[]{"00"};
        String[] t10 = new String[]{"00"};
        String[] t1 = new String[]{"24"};

        int expected = -1;
        int actual = solution.count(s1000, s100, s10, s1, t1000, t100, t10, t1);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] s1000 = new String[]{"0000"};
        String[] s100 = new String[]{"0000"};
        String[] s10 = new String[]{"0000"};
        String[] s1 = new String[]{"1234"};
        String[] t1000 = new String[]{"0000"};
        String[] t100 = new String[]{"0000"};
        String[] t10 = new String[]{"0000"};
        String[] t1 = new String[]{"2345"};

        int expected = 6;
        int actual = solution.count(s1000, s100, s10, s1, t1000, t100, t10, t1);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] s1000 = new String[]{"0000000000"};
        String[] s100 = new String[]{"0000000000"};
        String[] s10 = new String[]{"0000000000"};
        String[] s1 = new String[]{"7626463146"};
        String[] t1000 = new String[]{"0000000000"};
        String[] t100 = new String[]{"0000000000"};
        String[] t10 = new String[]{"0000000000"};
        String[] t1 = new String[]{"9927686479"};

        int expected = 18;
        int actual = solution.count(s1000, s100, s10, s1, t1000, t100, t10, t1);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] s1000 = new String[]{"00000000000000000000000000000000000000000000000000"};
        String[] s100 = new String[]{"00000000000000000000000000000000000000000000000000"};
        String[] s10 = new String[]{"50353624751857130208544645495168271486083954769538"};
        String[] s1 = new String[]{"85748487990028258641117783760944852941545064635928"};
        String[] t1000 = new String[]{"00000000000000000000000000000000000000000000000000"};
        String[] t100 = new String[]{"00000000000000000000000000000000000000000000000000"};
        String[] t10 = new String[]{"61465744851859252308555855596388482696094965779649"};
        String[] t1 = new String[]{"37620749792666153778227385275518278477865684777411"};

        int expected = 333;
        int actual = solution.count(s1000, s100, s10, s1, t1000, t100, t10, t1);

        Assert.assertEquals(expected, actual);
    }

}
