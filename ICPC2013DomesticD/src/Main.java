import java.util.*;

/**
 * ICPC 2013 Domestic D
 * @author 2adc
 *
 */
public final class Main {
	int m,n;
	final static int BIAS=1000;
	final static int SIZE=2000;
	int map[][];
	int[] lowest;
	int sx,sy;
	Main(int m,int n){
		this.m=m;
		this.n=n;
		map=new int[SIZE][SIZE];
		lowest=new int[SIZE];
		Arrays.fill(lowest,-1);
		for(int[] row:map){
			Arrays.fill(row,-1);
		}
		int x=BIAS;
		int y=BIAS;
		int cnt=1;
		outer:
		for(int l=1;;l++){
			int sgn=l%2==1?1:-1;
			for(int i=0;i<l;i++){
				lowest[x]=Math.max(lowest[x], y);
				if(cnt==n){
					sx=x;
					sy=y;
				}
				map[y][x]=cnt++;
				x+=sgn;
				if(cnt>m)break outer;
			}
			for(int i=0;i<l;i++){
				lowest[x]=Math.max(lowest[x], y);
				if(cnt==n){
					sx=x;
					sy=y;
				}
				map[y][x]=cnt++;
				y-=sgn;
				if(cnt>m)break outer;
			}
		}
	}
	void solve(){
		dp=new int[SIZE][SIZE];
		for(int[] row:dp){
			Arrays.fill(row, -1);
		}
		lp=new int[SIZE][SIZE];
		for(int[] row:lp){
			Arrays.fill(row, -1);
		}
		rec(sx,sy);
		System.out.println(dp[sy][sx]+" "+(lp[sy][sx]==-1?0:lp[sy][sx]));
	}
	int dp[][];
	int lp[][];
	void rec(int x,int y){
		if(dp[y][x]!=-1)return;
		if(map[y][x]==-1)return;
		int maxv=0,maxp=-1;
		for(int d=-1;d<=1;d++){
			if(map[y+1][x+d]==-1)continue;
			rec(x+d,y+1);
			if(maxv<dp[y+1][x+d]||(maxv==dp[y+1][x+d]&&maxp<lp[y+1][x+d])){
				maxv=dp[y+1][x+d];
				maxp=lp[y+1][x+d];
			}
		}
		if(prime[map[y][x]]){
			maxv++;
			if(maxp==-1)maxp=map[y][x];
		}
		dp[y][x]=maxv;
		lp[y][x]=maxp;
	}
	void dump(){
		for(int i=0;i<SIZE;i++){
			boolean hasCont=false;
			for(int j=0;j<SIZE&&!hasCont;j++){
				if(map[i][j]!=-1){
					hasCont=true;
				}
			}
			if(!hasCont)continue;
			System.out.print(i+":");
			for(int j=0;j<SIZE;j++){
				if(map[i][j]==-1)continue;
				System.out.print("("+map[i][j]+","+dp[i][j]+")");
			}
			System.out.println();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int m,n;
		initPrime();
		while(true){
			m=scan.nextInt();
			n=scan.nextInt();
			if(m==0&&n==0)break;
			Main inst=new Main(m,n);
			inst.solve();
		}
		
	}
	static boolean prime[];
	public static void initPrime(){
		prime=new boolean[1000010];
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		for(int i=2;i<1010;i++){
			if(!prime[i])continue;
			for(int j=i*2;j<prime.length;j+=i){
				prime[j]=false;
			}
		}
	}

}
