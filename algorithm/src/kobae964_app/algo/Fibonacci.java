package kobae964_app.algo;

import java.math.BigInteger;

import static java.math.BigInteger.*;
/**
 * {0,1,1,2,3,5,8,13,...}
 * @author koba-e964
 */
public final class Fibonacci {
	public static BigInteger fibNaive(BigInteger n)
	{
		if(n.signum()<0)return valueOf(-1L);
		BigInteger cur,prev;
		cur=valueOf(0);
		prev=valueOf(1);
		for(BigInteger i=ZERO;i.compareTo(n)<0;i=i.add(ONE))
		{
			BigInteger tmp=cur;
			cur=cur.add(prev);
			prev=tmp;
		}
		return cur;
	}
	public static BigInteger fibBinary(BigInteger n)
	{
		if(n.signum()<0)return ONE.negate();
		int size=n.bitLength();
		BigInteger even=ZERO,odd=ONE;//F_(n>>i),F_((n>>i)+1)
		for(int i=size-1;i>=0;i--)
		{
			BigInteger even_sq=even.pow(2);
			BigInteger even_odd=even.multiply(odd);
			even=even_odd.shiftLeft(1).subtract(even_sq);
			odd=even_sq.add(odd.pow(2));
			if(n.testBit(i))
			{
				BigInteger tmp=even.add(odd);
				even=odd;
				odd=tmp;
			}
		}
		return even;
	}
	public static BigInteger fibBinaryModulo(BigInteger n,BigInteger mod)
	{
		if(n.signum()<0)return ONE.negate();
		if(mod.signum()==0)return fibBinary(n);
		if(mod.signum()<0)mod=mod.negate();
		int size=n.bitLength();
		BigInteger even=ZERO,odd=ONE;//F_(n>>i),F_((n>>i)+1)
		for(int i=size-1;i>=0;i--)
		{
			BigInteger even_sq=even.pow(2);
			BigInteger even_odd=even.multiply(odd);
			even=even_odd.shiftLeft(1).subtract(even_sq);
			odd=even_sq.add(odd.pow(2));
			if(n.testBit(i))
			{
				BigInteger tmp=even.add(odd);
				even=odd;
				odd=tmp;
			}
			even=even.mod(mod);
			odd=odd.mod(mod);
		}
		return even.mod(mod);
	}
	private static BigInteger helper0(BigInteger p)
	{
		if(p.equals(valueOf(2)))
			return valueOf(3);
		if(p.equals(valueOf(5)))
			return valueOf(20);
		int pm5=p.mod(valueOf(5)).intValue();
		/*
		 * if p==1 || p== 4 (mod 5) then (5/p)=1
		 */
		if(pm5==1 || pm5==4)
		{
			return p.subtract(ONE);
		}
		return p.add(ONE).shiftLeft(1);
	}
	private static BigInteger calcPeriod(BigInteger mod)
	{
		assert mod.signum()>0;
		BigInteger p=valueOf(2);
		BigInteger sum=ONE;
		int pow=0;
		while((mod.compareTo(ONE)>0  && p.compareTo(mod)<=0)|| pow>0)
		{
			if(!mod.remainder(p).equals(ZERO) )
			{
				if(pow==0 && p.pow(2).compareTo(mod)>0)
				{
					p=mod;//mod is prime
					continue;
				}
				if(pow!=0)
				{
					sum=sum.multiply(helper0(p));
				}
				p=p.add(ONE);
				pow=0;
				continue;
			}
			pow++;
			mod=mod.divide(p);
			if(pow>=2)
			{
				sum=sum.multiply(p);
			}
		}
		assert mod.equals(ONE) : "mod remains";
		return sum;
	}
	public static BigInteger fibModulo(BigInteger n,BigInteger mod)
	{
		if(mod.signum()==0)return fibBinary(n);
		mod=mod.abs();
		BigInteger period=calcPeriod(mod);
		BigInteger nm=n.mod(period);
		return fibBinaryModulo(nm,mod);
	}
}
