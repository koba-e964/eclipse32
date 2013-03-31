import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IdealStringTest {

    protected IdealString solution;

    @Before
    public void setUp() {
        solution = new IdealString();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int length = 1;

        String expected = "A";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int length = 3;

        String expected = "ABB";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int length = 2;

        String expected = "";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int length = 6;

        String expected = "ABCBCC";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int length = 7;

        String expected = "ABBCCCC";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int length = 5;

        String expected = "";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        int length = 12;

        String expected = "ABBCDCCCDDDD";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase1() {
        int length = 15;

        String expected = "ABBCCCCDDDDDDDD";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase2() {
        int length = 16;

        String expected = "ABCDBECCDDDEEEEE";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase3() {
        int length = 30;

        String expected = "ABBCCCCDDDDDDDEDEEEEEEEEEEEEEE";
        String actual = solution.construct(length);

        Assert.assertEquals(expected, actual);
    }

}
