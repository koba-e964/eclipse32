import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClosestRegexTest {

    protected ClosestRegex solution;

    @Before
    public void setUp() {
        solution = new ClosestRegex();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String text = "abcd";
        String regex = "bcdd";

        String expected = "bcdd";
        String actual = solution.closestString(text, regex);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String text = "topcoder";
        String regex = "t*px*coa*de*";

        String expected = "ttpcodee";
        String actual = solution.closestString(text, regex);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String text = "cmu";
        String regex = "c*m*fm*u*";

        String expected = "cfu";
        String actual = solution.closestString(text, regex);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String text = "aaaaacccc";
        String regex = "a*abc*";

        String expected = "aaaaabccc";
        String actual = solution.closestString(text, regex);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String text = "short";
        String regex = "lo*ts*of*let*ter*s";

        String expected = "";
        String actual = solution.closestString(text, regex);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase15() {
        String text = "ababababababababababababababababababababababababab";
        
        String regex = "a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*";

        String expected = "aaaaaaaaaaaaaaaaaaaaaaaaaaabababababababababababab";
        String actual = solution.closestString(text, regex);

        Assert.assertEquals(expected, actual);
    }

}
