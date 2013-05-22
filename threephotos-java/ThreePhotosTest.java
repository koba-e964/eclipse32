import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThreePhotosTest {

    protected ThreePhotos solution;

    @Before
    public void setUp() {
        solution = new ThreePhotos();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] A = new String[]{"YY", "YY"};
        String[] B = new String[]{"YY", "YY"};
        String[] C = new String[]{"YY", "YY"};

        int expected = 0;
        int actual = solution.removeCubes(A, B, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] A = new String[]{"NNN", "NNN", "NNN"};
        String[] B = new String[]{"NNN", "NNN", "NNN"};
        String[] C = new String[]{"NNN", "NNN", "NNN"};

        int expected = 27;
        int actual = solution.removeCubes(A, B, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] A = new String[]{"NNNNN", "NNNNN", "NNNNN", "YYNNN", "NNNNN"};
        String[] B = new String[]{"NNNNN", "NNNNN", "NNNNN", "NNYNY", "NNNNN"};
        String[] C = new String[]{"NNYNN", "NNNNY", "NNNNN", "NNNNN", "NNNNN"};

        int expected = 123;
        int actual = solution.removeCubes(A, B, C);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] A = new String[]{"YY", "YY"};
        String[] B = new String[]{"YY", "YY"};
        String[] C = new String[]{"YN", "YN"};

        int expected = -1;
        int actual = solution.removeCubes(A, B, C);

        Assert.assertEquals(expected, actual);
    }

}
