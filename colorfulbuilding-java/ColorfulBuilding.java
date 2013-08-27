import java.util.*;
public class ColorfulBuilding {
	final static long MOD=1000000009L;
	int n;
	Map<String,Integer> col=new HashMap<String, Integer>();
	Map<Integer,Integer> freq=new HashMap<Integer, Integer>();
	int kind=0;
	int max=0;
	int[] cols;
	public int count(String[] color1, String[] color2, int L) {
		String c1,c2;
		c1=concat(color1);
		c2=concat(color2);
		n=c1.length();
		cols=new int[n];
		initFact();
		for(int i=0;i<n;i++){
			String a=c1.charAt(i)+""+c2.charAt(i);
			if(!col.containsKey(a)){
				col.put(a, kind);
				freq.put(kind, 1);
				kind++;
			}
			else{
				int ind=col.get(a);
				freq.put(ind, freq.get(ind)+1);
			}
			cols[i]=col.get(a);
		}
		for(Map.Entry<Integer, Integer> ent:freq.entrySet()){
			max=Math.max(ent.getValue(), max);
		}
		return new Correct().solve(cols, kind, L);
		//return rec(L, n, n, 0,-1);
	}
	static String concat(String[] array){
		StringBuilder sb=new StringBuilder();
		for(String s:array){
			sb.append(s);
		}
		return sb.toString();
	}
	/*
	 * [0,r)
	 */
	int rec(int lrem,int h,int r,int hid,int last){
		if(lrem<0){
			return 0;
		}
		if(r==0){
			if(lrem>=1)return 0;
			return fact[hid];
		}
		if(h==n&&r<n)
			return 0;
		if(h==0){
			return 0;
		}
		int cnt=0;
		for(int i=0;i<r;i++){
			int sub=rec(lrem-(last==cols[h-1]?0:1),h-1,i,r-i-1+hid,h-1);
			cnt+=sub;
			cnt%=(int)MOD;
		}
		cnt+=rec(lrem,h-1,r,hid,last);
		cnt%=(int)MOD;
		return cnt;
	}
	int fact[];
	void initFact(){
		fact=new int[1300];
		long cur=1;
		for(int i=0;i<1300;i++){
			fact[i]=(int)cur;
			cur*=i+1;
			cur%=MOD;
		}
	}
}
class Correct{
	int n;
	static final int MOD=(int)ColorfulBuilding.MOD;
	static int mod(long val){
		return ((int)(val%MOD)+MOD)%MOD;
	}
	int solve(int cols[],int kind,int l){
		n=cols.length;
		initFact();
		dp=new int[n][l+1];
		pdp=new int[n][l+1];
		prev=new int[n];
		{
			int pid[]=new int[kind];
			Arrays.fill(pid, -1);
			for(int i=n-1;i>=0;i--){
				prev[i]=pid[cols[i]];
				pid[cols[i]]=i;
			}
		}
		for(int[] row:dp){
			Arrays.fill(row, 0);
		}
		for(int[] row:pdp){
			Arrays.fill(row, 0);
		}
		dp[n-1][1]=1;
		pdp[n-1][1]=1;
		for(int i=n-2;i>=0;i--){
			int x=prev[i];
			for(int j=0;j<=l;j++){
				long nd=i==n-1?0:dp[i+1][j];
				long sd=x==-1?0:
					mod(mod((long)pdp[x][j]*fact[n-i-2])*(long)invfact[n-x-1]);
				long dd=mod(nd-sd);
				dp[i][j]=mod(dp[i][j]+dd*(n-1-i)+sd*(n-i));
				if(j<l)
					dp[i][j+1]=mod(dp[i][j+1]+dd);
				if(j<l)
					pdp[i][j+1]=mod(pdp[i][j+1]+dd);
				pdp[i][j]=mod(pdp[i][j]+sd*(n-i));
			}
		}
		return dp[0][l];
	}
	int dp[][];
	int pdp[][];
	int prev[];
	int fact[];
	int invfact[];
	void initFact(){
		fact=new int[n+1];
		invfact=new int[n+1];
		int cur=1;
		for(int i=0;i<n+1;i++){
			fact[i]=cur;
			invfact[i]=inv(cur);
			cur=mod((long)cur*(i+1));
		}
	}
	static int inv(int a){
		int pow=MOD-2;
		long sum=1;
		long cur=a;
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
}
//SRM 582 div 1 medium
