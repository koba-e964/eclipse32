package kobae964_app.algo;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;

import org.junit.Test;

import static java.math.BigInteger.*;
import static kobae964_app.algo.Fibonacci.*;

public class FibonacciTest {

	@Test(timeout=1000)
	public void test0FibNaive() {
		BigInteger n=valueOf(4);
		BigInteger expected=valueOf(3);
		BigInteger actual=fibNaive(n);
		assertEquals(expected, actual);
	}
	@Test(timeout=1000)
	public void test1FibNaive() {
		BigInteger n=valueOf(31);
		BigInteger expected=valueOf(1346269);
		BigInteger actual=fibNaive(n);
		assertEquals(expected, actual);
	}
	@Test(timeout=1000)
	public void test2FibNaive() {
		BigInteger n=valueOf(62);
		BigInteger expected=valueOf(1346269L*(832040+2178309));
		BigInteger actual=fibNaive(n);
		assertEquals(expected, actual);
	}
	@Test(timeout=1000)
	public void test3FibNaive() {
		for(int k=1;k<1000;k++)
		{
			BigInteger n=valueOf(2*k);
			BigInteger expected=
					fibNaive(valueOf(k+1)).add(fibNaive(valueOf(k-1))).multiply(fibNaive(valueOf(k)));
			BigInteger actual=fibNaive(n);
			assertEquals(expected, actual);
		}
	}
	@Test(timeout=1000)
	public void test4FibNaive() {
		Random rnd=new Random();
		final BigInteger TWO=valueOf(2L);
		for(int k=0;k<1;k++)
		{
			BigInteger p=new BigInteger(15, rnd);
			BigInteger n=p.multiply(TWO);
			BigInteger expected=
					fibNaive(p.add(ONE)).add(fibNaive(p.subtract(ONE))).multiply(fibNaive(p));
			BigInteger actual=fibNaive(n);
			assertEquals(expected, actual);
		}
	}
	@Test(timeout=1000)
	public void test0FibBinary() {
		BigInteger n=valueOf(4);
		BigInteger expected=valueOf(3);
		BigInteger actual=fibBinary(n);
		assertEquals(expected, actual);
	}
	@Test(timeout=1000)
	public void test1FibBinary() {
		BigInteger n=valueOf(31);
		BigInteger expected=valueOf(1346269);
		BigInteger actual=fibBinary(n);
		assertEquals(expected, actual);
	}
	@Test(timeout=1000)
	public void test2FibBinary() {
		BigInteger n=valueOf(62);
		BigInteger expected=valueOf(1346269L*(832040+2178309));
		BigInteger actual=fibBinary(n);
		assertEquals(expected, actual);
	}
	@Test(timeout=1000)
	public void test3FibBinary() {
		for(int k=1;k<1000;k++)
		{
			BigInteger n=valueOf(2*k);
			BigInteger expected=
					fibBinary(valueOf(k+1)).add(fibBinary(valueOf(k-1))).multiply(fibBinary(valueOf(k)));
			BigInteger actual=fibBinary(n);
			assertEquals(expected, actual);
		}
	}
	@Test(timeout=1000)
	public void test4FibBinary() {
		Random rnd=new Random();
		final BigInteger TWO=valueOf(2L);
		for(int k=0;k<1;k++)
		{
			BigInteger p=new BigInteger(15, rnd);
			BigInteger n=p.multiply(TWO);
			BigInteger expected=
					fibBinary(p.add(ONE)).add(fibBinary(p.subtract(ONE))).multiply(fibBinary(p));
			BigInteger actual=fibBinary(n);
			assertEquals(expected, actual);
		}
	}
	@Test(timeout=1000)
	public void test0FibModulo()
	{
		BigInteger n=valueOf(1000);
		BigInteger mod=valueOf(-3);
		BigInteger expected=fibBinary(n).mod(mod.abs());
		BigInteger actual=fibModulo(n, mod);
		assertEquals(expected, actual);
	}
	@Test(timeout=1000)
	public void test1FibModulo()
	{
		Random rnd=new Random();
		for(int i=0;i<10000;i++)
		{
			BigInteger n=new BigInteger(10,rnd);
			BigInteger mod=new BigInteger(10,rnd);
			if(rnd.nextBoolean())mod=mod.negate();
			BigInteger expected;
			expected=mod.signum()==0?fibBinary(n):fibBinary(n).mod(mod.abs());
			BigInteger actual=fibModulo(n, mod);
			assertEquals(expected, actual);
		}
	}
	@Test(timeout=1000)
	public void test2FibModulo()
	{
		Random rnd=new Random();
		for(int i=0;i<100;i++)
		{
			BigInteger n=new BigInteger(100,rnd);
			BigInteger mod=new BigInteger(30,rnd);
			if(rnd.nextBoolean())mod=mod.negate();
			BigInteger actual=fibModulo(n, mod);
			assert actual.equals(actual);
		}
	}
	
}
