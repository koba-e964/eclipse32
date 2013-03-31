package kobae964_app.algo;

import static org.junit.Assert.*;
import java.math.BigInteger;
import java.util.Random;


import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;

public class ModularTest {

	private final class InverseMatcher extends BaseMatcher<Integer> {
		private final int p;
		private final int a;

		private InverseMatcher(int p, int a) {
			this.p = p;
			this.a = a;
		}

		@Override
		public boolean matches(Object item) {
			return (item instanceof Integer) && (((long)(Integer)item)*a)%p==1;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("i*"+a+"=1 (mod "+p+")");
		}
	}
	@Test
	public void test0Power() {
		int a=234;
		int b=197;
		int mod=119;
		int expected=47;
		int actual=Modular.power(a, b, mod);
		assertEquals(expected, actual);
	}
	@Test
	public void test1Power() {
		int a=5;
		int b=-1;
		int mod=101;
		int expected=81;//5*81=405=1 (mod 101)
		int actual=Modular.power(a, b, mod);
		assertEquals(expected, actual);
	}
	@Test
	public void test2Power() {
		int a=17;
		long b=(1L<<63)+1;//-2^63
		int mod=257;
		int expected=17;
		int actual=Modular.power(a, b, mod);
		assertEquals(expected, actual);
	}
	@Test
	public void test0IsPrime() {
		int p=3;
		boolean expected=true;
		boolean actual=Modular.isPrime(p);
		assertEquals(expected, actual);
	}
	@Test
	public void test1IsPrime() {
		int p=9;
		boolean expected=false;
		boolean actual=Modular.isPrime(p);
		assertEquals(expected, actual);
	}
	@Test
	public void test2IsPrime() {
		long p=1000000000061L;
		boolean expected=true;
		boolean actual=Modular.isPrime(p);
		assertEquals(expected, actual);
	}
	@Test
	public void test3IsPrime() {
		long p=85780729627134811L;
		boolean expected=false;
		boolean actual=Modular.isPrime(p);
		assertEquals(expected, actual);
	}
	@Test
	public void test0InversePower()
	{
		int a=5;
		int p=101;
		int expected=81;
		int actual=Modular.inversePower(a, p);
		assertEquals(expected, actual);
	}
	@Test
	public void test1InversePower()
	{
		int a=5;
		int p=1363359113;
		int expected=p/5*3+2;
		int actual=Modular.inversePower(a, p);
		assertEquals(expected, actual);
	}
	@Test
	public void test2InversePower()
	{
		Random rnd=new Random();
		final int p=1363359113;
		for(int i=0;i<100;i++)
		{
			final int a=rnd.nextInt(p-1)+1;
			int actual=Modular.inverseEuclid(a, p);
			assertThat(actual, new InverseMatcher(p, a));
		}
	}
	@Test
	public void test0InverseEuclid()
	{
		int a=5;
		int p=101;
		int expected=81;
		int actual=Modular.inverseEuclid(a, p);
		assertEquals(expected, actual);
	}
	@Test
	public void test1InverseEuclid()
	{
		int a=5;
		int p=1363359113;
		int expected=p/5*3+2;
		int actual=Modular.inverseEuclid(a, p);
		assertEquals(expected, actual);
	}
	@Test
	public void test2InverseEuclid()
	{
		Random rnd=new Random();
		final int p=1363359113;
		for(int i=0;i<100;i++)
		{
			final int a=rnd.nextInt(p-1)+1;
			int actual=Modular.inverseEuclid(a, p);
			assertThat(actual, new InverseMatcher(p, a));
		}
	}
	@Test
	public void testInversePowerEuclid()
	{
		Random rand=new Random();
		for(int i=0;i<0x400;i++)
		{
			int a=rand.nextInt(0x7fffffff);
			int p=BigInteger.probablePrime(31, rand).intValue();
			if(a%p==0)continue;
			int actual1=Modular.inversePower(a,p);
			int actual2=Modular.inverseEuclid(a, p);
			assertEquals("a="+a+", p="+p,actual1, actual2);
		}
	}
	@Test
	public void test0Quadratic()
	{
		Random rnd=new Random();
		for(int i=0;i<100;i++)
		{
			int p=1000000007;
			int t=rnd.nextInt(p-1)+1;
			int a=(int)(((long)t*t)%p);
			int expected=1;
			assertTrue(Modular.isPrime(p));
			int actual=Modular.quadratic(a, p);
			assertEquals(expected, actual);
		}
	}
}
