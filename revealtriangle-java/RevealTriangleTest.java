import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RevealTriangleTest {

    protected RevealTriangle solution;

    @Before
    public void setUp() {
        solution = new RevealTriangle();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] questionMarkTriangle = new String[]{"4??", "?2", "1"};

        String[] expected = new String[]{"457", "92", "1"};
        String[] actual = solution.calcTriangle(questionMarkTriangle);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] questionMarkTriangle = new String[]{"1"};

        String[] expected = new String[]{"1"};
        String[] actual = solution.calcTriangle(questionMarkTriangle);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] questionMarkTriangle = new String[]{"???2", "??2", "?2", "2"};

        String[] expected = new String[]{"0002", "002", "02", "2"};
        String[] actual = solution.calcTriangle(questionMarkTriangle);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] questionMarkTriangle = new String[]{"??5?", "??9", "?4", "6"};

        String[] expected = new String[]{"7054", "759", "24", "6"};
        String[] actual = solution.calcTriangle(questionMarkTriangle);

        Assert.assertArrayEquals(expected, actual);
    }

}
