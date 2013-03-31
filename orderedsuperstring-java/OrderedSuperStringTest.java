import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderedSuperStringTest {

    protected OrderedSuperString solution;

    @Before
    public void setUp() {
        solution = new OrderedSuperString();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] words = new String[]{"abc", "ca"};

        int expected = 4;
        int actual = solution.getLength(words);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] words = new String[]{"a", "a", "b", "a"};

        int expected = 3;
        int actual = solution.getLength(words);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] words = new String[]{"abcdef", "ab", "bc", "de", "ef"};

        int expected = 6;
        int actual = solution.getLength(words);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] words = new String[]{"ab", "bc", "de", "ef", "abcdef"};

        int expected = 12;
        int actual = solution.getLength(words);

        Assert.assertEquals(expected, actual);
    }

}
