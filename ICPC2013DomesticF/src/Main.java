import java.util.*;

/**
 * ICPC 2013 Domestic f
 * @author koba-e964
 *
 */
public class Main {
	Main(int[] a,int[] b,Rule[] rules){
		
	}
	int dp[][][];
	void solve(){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n,m,r;
		while(true){
			n=scan.nextInt();
			m=scan.nextInt();
			r=scan.nextInt();
			if(n+m+r==0)break;
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=scan.nextInt();
			}
			int[] b=new int[m];
			for(int i=0;i<m;i++){
				b[i]=scan.nextInt();
			}
			Rule[] rules=new Rule[r];
			for(int i=0;i<r;i++){
				int k=scan.nextInt();
				int[] x=new int[k];
				for(int j=0;j<k;j++){
					x[i]=scan.nextInt();
				}
				int y=scan.nextInt();
				rules[i]=new Rule(x,y);
			}
			Main inst=new Main(a,b,rules);
			inst.solve();
		}
	}
	static class Rule{
		Rule(int[] x,int y){
			this.x=x.clone();
			this.y=y;
		}
		int[] x;
		int y;
	}
}
