import java.math.BigInteger;
import java.security.spec.ECFieldFp;

import static java.math.BigInteger.*;
public class ECEncrypt {

	public ECEncrypt() {
		BigInteger p=valueOf(3);
		ECFieldFp field=new ECFieldFp(p);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ECEncrypt();
	}

}
