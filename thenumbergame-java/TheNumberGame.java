import java.util.*;
public class TheNumberGame {

	public String determineOutcome(int A, int B) {
		String as=String.valueOf(A);
		String bs=String.valueOf(B);
		String arev;
		{
			char[] tmp=new char[as.length()];
			for(int i=0;i<tmp.length;i++)
			{
				tmp[i]=as.charAt(tmp.length-1-i);
			}
			arev=new String(tmp);
		}
		if(as.contains(bs) || arev.contains(bs))return "Manao wins";
		return "Manao loses";
	}

}
//SRM 574 div1 easy