import java.util.*;
public class NextNumber {

	public int getNextNumber(int N) {
		if(N%2==1)
		{
			int t=N&~(N+1);
			return N+(t+1)/2;
		}
		int lb=N&(-N);
		int t=N&~(N+lb);
		int m=Integer.numberOfTrailingZeros(t);
		return N+lb+(t>>(m+1));
	}

}
//SRM416 div2 medium