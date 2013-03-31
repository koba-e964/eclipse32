import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SentenceDecompositionTest {

    protected SentenceDecomposition solution;

    @Before
    public void setUp() {
        solution = new SentenceDecomposition();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String sentence = "neotowheret";
        String[] validWords = new String[]{"one", "two", "three", "there"};

        int expected = 8;
        int actual = solution.decompose(sentence, validWords);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String sentence = "abba";
        String[] validWords = new String[]{"ab", "ac", "ad"};

        int expected = 2;
        int actual = solution.decompose(sentence, validWords);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String sentence = "thisismeaningless";
        String[] validWords = new String[]{"this", "is", "meaningful"};

        int expected = -1;
        int actual = solution.decompose(sentence, validWords);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String sentence = "ommwreehisymkiml";
        String[] validWords = new String[]{"we", "were", "here", "my", "is", "mom", "here", "si", "milk", "where", "si"};

        int expected = 10;
        int actual = solution.decompose(sentence, validWords);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String sentence = "ogodtsneeencs";
        String[] validWords = new String[]{"go", "good", "do", "sentences", "tense", "scen"};

        int expected = 8;
        int actual = solution.decompose(sentence, validWords);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String sentence = "sepawaterords";
        String[] validWords = new String[]{"separate", "words"};

        int expected = -1;
        int actual = solution.decompose(sentence, validWords);

        Assert.assertEquals(expected, actual);
    }

}
