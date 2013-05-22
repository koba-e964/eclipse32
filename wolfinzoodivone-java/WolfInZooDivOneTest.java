import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WolfInZooDivOneTest {

    protected WolfInZooDivOne solution;

    @Before
    public void setUp() {
        solution = new WolfInZooDivOne();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 5;
        String[] L = new String[]{"0"};
        String[] R = new String[]{"4"};

        int expected = 16;
        int actual = solution.count(N, L, R);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 5;
        String[] L = new String[]{"0 1"};
        String[] R = new String[]{"2 4"};

        int expected = 21;
        int actual = solution.count(N, L, R);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 10;
        String[] L = new String[]{"0 4 2 7"};
        String[] R = new String[]{"3 9 5 9"};

        int expected = 225;
        int actual = solution.count(N, L, R);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 100;
        String[] L = new String[]{"0 2 2 7 10 1", "3 16 22 30 33 38", " 42 44 49 51 57 60 62", " 65 69 72 74 77 7", "8 81 84 88 91 93 96"};
        String[] R = new String[]{"41 5 13 22 12 13 ", "33 41 80 47 40 ", "4", "8 96 57 66 ", "80 60 71 79", " 70 77 ", "99", " 83 85 93 88 89 97 97 98"};

        int expected = 6419882;
        int actual = solution.count(N, L, R);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase69() {
        int N = 225;
        String[] L = {"217 219 86 101 13 105 8 216 105 180 219 162 160 1", "28 90 73 85 136 130 144 21 196 36 158 209 40 174 1", "77 113 206 44 214 32 85 162 184 202 88 111 72 47 6", "3 201 148 129 84 59 174 119 138 137 6 160 2 2 200 ", "205 198 193 192 73 52 50 194 97 157 203 222 39 194", " 5 21 102 200 35 178 4 177 89 200 69 173 193 19 18", "7 113 102 169 29 40 10 202 91 165 47 173 82 158 63", " 139 196 96 89 139 95 149 154 216 139 181 191 138 ", "2 64 171 62 30 186 195 99 130 141 105 167 61 149 3", "8 200 115 155 29 194 83 138 190 57 88 68 135 190 1", "93 8 193 185 219 39 45 68 162 156 129 209 68 159 2", "18 184 85 28 187 27 112 6 158 193 110 104 13 215 1", "54 160 52 117 41 51 201 189 140 176 122 143 31 133", " 198 115 96 84 32 162 32 142 148 134 6 150 54 65 1", "17 8 49 170 164 117 39 220 223 176 154 218 104 71 ", "150 10 93 70 27 81 41 128 76 164 219 144 202 41 21", "0"};
        String[] R =  {"223 219 102 162 66 128 110 219 164 208 222 217 22", "1 172 149 98 85 159 170 164 21 208 218 166 220 136", " 185 221 141 219 60 219 72 113 206 191 223 174 175", " 73 115 72 221 171 183 91 142 177 166 211 163 38 2", "00 172 170 222 224 203 218 217 222 61 135 210 137 ", "160 204 223 71 220 98 86 165 215 132 224 129 181 1", "29 216 224 178 209 21 194 170 102 200 160 55 141 2", "20 166 218 206 199 167 179 72 162 200 174 204 220 ", "138 185 184 218 214 203 205 142 153 83 203 218 49 ", "198 221 144 148 203 188 201 195 173 49 213 118 158", " 111 212 131 172 205 60 176 98 174 214 194 116 221", " 211 223 101 66 159 205 194 173 217 69 166 219 203", " 201 138 196 123 157 115 162 203 196 142 193 215 2", "16 193 154 222 135 98 206 223 207 191 215 205 135 ", "223 200 222 206 112 175 171 80 204 184 186 128 222", " 118 65 151 190 74 204 187 129 129 222 224 217 158", " 219 137 149 181 92 189 176 143 112 41 209 142 202", " 222 203 222 93 221"};

        int expected =     3602536
;
        int actual = solution.count(N, L, R);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase102() {
        int N = 300;
        String[] L = {"194 87 202 258 231 150 208 255 90 184 50 222 231 ", "193 261 189 157 186 8 261 291 60 180 49 140 87 178", " 164 39 8 237 235 57 235 188 276 188 8 46 4 68 61 ", "75 77 102 4 166 13 270 203 238 210 168 43 143 270 ", "283 85 23 1 128 147 66 254 268 102 166 213 125 45 ", "54 148 236 165 279 99 106 155 254 48 184 133 189 0", " 137 33 279 281 25 224 215 21 279 152 48 287 50 6 ", "210 65 174 263 76 131 274 58 229 147 292 187 154 2", "67 20 133 269 256 185 183 185 30 288 268 133 205 2", "11 145 16 84 56 206 167 228 254 180 217 299 175 26", "8 17 62 122 17 56 86"};
        String[] R =    {"220 142 276 260 234 209 258 284 159 265 164 254 2", "58 216 291 220 162 221 79 275 294 165 218 126 264 ", "136 225 197 108 176 285 254 159 285 238 292 189 32", " 99 26 75 68 160 168 184 170 226 215 299 277 252 2", "49 201 216 188 278 284 197 281 201 210 205 284 262", " 299 119 251 294 159 265 141 176 285 170 280 139 2", "49 266 294 265 279 256 252 140 218 68 291 281 191 ", "254 219 218 298 246 108 292 51 180 266 183 198 283", " 201 182 288 247 249 266 293 187 207 285 45 196 27", "3 263 284 284 205 133 292 292 245 256 240 160 83 2", "38 75 289 251 231 254 260 245 299 290 291 294 177 ", "202 243 60 294"};

        int expected =        12516638;
        int actual = solution.count(N, L, R);

        Assert.assertEquals(expected, actual);
    }


}
