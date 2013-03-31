import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FIELDDiagramsTest {

    protected FIELDDiagrams solution;

    @Before
    public void setUp() {
        solution = new FIELDDiagrams();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int fieldOrder = 2;

        long expected = 4L;
        long actual = solution.countDiagrams(fieldOrder);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int fieldOrder = 3;

        long expected = 13L;
        long actual = solution.countDiagrams(fieldOrder);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int fieldOrder = 5;

        long expected = 131L;
        long actual = solution.countDiagrams(fieldOrder);

        Assert.assertEquals(expected, actual);
    }

}
