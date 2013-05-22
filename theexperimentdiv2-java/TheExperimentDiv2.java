import java.util.*;
public class TheExperimentDiv2 {

	public int[] determineHumidity(int[] intensity, int L, int[] leftEnd) {
		int m=leftEnd.length;
		int[] out=new int[m];
		for(int j=0;j<intensity.length;j++)
		{
			boolean dec=false;
			for(int i=0;i<m && !dec;i++)
			{
				if(leftEnd[i]<=j && j<leftEnd[i]+L)
				{
					dec=true;
					out[i]+=intensity[j];
				}
			}
		}
		return out;
	}

}
//SRM