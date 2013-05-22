import java.util.*;
public class TheNumberGameDivOne {

	public String find(long n) {
		if(n%2==1)
		{
			return "Brus";
		}
		if((n&(-n))!=n)return "John";
		return Long.numberOfTrailingZeros(n)%2==0?"John":"Brus";
	}

}
//SRM