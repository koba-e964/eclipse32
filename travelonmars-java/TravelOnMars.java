import java.util.*;
public class TravelOnMars {
	int[][] edges;
	int n;
	final int INF=0x3ffffff;
	static int mod(int a,int b){
		return ((a%b)+b)%b;
	}
	public int minTimes(int[] range, int startCity, int endCity) {
		n=range.length;
		edges=new int[n][n];
		for(int[] row:edges){
			Arrays.fill(row,INF);
		}
		for(int i=0;i<n;i++){
			for(int p=i-range[i];p<i+range[i]+1;p++){
				edges[i][mod(p,n)]=1;
			}
			edges[i][i]=0;
		}
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(edges[i][k]+edges[k][j]<edges[i][j])
						edges[i][j]=edges[i][k]+edges[k][j];
				}
			}
		}
		return edges[startCity][endCity];
	}

}
//SRM 
