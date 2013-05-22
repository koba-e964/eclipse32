import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MostCommonLettersTest {

    protected MostCommonLetters solution;

    @Before
    public void setUp() {
        solution = new MostCommonLetters();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] text = new String[]{"abc a"};

        String expected = "a";
        String actual = solution.listMostCommon(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] text = new String[]{"abc", "ab"};

        String expected = "ab";
        String actual = solution.listMostCommon(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] text = new String[]{"qwerty", "abc", "qwe", "a"};

        String expected = "aeqw";
        String actual = solution.listMostCommon(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] text = new String[]{"english is a west germanic language originating", "in england and is the first language for most", "people in the united kingdom the united", "states canada australia new zealand ireland", "and the anglophone caribbean it is used", "extensively as a second language and as an", "official language throughout the world", "especially in commonwealth countries and in", "many international organizations"};

        String expected = "a";
        String actual = solution.listMostCommon(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] text = new String[]{"amanda forsaken bloomer meditated gauging knolls", "betas neurons integrative expender commonalities", "latins antidotes crutched bandwidths begetting", "prompting dog association athenians christian ires", "pompousness percolating figured bagatelles bursted", "ninth boyfriends longingly muddlers prudence puns", "groove deliberators charter collectively yorks", "daringly antithesis inaptness aerosol carolinas", "payoffs chumps chirps gentler inexpressive morales"};

        String expected = "e";
        String actual = solution.listMostCommon(text);

        Assert.assertEquals(expected, actual);
    }

}
