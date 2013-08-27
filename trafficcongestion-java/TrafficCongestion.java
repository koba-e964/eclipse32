import java.util.*;
public class TrafficCongestion {
	final static int MOD=1000000007;
	long memo[];
	final int N=1000001;
	public int theMinCars(int treeHeight) {
		memo=new long[N];
		memo[0]=1;
		memo[1]=1;
		memo[2]=3;
		for(int i=3;i<N;i++){
			long res=memo[i-1];
			res+=memo[i-2]*2;
			res%=MOD;
			memo[i]=res;
		}
		return (int)memo[treeHeight];
	}

}
//SRM 
