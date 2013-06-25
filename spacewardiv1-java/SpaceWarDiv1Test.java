import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceWarDiv1Test {

    protected SpaceWarDiv1 solution;

    @Before
    public void setUp() {
        solution = new SpaceWarDiv1();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] magicalGirlStrength = new int[]{2, 3, 5};
        int[] enemyStrength = new int[]{1, 3, 4};
        long[] enemyCount = new long[]{2L, 9L, 4L};

        long expected = 7L;
        long actual = solution.minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] magicalGirlStrength = new int[]{2, 3, 5};
        int[] enemyStrength = new int[]{1, 1, 2};
        long[] enemyCount = new long[]{2L, 9L, 4L};

        long expected = 5L;
        long actual = solution.minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] magicalGirlStrength = new int[]{14, 6, 22};
        int[] enemyStrength = new int[]{8, 33};
        long[] enemyCount = new long[]{9L, 1L};

        long expected = -1L;
        long actual = solution.minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] magicalGirlStrength = new int[]{869, 249, 599, 144, 929, 748, 665, 37, 313, 99, 33, 437, 308, 137, 665, 834, 955, 958, 613, 417};
        int[] enemyStrength = new int[]{789, 57, 684, 741, 128, 794, 542, 367, 937, 739, 568, 872, 127, 261, 103, 763, 864, 360, 618, 307};
        long[] enemyCount = new long[]{20626770196420L, 45538527263992L, 52807114957507L, 17931716090785L, 65032910980630L, 88711853198687L, 26353250637092L, 61272534748707L, 89294362230771L, 52058590967576L, 60568594469453L, 23772707032338L, 43019142889727L, 39566072849912L, 78870845257173L, 68135668032761L, 36844201017584L, 10133804676521L, 6275847412927L, 37492167783296L};

        long expected = 75030497287405L;
        long actual = solution.minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount);

        Assert.assertEquals(expected, actual);
    }

}
