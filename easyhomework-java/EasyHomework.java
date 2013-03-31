import java.util.*;
public class EasyHomework {

	public String determineSign(int[] A) {
		boolean neg=false;
		for(int v:A)
		{
			if(v==0)return "ZERO";
			if(v<0)neg=!neg;
		}
		return neg?"NEGATIVE":"POSITIVE";
	}

}
//SRM