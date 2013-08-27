import java.util.*;
public class Egalitarianism {
	final static int INF=0x10000000;
	public int maxDifference(String[] isFriend, int d) {
		int  n=isFriend.length;
		int[][] p=new int[n][n];
		for(int[] row:p){
			Arrays.fill(row, INF);
		}
		for(int i=0;i<n;i++){
			p[i][i]=0;
			for(int j=0;j<n;j++){
				if(isFriend[i].charAt(j)=='Y'){
					p[i][j]=1;
				}
			}
		}
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(p[i][j]>p[i][k]+p[k][j]){
						p[i][j]=p[i][k]+p[k][j];
					}
				}
			}
		}
		int max=-1;
		for(int[] row:p){
			for(int a:row){
				max=Math.max(max, a);
			}
		}
		return max==INF?-1:max*d;
	}

}
//SRM 
