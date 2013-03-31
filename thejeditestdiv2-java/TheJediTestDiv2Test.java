import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheJediTestDiv2Test {

    protected TheJediTestDiv2 solution;

    @Before
    public void setUp() {
        solution = new TheJediTestDiv2();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] students = new int[]{10, 15};
        int Y = 12;
        int J = 5;

        int expected = 3;
        int actual = solution.countSupervisors(students, Y, J);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] students = new int[]{11, 13, 15};
        int Y = 9;
        int J = 5;

        int expected = 7;
        int actual = solution.countSupervisors(students, Y, J);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] students = new int[]{10};
        int Y = 100;
        int J = 2;

        int expected = 0;
        int actual = solution.countSupervisors(students, Y, J);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] students = new int[]{0, 0, 0, 0, 0};
        int Y = 145;
        int J = 21;

        int expected = 0;
        int actual = solution.countSupervisors(students, Y, J);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] students = new int[]{4, 7, 10, 5, 6, 55, 2};
        int Y = 20;
        int J = 3;

        int expected = 26;
        int actual = solution.countSupervisors(students, Y, J);

        Assert.assertEquals(expected, actual);
    }

}
