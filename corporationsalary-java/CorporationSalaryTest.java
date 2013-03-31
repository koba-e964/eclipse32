import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CorporationSalaryTest {

    protected CorporationSalary solution;

    @Before
    public void setUp() {
        solution = new CorporationSalary();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] relations = new String[]{"N"};

        long expected = 1L;
        long actual = solution.totalSalary(relations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] relations = new String[]{"NNYN", "NNYN", "NNNN", "NYYN"};

        long expected = 5L;
        long actual = solution.totalSalary(relations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] relations = new String[]{"NNNNNN", "YNYNNY", "YNNNNY", "NNNNNN", "YNYNNN", "YNNYNN"};

        long expected = 17L;
        long actual = solution.totalSalary(relations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] relations = new String[]{"NYNNYN", "NNNNNN", "NNNNNN", "NNYNNN", "NNNNNN", "NNNYYN"};

        long expected = 8L;
        long actual = solution.totalSalary(relations);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] relations = new String[]{"NNNN", "NNNN", "NNNN", "NNNN"};

        long expected = 4L;
        long actual = solution.totalSalary(relations);

        Assert.assertEquals(expected, actual);
    }

}
