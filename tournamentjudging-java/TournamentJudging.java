import java.util.*;
public class TournamentJudging {

	public int getPoints(int[] rawScores, int[] conversionFactor) {
		int n=rawScores.length;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			int tmp=(rawScores[i]+conversionFactor[i]/2)/conversionFactor[i];
			sum+=tmp;
		}
		return sum;
	}

}
//SRM 408 div2 easy