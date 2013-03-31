import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamContestTest {

    protected TeamContest solution;

    @Before
    public void setUp() {
        solution = new TeamContest();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] strength = new int[]{5, 7, 3, 5, 7, 3, 5, 7, 3};

        int expected = 2;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] strength = new int[]{5, 7, 3};

        int expected = 1;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] strength = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int expected = 1;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] strength = new int[]{3, 9, 4, 6, 2, 6, 1, 6, 9, 1, 4, 1, 3, 8, 5};

        int expected = 3;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] strength = new int[]{53, 47, 88, 79, 99, 75, 28, 54, 65, 14, 22, 13, 11, 31, 43};

        int expected = 3;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }

}
