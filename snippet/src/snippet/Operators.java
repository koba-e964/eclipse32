package snippet;

import java.io.File;
import java.math.BigInteger;

public class Operators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("1<<17-1=%x\n", 1<<17-1);
		System.out.printf("0xcafebabe>>>8&0xff=%x\n", 0xcafebabe>>>8&0xff);
		System.out.printf("1<<2*4=%x\n",1<<2*4);
		BigInteger.ONE.multiply(null);
	}

}
