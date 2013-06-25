import java.util.*;
public class SpaceWarDiv1 {

	public long minimalFatigue(int[] magicalGirlStrength, int[] enemyStrength, long[] enemyCount) {
		int m=magicalGirlStrength.length;
		int n=enemyCount.length;
		Arrays.sort(magicalGirlStrength);
		long max=0;
		{
			long en=0;
			for(int i=0;i<n;i++){
				en+=enemyCount[i];
			}
			max=(en+m-1)/m;
		}
		for(int st:magicalGirlStrength){
			long en=0;
			long ma=0;
			for(int i=0;i<n;i++){
				if(enemyStrength[i]>=st)
					en+=enemyCount[i];
			}
			for(int i=0;i<m;i++){
				ma+=magicalGirlStrength[i]>=st?1:0;
			}
			max=Math.max(max,(en+ma-1)/ma);
		}
		for(int st:enemyStrength){
			long en=0;
			long ma=0;
			for(int i=0;i<n;i++){
				if(enemyStrength[i]>=st)
					en+=enemyCount[i];
			}
			for(int i=0;i<m;i++){
				ma+=magicalGirlStrength[i]>=st?1:0;
			}
			if(ma==0)return -1;
			max=Math.max(max,(en+ma-1)/ma);
		}
		return max;
	}

}
//SRM 
