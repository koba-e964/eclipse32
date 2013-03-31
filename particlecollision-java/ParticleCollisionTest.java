import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class ParticleCollisionTest {

    protected ParticleCollision solution;

    @Before
    public void setUp() {
        solution = new ParticleCollision();
    }

    public static void assertArrayEquals(double[] expected, double[] actual) {
        boolean failed = (actual == null || (expected.length != actual.length));
        for (int i = 0; i < expected.length && !failed; i++) {
            if (Double.isNaN(expected[i]) && !Double.isNaN(actual[i])) {
                failed = true;
            } else {
                double delta = Math.max(1e-9, 1e-9 * Math.abs(expected[i]));
                failed = (Math.abs(actual[i] - expected[i]) > delta);
            }
        }
        if (failed) {
            Assert.fail("expected:<" + Arrays.toString(expected) + ">, but was:<" + Arrays.toString(actual) + ">");
        }
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int vx = 0;
        int vy = 0;
        int vz = 0;
        int x0 = 0;
        int y0 = 0;
        int z0 = 0;

        double[] expected = new double[]{};
        double[] actual = solution.collision(vx, vy, vz, x0, y0, z0);

        assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int vx = 2;
        int vy = 4;
        int vz = 1;
        int x0 = -1;
        int y0 = -1;
        int z0 = 0;

        double[] expected = new double[]{0.0, 1.0, 0.5};
        double[] actual = solution.collision(vx, vy, vz, x0, y0, z0);

        assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int vx = 4;
        int vy = 4;
        int vz = 2;
        int x0 = 5;
        int y0 = 4;
        int z0 = 0;

        double[] expected = new double[]{0.0, 0.0, 0.0};
        double[] actual = solution.collision(vx, vy, vz, x0, y0, z0);

        assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int vx = 0;
        int vy = 0;
        int vz = 1;
        int x0 = 1;
        int y0 = 0;
        int z0 = 0;

        double[] expected = new double[]{0.0, 0.0, 0.0};
        double[] actual = solution.collision(vx, vy, vz, x0, y0, z0);

        assertArrayEquals(expected, actual);
    }

}
