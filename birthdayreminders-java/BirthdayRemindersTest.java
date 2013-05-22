import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BirthdayRemindersTest {

    protected BirthdayReminders solution;

    @Before
    public void setUp() {
        solution = new BirthdayReminders();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] friendNames = new String[]{"John", "Jack", "Bill"};
        int[] birthDates = new int[]{50, 100, 150};
        int currentDate = 500;
        String[] occasions = new String[]{"birthday", "decimal birthday", "binary birthday"};
        int[] days = new int[]{365, 1000, 512};
        int k = 10;

        String[] expected = new String[]{"515. Bill birthday (1)", "562. John binary birthday (1)", "612. Jack binary birthday (1)", "662. Bill binary birthday (1)", "780. John birthday (2)", "830. Jack birthday (2)", "880. Bill birthday (2)", "1050. John decimal birthday (1)", "1074. John binary birthday (2)", "1100. Jack decimal birthday (1)"};
        String[] actual = solution.remind(friendNames, birthDates, currentDate, occasions, days, k);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] friendNames = new String[]{"Zero", "Two", "Three"};
        int[] birthDates = new int[]{0, 2, 3};
        int currentDate = 24;
        String[] occasions = new String[]{"threeday", "twoday"};
        int[] days = new int[]{3, 2};
        int k = 10;

        String[] expected = new String[]{"24. Zero threeday (8)", "24. Three threeday (7)", "24. Zero twoday (12)", "24. Two twoday (11)", "25. Three twoday (11)", "26. Two threeday (8)", "26. Zero twoday (13)", "26. Two twoday (12)", "27. Zero threeday (9)", "27. Three threeday (8)"};
        String[] actual = solution.remind(friendNames, birthDates, currentDate, occasions, days, k);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] friendNames = new String[]{"Jessica Alba", "Angelina Jolie", "Paris Hilton", "Britney Spears"};
        int[] birthDates = new int[]{4135, 1980, 4065, 4353};
        int currentDate = 14091;
        String[] occasions = new String[]{"Venus year", "Earth year", "Mars year", "Jupiter year", "Saturn year"};
        int[] days = new int[]{225, 365, 687, 4332, 10760};
        int k = 20;

        String[] expected = new String[]{"14130. Angelina Jolie Venus year (54)", "14190. Paris Hilton Venus year (45)", "14208. Britney Spears Earth year (27)", "14253. Britney Spears Venus year (44)", "14260. Jessica Alba Venus year (45)", "14285. Paris Hilton Earth year (28)", "14346. Angelina Jolie Mars year (18)", "14355. Angelina Jolie Venus year (55)", "14355. Jessica Alba Earth year (28)", "14370. Paris Hilton Mars year (15)", "14390. Angelina Jolie Earth year (34)", "14415. Paris Hilton Venus year (46)", "14440. Jessica Alba Mars year (15)", "14478. Britney Spears Venus year (45)", "14485. Jessica Alba Venus year (46)", "14573. Britney Spears Earth year (28)", "14580. Angelina Jolie Venus year (56)", "14640. Paris Hilton Venus year (47)", "14650. Paris Hilton Earth year (29)", "14658. Britney Spears Mars year (15)"};
        String[] actual = solution.remind(friendNames, birthDates, currentDate, occasions, days, k);

        Assert.assertArrayEquals(expected, actual);
    }

}
