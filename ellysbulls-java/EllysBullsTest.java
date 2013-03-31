import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EllysBullsTest {

    protected EllysBulls solution;

    @Before
    public void setUp() {
        solution = new EllysBulls();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] guesses = new String[]{"1234", "4321", "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999"};
        int[] bulls = new int[]{2, 1, 1, 0, 2, 0, 0, 0, 1, 0, 0};

        String expected = "1337";
        String actual = solution.getNumber(guesses, bulls);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] guesses = new String[]{"0000", "1111", "2222"};
        int[] bulls = new int[]{2, 2, 2};

        String expected = "Liar";
        String actual = solution.getNumber(guesses, bulls);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] guesses = new String[]{"666666", "666677", "777777", "999999"};
        int[] bulls = new int[]{2, 3, 1, 0};

        String expected = "Ambiguity";
        String actual = solution.getNumber(guesses, bulls);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] guesses = new String[]{"000", "987", "654", "321", "100", "010"};
        int[] bulls = new int[]{2, 1, 0, 0, 1, 1};

        String expected = "007";
        String actual = solution.getNumber(guesses, bulls);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] guesses = new String[]{"28", "92", "70", "30", "67", "63", "06", "65", "11", "06", "88", "48", "09", "65", "48", "08"};
        int[] bulls = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        String expected = "54";
        String actual = solution.getNumber(guesses, bulls);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String[] guesses = new String[]{"0294884", "1711527", "2362216", "7666148", "7295642", "4166623", "1166638", "2767693", "8650248", "2486509", "6138934", "4018642", "6236742", "2961643", "8407361", "2097376", "6575410", "6071777", "3569948", "2606380"};
        int[] bulls = new int[]{1, 0, 1, 3, 4, 4, 3, 2, 1, 1, 0, 4, 4, 3, 0, 0, 0, 0, 2, 1};

        String expected = "4266642";
        String actual = solution.getNumber(guesses, bulls);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        String[] guesses = new String[]{"029488401", "171152723", "236221645", "766614867", "729564289", "416662302", "116663834", "276769356", "865024878", "248650991", "613893421", "401864234", "623674243", "296164332", "840736121", "209737659", "657541042", "607177749", "356994834", "260638044"};
        int[] bulls = new int[]{1, 0, 1, 3, 4, 4, 3, 2, 1, 1, 0, 4, 4, 3, 0, 0, 0, 0, 2, 1};

        String expected = "426664210";
        String actual = solution.getNumber(guesses, bulls);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 20000)
    public void sysTestCase0() {
        String[] guesses = new String[]{"00000000", "10000001", "82000000", "07300000", "00640000", "00055000", "00004600", "00000370", "00000028"};
        int bulls[]={0, 1, 1, 1, 1, 1, 1, 1, 1};


        String expected = "Ambiguity";
        String actual = solution.getNumber(guesses, bulls);

        Assert.assertEquals(expected, actual);
    }


}
