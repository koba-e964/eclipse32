import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CityMapTest {

    protected CityMap solution;

    @Before
    public void setUp() {
        solution = new CityMap();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] cityMap = new String[]{"M....M", "...R.M", "R..R.R"};
        int[] POIs = new int[]{3, 4};

        String expected = "MR";
        String actual = solution.getLegend(cityMap, POIs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] cityMap = new String[]{"XXXXXXXZXYYY"};
        int[] POIs = new int[]{1, 8, 3};

        String expected = "ZXY";
        String actual = solution.getLegend(cityMap, POIs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] cityMap = new String[]{"...........", "...........", "...........", "..........T"};
        int[] POIs = new int[]{1};

        String expected = "T";
        String actual = solution.getLegend(cityMap, POIs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] cityMap = new String[]{"AIAAARRI.......GOAI.", ".O..AIIGI.OAAAGI.A.I", ".A.IAAAARI..AI.AAGR.", "....IAI..AOIGA.GAIA.", "I.AIIIAG...GAR.IIAGA", "IA.AOA....I....I.GAA", "IOIGRAAAO.AI.AA.RAAA", "AI.AAA.AIR.AGRIAAG..", "AAAAIAAAI...AAG.RGRA", ".J.IA...G.A.AA.II.AA"};
        int[] POIs = new int[]{16, 7, 1, 35, 11, 66};

        String expected = "GOJIRA";
        String actual = solution.getLegend(cityMap, POIs);

        Assert.assertEquals(expected, actual);
    }

}
