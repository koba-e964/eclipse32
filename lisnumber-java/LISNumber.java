import java.util.*;
public class LISNumber {
	final static int MOD=1000000007;
	public int count(int[] cardsnum, int K) {
		int[] tbl=new int[N];
		Arrays.fill(tbl, 0);
		tbl[0]=1;
		int sum=0;
		init();
		for(int v:cardsnum){
			int[] tmp=new int[N];
			Arrays.fill(tmp, 0);
			for(int i=0;i<N;i++){
				in:
				for(int j=0;j<=v;j++){
					if(i+j>=N)break in;
					long a=tbl[i]*comb(v,j);
					a%=MOD;
					a*=comb(i,v-j);
					a%=MOD;
					tmp[i+j]+=(int)a;
					tmp[i+j]%=MOD;
				}
			}
			tbl=tmp;
		}
		for(int i=0;i<=K+1;i++){
			System.out.println(i+":"+tbl[i]);
		}
		return tbl[K];
	}
	public int comb(int n,int k){
		if(k<0||k>=n+1)return 0;
		long val=f[n];
		val*=g[k];
		val%=MOD;
		val*=g[n-k];
		val%=MOD;
		return (int)val;
	}
	public int countOld(int[] cardsnum, int K) {
		int sum=0;
		for(int v:cardsnum){
			if(v>K)return 0;
			sum+=v;
		}
		if(sum<K)return 0;
		init();
		long c=1;
		for(int i=0;i<cardsnum.length;i++){
			int v=cardsnum[i];
			c*=f[v];
			c%=MOD;
			c*=g[K-v];
			c%=MOD;
			c*=g[sum-K];
			c%=MOD;
			System.out.println(i+":"+c+",v="+v);
		}
		return (int)c;
	}
	static int inv(int a){
		long sum=1;
		long cur=a;
		int pow=MOD-2;
		while(pow>0){
			if(pow%2==1){
				sum*=cur;
				sum%=MOD;
			}
			cur*=cur;
			cur%=MOD;
			pow/=2;
		}
		return (int)sum;
	}
	int[] f,g;
	final static int N=1500;
	void init(){
		long cur=1;
		f=new int[N];
		g=new int[N];
		for(int i=0;i<N;i++){
			f[i]=(int)cur;
			g[i]=inv(f[i]);
			cur*=i+1;
			cur%=MOD;
		}
	}
}
//SRM 
