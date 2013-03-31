import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordAbbreviationTest {

    protected WordAbbreviation solution;

    @Before
    public void setUp() {
        solution = new WordAbbreviation();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] words = new String[]{"abc", "def", "ghi"};

        String[] expected = new String[]{"a", "d", "g"};
        String[] actual = solution.getAbbreviations(words);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] words = new String[]{"aaab", "aaac", "aaad"};

        String[] expected = new String[]{"aaab", "aaac", "aaad"};
        String[] actual = solution.getAbbreviations(words);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] words = new String[]{"top", "coder", "contest"};

        String[] expected = new String[]{"t", "cod", "con"};
        String[] actual = solution.getAbbreviations(words);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] words = new String[]{"bababaaaaa", "baaabaababa", "bbabaaabbaaabbabaabaabbbbbaabb", "aaababababbbbababbbaabaaaaaaaabbabbbaaab", "baaaaabaababbbaabbbabbababbbabbbbbbbbab"};

        String[] expected = new String[]{"bab", "baaab", "bb", "a", "baaaa"};
        String[] actual = solution.getAbbreviations(words);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] words = new String[]{"oneword"};

        String[] expected = new String[]{"o"};
        String[] actual = solution.getAbbreviations(words);

        Assert.assertArrayEquals(expected, actual);
    }

}
