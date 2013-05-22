import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringsAndTabsTest {

    protected StringsAndTabs solution;

    @Before
    public void setUp() {
        solution = new StringsAndTabs();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] tab = new String[]{"-----------------", "-------------0-1-", "---------0-2-----", "---0-2-3---------", "-3---------------", "-----------------"};
        int[] stringsA = new int[]{28, 23, 19, 14, 9, 4};
        int[] stringsB = new int[]{9};
        int d = 0;

        String[] expected = new String[]{"-3-5-7-8-A-C-E-F-"};
        String[] actual = solution.transformTab(tab, stringsA, stringsB, d);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] tab = new String[]{"-4457754-20024422-4457754-20024200-"};
        int[] stringsA = new int[]{0};
        int[] stringsB = new int[]{28, 23, 19, 14, 9, 4};
        int d = 12;

        String[] expected = new String[]{"-----------------------------------", "-----------------------------------", "----00---------------00------------", "-223--32-0--02200-223--32-0--020---", "----------33---------------33---33-", "-----------------------------------"};
        String[] actual = solution.transformTab(tab, stringsA, stringsB, d);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] tab = new String[]{"-----------------------------------", "-----------------------------------", "----00---------------00------------", "-223--32-0--02200-223--32-0--020---", "----------33---------------33---33-", "-----------------------------------"};
        int[] stringsA = new int[]{28, 23, 19, 14, 9, 4};
        int[] stringsB = new int[]{33, 28, 24, 31};
        int d = 12;

        String[] expected = new String[]{"-----------------------------------", "-001--10-----00---001--10-----0----", "---------2002--22---------2002-200-", "----00---------------00------------"};
        String[] actual = solution.transformTab(tab, stringsA, stringsB, d);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] tab = new String[]{"-----0------2-2222--0-------0-", "----0------2---222---5-----55-", "---0------2-----22----9---999-", "--0------2-------2-----E-EEEE-", "-0------2---------------------", "0------2----------------------"};
        int[] stringsA = new int[]{28, 23, 19, 14, 9, 4};
        int[] stringsB = new int[]{33, 28, 28};
        int d = 12;

        String[] expected = new String[]{"xxx-27-xx-049-999x--7777-777x-", "xxx----xx-------5x---------Cx-", "xxx3---xx0-----99x--------CCx-"};
        String[] actual = solution.transformTab(tab, stringsA, stringsB, d);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] tab = new String[]{"012345---------", "---------UVWXYZ"};
        int[] stringsA = new int[]{-2, 2};
        int[] stringsB = new int[]{0};
        int d = 0;

        String[] expected = new String[]{"xx0123---WXYZxx"};
        String[] actual = solution.transformTab(tab, stringsA, stringsB, d);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] tab = new String[]{"0220----02--", "75--75----57", "------B9B9B9", "--242424----"};
        int[] stringsA = new int[]{33, 28, 24, 31};
        int[] stringsB = new int[]{33, 28, 28};
        int d = 0;

        String[] expected = new String[]{"222222222222", "------------", "555555555555"};
        String[] actual = solution.transformTab(tab, stringsA, stringsB, d);

        Assert.assertArrayEquals(expected, actual);
    }

}
