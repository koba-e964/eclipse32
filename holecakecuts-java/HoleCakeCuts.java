import java.util.*;
public class HoleCakeCuts {

	public int cutTheCake(int cakeLength, int holeLength, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		int count=(horizontalCuts.length+1)*(verticalCuts.length+1);
		int h=0;
		int v=0;
		boolean ch=false,cv=false;
		for(int i=0;i<horizontalCuts.length;i++)
		{
			if(i<horizontalCuts.length-1 && horizontalCuts[i]>=-holeLength && horizontalCuts[i+1]<=holeLength)
			{
				h++;
			}
			if(horizontalCuts[i]>=-holeLength && horizontalCuts[i]<=holeLength)
			{
				ch=true;
			}
		}
		for(int i=0;i<verticalCuts.length;i++)
		{
			if(i < verticalCuts.length-1 && verticalCuts[i]>=-holeLength && verticalCuts[i+1]<=holeLength)
			{
				v++;
			}
			if(verticalCuts[i]>=-holeLength && verticalCuts[i]<=holeLength)
			{
				cv=true;
			}
		}
		count-=h*v;
		if(!ch)count+=v;
		if(!cv)count+=h;
		return count;
	}

}
//SRM411 div2 hard