import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColorfulBuildingTest {

    protected ColorfulBuilding solution;

    @Before
    public void setUp() {
        solution = new ColorfulBuilding();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] color1 = new String[]{"aaba"};
        String[] color2 = new String[]{"aaaa"};
        int L = 3;

        int expected = 6;
        int actual = solution.count(color1, color2, L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] color1 = new String[]{"aaba"};
        String[] color2 = new String[]{"aaba"};
        int L = 4;

        int expected = 0;
        int actual = solution.count(color1, color2, L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] color1 = new String[]{"ab", "ba", "a", "aab"};
        String[] color2 = new String[]{"bb", "ba", "a", "aba"};
        int L = 5;

        int expected = 432;
        int actual = solution.count(color1, color2, L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] color1 = new String[]{"xxxxxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxxxxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOxxxxxxxxxxxxxxxx", "xxOOxxxxxxxxxxxxxxxx", "xxOOxxxxxxxxxxxxxxxx", "xxOOxxxxxxxxxxxxxxxx", "xxOOxxxxxxxxxxxxxxxx", "xxOOxxxxxxxxxxxxxxxx", "xxOOxxxxxxxxxxxxxxxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxxxxxxxxxxxxxxxOOxx", "xxxxxxxxxxxxxxxxOOxx", "xxxxxxxxxxxxxxxxOOxx", "xxxxxxxxxxxxxxxxOOxx", "xxxxxxxxxxxxxxxxOOxx", "xxxxxxxxxxxxxxxxOOxx", "xxxxxxxxxxxxxxxxOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxxxxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxxxxx"};
        String[] color2 = new String[]{"xxxxxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxxxxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOxxxxxxxxxxxxOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxOOOOOOOOOOOOOOOOxx", "xxxxxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxxxxx"};
        int L = 58;

        int expected = 619787617;
        int actual = solution.count(color1, color2, L);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] color1 = new String[]{"SJXcabKTWeUXhwxGixFepQaQlFxrAedNAtVP", "gorBIkcTlOFbLDbFeElYAyAqszQdMbpxSRdE", "SQVHPehlNtesbJDflyGxMqvgzjXisRnqDcQO", "pIAEBwbmpPWCooQAujbGXFGLvXxTmExLARkf", "AFnWyWKVObfxDGCjTxdZaObgwdxlPKtIxaAd", "uznMpJVNjAofbHJjOrZeSHgSagOCUMGbvkVR", "LBRrDbTAyKfVnedKiRfzgRzECpcsziqaTwdo", "JrJHvsEVVGDkNVGqLbpxyLDPloBuNDQKnReI", "SSYpbjKHSCnQhuyYrVauWDHDyhAoGyecrZMv", "UdetQfWEUWHHuAxRSdkJOOJSixKpQXpCFZHO", "KXVsQbuQtIgsULOMsTvPFNUqkBldMTLCipYK", "hoXConjnDWQkZVtyZlwSedvdVrNWqQhGUClQ", "TpsvvyoXsXmQpBAGGVDrXCkodoRHQZmpoQDW", "csiJspzTqeFBRmPgeEtTAzfrfCGlTZqcPuyO", "vsPDVBJVaJmUAtDdcsKoUkPEbDmAwtZKwjjP", "MOfoMhMiKIvGQoeIJXHzyClWRtRuKXMqxUAF", "KyyUCkRBjsYvmPFFEGBqqVhIUdtvIyyLacfu", "BfuwfSajSlcuTzhMufHSQLudvGEGlyHsEmBD", "PLpIXZkdyXveTMfSvqnDGKWOZrTBMUIlZrqF", "dzVMCqrSLbanRJTYpDJNHAOLPSzmvSEPQJYm", "rAjRkrSjouJyFaCSPPLYSzqDmMoADyWAbobJ", "eOCBrJNoyFnGpXpxiExXcoOHnVsaEPXhPfLe", "XMjRksnxWssPEINhdhbiLBSYpCLtwNshFjXS", "HnnDeUAbuswsgsYQuAaXySLkFYUwFXwYTreM", "uqLnwOEGbwZZDgAAWEdLRZxFlogDmlhjhgHM", "NcfaQsgPQfirkYDRFrLQpySmBGfRHumKULZf", "mOpmmgclsxRzXskEywfryqCRyATNoJwnlHiD", "AnoKoKAjrasttjNlHCROnvTJMhEHlVPVoVMo", "yegLyIuRkkENFAjwzDoPLKjgUHHEkfzYDIpo", "EcxRGGfuaBXUFXkSxctJWOLmmVbvoMkWtTvV", "nBMkOBHgaltEVzfyGxseGhmBscfGIbxFbqRn", "GvkEcLtqdOofGtsbWDafVMbNdJxsffKDzSiR", "jhZQUVzTzalrZcebvyqPWtOUUyniBKTWdyLi", "ODJLQPMdjDdTlxrfGsNmBfeGYjzeXApqKDhJ", "vlJkWMzdVQujKdLViQClOrJXMTBkuZEasFgg", "FAsbuzrLVIgaryqXBfuBRAbReleXSSgEKSvt"};
        String[] color2 = new String[]{"XAhlUHtfjOpOlQlowWppQcodMGUiqoLobxnD", "IDzGlKrHiVGdBjZxIcoxjwagbWieKvUwZrjg", "SkpkTVeIFeoNQzUUgmYAYskKONNZdgXxSiWd", "rXBGhTmqnvxkmqiutoDzPusDiOUggEFXGCzm", "fzrxVuTbFXunGbeEavjshmrIRlDorTuISCxn", "LsvIaxTkOBjcskiekmrKNNFEXqnfMNXLWqqu", "ekzxGIlbJPVEQPYAbTuMtZKsCiubDXDiBVzU", "hZuOCJxvBOYENGSFcUiKKAKfCdebutVmnyvB", "UveNkKRQmHnedrROQOpHJfrHjwcNLUShlDbn", "ptUkvbaGDryHRkYfHKLkSgVpjWCEcgazyxGK", "nVPYEqTTJsRPjzjfdOiULhnZPFeNcnbXaQlk", "IPXBXRhMQIkxpygsgbcRfMuvIcuzUPPHGOWX", "yWWlNyEyqZSIOXBFAybIuFpVqpvmKRaRFrAE", "EvBJVtHvKhjrFcmtpdBbFTdTVtXXZQKAglKT", "bCVjHzUvyINFkxXageZQMzCyNhcifACdJVDh", "lZITYcDSeIbLweyFtoMAfOQyBNupKlhcNpgo", "BduslNrJdWOUukYFFidEkMFaghfofpxVgvJd", "YrJpDZKqdjEPzdLsOQEdkcrBfNHPemXHokCW", "GjeUKSGjDlgKTyUGNrMQbBLxRUcgrWpkAwOD", "wgxTcswqdJHaDugNIRMvrhBsdDaJAssVbSRW", "qmVmqFEpvgGioMXDSFqEoQcDOAaUoGPEovSO", "KrukPlpfOhawaovCfteTSCIdLMrtImVtiMyQ", "ykwmxHsKMFzFHwcbyyedLvhZPnaNGqJMMCxd", "HUNYCXjNLQIFCLLGpCXHBCHLTxLynBxnHFbx", "uwjzbNbJepVFgMPUXVirxYHzExquBEtPmKju", "xXAxAbJePyUsVHeLytDvAxBGMRtnvCEiZZqe", "xMkQoIVxWPXPgaOYmDjTOXiMImVdzojERNxS", "dwICFwMAmdOIUxyAdXdshasnzwyhfnVWVqZJ", "etypXNVvSTEQvriGBZdSGmDEHhvpSqkFklCS", "YkxpFBCRYUueRcKaJUXVdaMoYMYEooPQVMOr", "DTrexDqclZNKdPuTRFHualJSFziCLPCZjpxo", "TfEijcAsSJPikkmBSbXMqYHAhPTcpcKVSkIX", "xKXHYPYMJxFpSbxltDKYuRiTkOLxpQKnXZPs", "YFYuvuYHfpFJcrLNIdlNfBxRnWdppsdalBkx", "NFTysBvNFjejdnlhRTclbcfGipNCxpFEOriY", "thkgVflJYmbUYbIlafNUMGePQWiZyYzYXvUR"};
        int L = 1200;

        int expected = 396065426;
        int actual = solution.count(color1, color2, L);

        Assert.assertEquals(expected, actual);
    }

}
