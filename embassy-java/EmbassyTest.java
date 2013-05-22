import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmbassyTest {

    protected Embassy solution;

    @Before
    public void setUp() {
        solution = new Embassy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] forms = new int[]{4, 4, 4};
        int dayLength = 24;
        int openTime = 8;

        int expected = 12;
        int actual = solution.visaApplication(forms, dayLength, openTime);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] forms = new int[]{4, 4, 4, 4};
        int dayLength = 24;
        int openTime = 8;

        int expected = 28;
        int actual = solution.visaApplication(forms, dayLength, openTime);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] forms = new int[]{2, 2, 2, 2};
        int dayLength = 24;
        int openTime = 1;

        int expected = 73;
        int actual = solution.visaApplication(forms, dayLength, openTime);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] forms = new int[]{25, 500, 630, 2500, 1000, 350, 22, 58, 100, 400, 500, 5000};
        int dayLength = 1440;
        int openTime = 360;

        int expected = 16945;
        int actual = solution.visaApplication(forms, dayLength, openTime);

        Assert.assertEquals(expected, actual);
    }

}
