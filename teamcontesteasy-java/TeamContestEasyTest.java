import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamContestEasyTest {

    protected TeamContestEasy solution;

    @Before
    public void setUp() {
        solution = new TeamContestEasy();
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
        int[] strength = new int[]{2, 2, 1, 1, 3, 1, 3, 2, 1, 3, 1, 2, 1, 2, 1};

        int expected = 4;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] strength = new int[]{45, 72, 10, 42, 67, 51, 33, 21, 8, 51, 17, 72};

        int expected = 3;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] strength = new int[]{570466, 958327, 816467, 17, 403, 953808, 734850, 5824, 917784, 921731, 161921, 1734, 823437, 3218, 81, 932681, 2704, 981643, 1232, 475, 873323, 6558, 45660, 1813, 4714, 224, 32301, 28081, 6728, 17055, 561, 15146, 842613, 5559, 1860, 783, 989, 2811, 20664, 112531, 1933, 866794, 805528, 53821, 2465, 137385, 39, 2007};

        int expected = 6;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        int[] strength = new int[]{610297, 849870, 523999, 6557, 976530, 731458, 7404, 795100, 147040, 110947, 159692, 40785, 4949, 2903, 1688, 37278, 620703, 28156, 16823, 1159, 12132, 971379, 5916, 1159, 988589, 12215, 133, 1490, 911360, 920059, 544070, 40249, 514852, 852, 745070, 1105, 715897, 714696, 589133, 698317, 5683, 631612, 16453, 101000, 764881, 101, 2053, 754661};

        int expected = 10;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase0() {
        int[] strength = new int[]{28481, 557292, 14188, 61649, 510253, 509530, 749211, 171570, 441589};
        int expected = 3;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void sysTestCase1()
    {
    	int strength[]={836984, 185902, 411418, 313421, 453125, 619167, 80174, 730748, 542012, 541002, 954939, 515499, 614310, 748665, 527453, 125534, 202111, 720313, 66737, 55158, 713328, 429863, 512743, 823046, 124126, 455251, 508461, 22762, 233183, 364422, 802503, 588324, 425525, 719218, 224401, 523853, 500384, 726198, 714022};
        int expected = 11;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void sysTestCase104()
    {
    	int strength[]={95514, 640, 66891, 48435, 15403, 67558, 58068, 91094, 108418, 52097, 38928, 17416, 103856, 108158, 18566, 71969, 1001, 20527, 32331, 1782, 110568, 76280, 22289, 42930, 29328, 18732, 15808, 44973, 13072, 82641, 896, 54107, 7838, 50079, 93175, 62971, 65823, 39140, 12033, 91731, 95832, 47316};
    	System.out.println(strength.length);
    	int expected = 9;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout=4000)
    public void sysTestCase122()
    {
    	int strength[]={439946, 635764, 10078, 338736, 544496, 1207, 396312, 178664, 722226, 585480, 324888, 132933, 654324, 753741, 625760, 464831, 356873, 614346, 613004, 606560, 193523, 411163, 389598, 499724, 507382, 448061, 735335, 128353, 289111, 421318, 520014, 454073, 604598, 34229, 245056, 40396, 255109, 221540, 18036, 551411, 363812, 484378, 78937, 759303, 315419};
    	System.out.println(strength.length);
    	int expected = 13;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void sysTestCase109()
    {
    	int strength[]={502366, 492565, 238346, 323239, 90257, 719671, 664271, 803487, 173336, 181193, 815981, 105230, 535250, 195075, 715834, 204157, 614184, 745706, 8895, 242872, 789364, 534791, 526584, 273951, 321280, 740559, 350892, 588074, 814844, 446701, 716843, 407858, 135846, 622757, 264694, 629662, 583592, 495795, 711227, 209268, 546465, 19391};
    	System.out.println(strength.length);
    	int expected = 14;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void sysTestCase140()
    {
    	int strength[]={579049, 396916, 886, 243157, 447281, 398941, 476684, 150091, 938804, 456819, 702727, 811614, 675228, 909359, 603354, 157640, 26595, 507191, 284127, 964358, 703007, 868089, 40096, 80427, 86491, 760998, 488369, 379473, 668417, 752862, 108794, 649837, 170708, 980788, 272946, 577214, 204441, 688765, 509702, 132370, 214373, 708827, 580442, 931332, 827969, 680353, 18598, 145638};
    	int expected = 16;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout=2000)
    public void sysTestCase204()
    {
    	int strength[]={208, 217, 124, 315, 373, 422, 360, 510, 157, 153, 472, 322, 120, 147, 524, 538, 444, 144, 76, 291, 324, 298, 446, 243, 487, 7, 217, 202, 56, 83, 420, 397, 261, 445, 192, 289, 513, 42, 38, 316, 430, 292, 305, 183, 31};
    	System.out.println(strength.length);
    	int expected = 15;
        int actual = solution.worstRank(strength);

        Assert.assertEquals(expected, actual);
    }
}
