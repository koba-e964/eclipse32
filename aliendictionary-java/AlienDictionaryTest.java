import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlienDictionaryTest {

    protected AlienDictionary solution;

    @Before
    public void setUp() {
        solution = new AlienDictionary();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int wordLength = 5;
        String[] forbiddenSubstrings = new String[]{"?AA", "ABB"};
        int[] wordNumbers = new int[]{4, 12, 0, 6, 9};

        String[] expected = new String[]{"BBBAB", "NO PAGE", "AABAB", "BBBBB", "NO PAGE"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int wordLength = 3;
        String[] forbiddenSubstrings = new String[]{};
        int[] wordNumbers = new int[]{1, 4, 7, 5, 1};

        String[] expected = new String[]{"AAB", "BAA", "BBB", "BAB", "AAB"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int wordLength = 4;
        String[] forbiddenSubstrings = new String[]{"AA"};
        int[] wordNumbers = new int[]{2, 6, 11, 4, 8};

        String[] expected = new String[]{"ABBB", "BBBA", "NO PAGE", "BABB", "NO PAGE"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int wordLength = 10;
        String[] forbiddenSubstrings = new String[]{"BABB?", "??A?B", "A?AAA", "A??AB", "?A??A"};
        int[] wordNumbers = new int[]{0, 1};

        String[] expected = new String[]{"AABBBABABA", "AABBBBABAB"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        Assert.assertArrayEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase0() {
        int wordLength = 50;
        String[] forbiddenSubstrings = new String[]{"BABB?AB?A?B?A????"};
        int[] wordNumbers = new int[]{0, 1};

        String[] expected = new String[]{"AABBBABABA", "AABBBBABAB"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        //Assert.assertArrayEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void myTestCase1() {
        int wordLength = 50;
        String[] forbiddenSubstrings = new String[]{"ABABABABABABAB"};
        int[] wordNumbers = new int[]{0, 1};

        String[] expected = new String[]{"AABBBABABA", "AABBBBABAB"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        //Assert.assertArrayEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase23() {
        int wordLength = 6;
        String[] forbiddenSubstrings = {"?????B??A?BA", "??B?????????", "??????B????B", "B???????????", "????????????", "???B????????", "?????????B??"};
        int[] wordNumbers = {493, 329, 676, 865, 829, 849, 107, 325, 549, 74, 509, 133, 811, 937, 839, 739, 57, 531, 93, 284};

        String[] expected = {"NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "BBBAAB", "NO PAGE", "NO PAGE", "NO PAGE"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        Assert.assertArrayEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase25() {
        int wordLength = 4;
        String[] forbiddenSubstrings ={"?BB???", "BBB?A?", "B???AB", "?B??A?", "B?A??B", "AA???B", "??B?BB"};
        int[] wordNumbers = {793, 501, 545, 294, 159, 208, 724, 641, 521, 934, 378, 218, 510, 443, 561, 352, 108, 174, 636, 152};

        String[] expected = {"NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE", "NO PAGE"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        Assert.assertArrayEquals(expected, actual);
    } 
    @Test(timeout = 2000)
    public void sysTestCase54() {
        int wordLength = 45;
        String[] forbiddenSubstrings = {"AAAAABAAABAAAABAA", "A?BAAAAAAAAABABAB", "?AABABB?ABAAB?A?A", "AAAAABAAAAAAABBAA", "ABAABBAAABAAAAAAA", "BBBABA?BAAAAAAA?A", "AAAAABBABAABBAAAB", "AAAAAB?AAAAABAA?B", "BBBBBAAABABABAAAA", "AAAAABABAAAAABAAA", "AAA?BBBABAAAABAAA", "?AAAAAAAAAAAA??AB", "BBAAABBBB?AAAAABA", "AAABAABBABBAA?AAA", "ABAABAAABAAABBBAA", "B?BABABBAAAAAAAAA", "AABBABAABA?ABAABA", "AAABAAAAAAAAABAAA", "AAAABABAAAAABAABB", "BAAAABABAAB?AABAA", "AAA?BABAAABBABAAB", "AAAAAABABBAABABAA", "BA?ABBBAAABAABAAB", "ABBABAABBBBABB?BA", "ABAAAABBABBBAAAAA", "BAABABAABAAAABBAA", "ABAAABAAAAAAAABAB", "BA?AB??AAABABBA?A", "BAAAAAAAABBBAAAAA", "AAA?AA?AABAAAAABB", "AABABAAAAAAAA?AAA", "BAA?A?AABAABB??AB", "BABABBABAAABAAABA", "ABAAAABAAAABAAAAA", "BABAABAAAAABBAABA", "AAAAABBABBABBAAAA", "ABABAABA?BB?AAABA", "AAAAAB??AAA?BA?AB", "BBAABA?BAABBAAAAA", "AABAABBAAAAAAAAAA", "AAB?BA?BBBABBBBAA", "BAAAAAABBAAAAAABA", "ABABAABA?BBAAAAAA", "?AAAAAAAAAAAAAAAA", "AABBBABABBAAA?BBB", "BABAAAAAAAAAAABBA"};
        int[] wordNumbers =   {687738253, 187945398, 632070505, 130820143, 37949091, 425408824, 91704022, 624240995, 14103834, 274602659, 77455122, 66554069, 500227685, 108132902, 643034397, 83736335, 65041462, 66185183, 83813842, 521720371, 389664255, 17801820, 36134839, 122946073, 141768520, 28629239, 276881902, 538924875, 122732442, 108574481, 462435766, 176752327, 3065846, 41679057, 220811912, 25697288, 109667375, 835764297, 314389780, 300521232, 900740678, 18139574, 136187272, 167397072, 769432620, 454631840, 22919505, 128693589, 87411658, 257311749};

        String[] expected = {"AAAAAAAAAAAAAABBBBABBAABABBBABABBBAABAABBBBAA", "AAAAAAAAAAAAAAABBBABBBBBAAABBABAABBBAAABBBABB", "AAAAAAAAAAAAAABBBABBBBBAABBBABAABBABBABABAABA", "AAAAAAAAAAAAAAABBBAAAABBAABAAAABBAAAABAABBBAB", "AAAAAAAAAAAAAAABAAABABABAABBBABABAAABABABABAB", "AAAAAAAAAAAAAABBAAABBAABAABAABBBBBBAABBBBBAAB", "AAAAAAAAAAAAAAABBAAABBBBBBBABBBAAABBBBBAAABAA", "AAAAAAAAAAAAAABBBABBBABABABABAAAAABABAABABBBA", "AAAAAAAAAAAAAAABAAAABAABBAAABAAABBABAAAAABBBB", "AAAAAAAAAAAAAABAAAAABABAABABBABBABABABBABABAB", "AAAAAAAAAAAAAAABBAAABAABAAAABAAABBBBBABAAAABA", "AAAAAAAAAAAAAAABBAAAAABBBAAAAAAAAAAABBBBBBABA", "AAAAAAAAAAAAAABBAABBBBABABBAAABBBBBBBAABAAAAA", "AAAAAAAAAAAAAAABBAABABBBBBBAABBBBAAAABBABAAAB", "AAAAAAAAAAAAAABBBBAAAABBBBAAABBABBBBBAAAAAAAA", "AAAAAAAAAAAAAAABBAAABBAAAAABAABBBABABAABAAAAA", "AAAAAAAAAAAAAAABBAAAAABABBAAAABBBBABABAAABBAA", "AAAAAAAAAAAAAAABBAAAAABBABABAABABAABABAAABBBA", "AAAAAAAAAAAAAAABBAAABBAAAAABBBABABAABBABAAABA", "AAAAAAAAAAAAAABBBAAABAAAABABABBBBABAAABAABABB", "AAAAAAAAAAAAAABBAAAAABBBABABAAABBBAAAABABBABA", "AAAAAAAAAAAAAAABAAAABABBABABABABBAABBBBBAAABB", "AAAAAAAAAAAAAAABAAABABAAABABABBBBABABABBAABAA", "AAAAAAAAAAAAAAABBAABBBBBAAAABABBBABBBBBBBABBB", "AAAAAAAAAAAAAAABBBAABAAABABABBBAAAAABBABABBAB", "AAAAAAAAAAAAAAABAAABAAAABABBABBABABAABBBABABA", "AAAAAAAAAAAAAABAAAAABABBABBBABABABBAABAAAAAAB", "AAAAAAAAAAAAAABBBAABAAABAABABBBABAABAABBAAAAB", "AAAAAAAAAAAAAAABBAABBBBABBBBAAABABBABAABABAAB", "AAAAAAAAAAAAAAABBAABBAAAAAABBBBABABAAAABBBABA", "AAAAAAAAAAAAAABBAABABABBAAABBBBBABBBAAAABBBBB", "AAAAAAAAAAAAAAABBBABBAABBABBAABBBAAABAAABAABA", "AAAAAAAAAAAAAAABAAAAAAABBABBABBBBAABABAABABAB", "AAAAAAAAAAAAAAABAAABABBBAAAABAAAABABABAAABAAB", "AAAAAAAAAAAAAAABBBBABBBBAAAAAABABABABABAAABAA", "AAAAAAAAAAAAAAABAAAABBBBAABAABBAABABBBBABBBBA", "AAAAAAAAAAAAAAABBAABBAAABABAABABBBABBBABAABAA", "AAAAAAAAAAAAABAAAABABABBBBBABABABABBBBBAABABA", "AAAAAAAAAAAAAABAAABAAAABBBBBBAABBBBAAABBABBAA", "AAAAAAAAAAAAAABAAAABBABABBBBBAAABAAAABBBBBBAB", "AAAAAAAAAAAAABAAABAABABBBBBBBABAAABBBAAABAAAA", "AAAAAAAAAAAAAAABAAAABABBABBBBBBBAAAAAABABABBA", "AAAAAAAAAAAAAAABBBAAABABBABBBAABBAAAAAABBABBA", "AAAAAAAAAAAAAAABBBABABABAABAABABBBBABABBAAABB", "AAAAAAAAAAAAABAAAAAAAAAABBBBBBBBBBBBBBBBABBBB", "AAAAAAAAAAAAAABBAABAABBBABABAABBAABABAAABBBBA", "AAAAAAAAAAAAAAABAAAABBABBBAABBBBABBABBBAAAAAB", "AAAAAAAAAAAAAAABBBAAAAABBBABBAAABBBBABBABBBBB", "AAAAAAAAAAAAAAABBAAABBABBBABBAABBBBBBBABAABAB", "AAAAAAAAAAAAAABAAAAAAAAABBAAABAABAABBAABBBBBA"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        Assert.assertArrayEquals(expected, actual);
    }



    @Test(timeout = 2000)
    public void sysTestCase70() {
        int wordLength = 50;
        String[] forbiddenSubstrings = {};
        int[] wordNumbers = {1000000000};

        String[] expected =     {"AAAAAAAAAAAAAAAAAAAABBBABBBAABBABABBAABABAAAAAAAAA"};
        String[] actual = solution.getWords(wordLength, forbiddenSubstrings, wordNumbers);

        Assert.assertArrayEquals(expected, actual);
    }




}
