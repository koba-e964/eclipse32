import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemplateMatchingTest {

    protected TemplateMatching solution;

    @Before
    public void setUp() {
        solution = new TemplateMatching();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String text = "something";
        String prefix = "awesome";
        String suffix = "ingenious";

        String expected = "something";
        String actual = solution.bestMatch(text, prefix, suffix);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String text = "havka";
        String prefix = "eto";
        String suffix = "papstvo";

        String expected = "a";
        String actual = solution.bestMatch(text, prefix, suffix);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String text = "abracadabra";
        String prefix = "habrahabr";
        String suffix = "bracket";

        String expected = "abrac";
        String actual = solution.bestMatch(text, prefix, suffix);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String text = "mississippi";
        String prefix = "promise";
        String suffix = "piccolo";

        String expected = "ippi";
        String actual = solution.bestMatch(text, prefix, suffix);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String text = "a a a a a a";
        String prefix = "a a";
        String suffix = "a";

        String expected = "a a";
        String actual = solution.bestMatch(text, prefix, suffix);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String text = "ab";
        String prefix = "b";
        String suffix = "a";

        String expected = "b";
        String actual = solution.bestMatch(text, prefix, suffix);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
    	char[] a50=new char[50];
    	Arrays.fill(a50, 'a');
    	String q=new String(a50);
        String text = q;
        String prefix = q;
        String suffix = q;

        String expected = q;
        String actual = solution.bestMatch(text, prefix, suffix);

        Assert.assertEquals(expected, actual);
    }

}
