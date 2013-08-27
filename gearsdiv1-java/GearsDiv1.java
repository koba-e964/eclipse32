import java.util.*;
public class GearsDiv1 {
	long g[];
	int n;
	char[] col;
	public int getmin(String color, String[] graph) {
		n=color.length();
		g=new long[n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				g[i]|=graph[i].charAt(j)=='Y'?(1L<<j):0;
			}
		}
		col=color.toCharArray();
		rec((1L<<n)-1,0);
		return n-maxv;
	}
	int maxv=-1;
	int sc=0;
	void rec(long bits,int start){
		//System.out.printf("%d:bits=%x\n",sc++,bits);
		if(Long.bitCount(bits)<=maxv){
			return;
		}
		if(hasOddPath(bits)){
			if(Long.bitCount(bits)==maxv+1){
				return;
			}
			for(int i=start;i<n;i++){
				if((bits&(1L<<i))==0)continue;
				rec(bits&~(1L<<i),i+1);
			}
			return;
		}
		//System.out.printf("ok: bits=%x\n",bits);
		maxv=Long.bitCount(bits);
	}
	boolean hasOddPath(long bits){
		long h[]=new long[n];
		Arrays.fill(h,0L);
		for(int i=0;i<n;i++){
			if((bits&(1L<<i))==0)continue;
			h[i]=g[i]&bits;
		}
		int exp=(n-1)|1;//smallest odd >=n-1
		long[] sum=new long[n];
		for(int i=0;i<n;i++){
			sum[i]=1L<<i;
		}
		long[] cur=h;
		while(exp>0){
			if(exp%2==1){
				sum=matmul(sum, cur);
			}
			cur=matmul(cur,cur);
			exp/=2;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(col[i]==col[j]){
					if((sum[i]&(1L<<j))!=0){
						return true;
					}
				}
			}
		}
		return false;
	}
	long[] matmul(long[] x,long[] y){//n*n
		long res[]=new long[n];
		for(int j=0;j<n;j++){
			long col=0;
			for(int k=0;k<n;k++){
				col|=(y[k]&(1L<<j))!=0?(1L<<k):0;
			}
			for(int i=0;i<n;i++){
				if((x[i]&col)!=0){
					res[i]|=1L<<j;
				}
			}
		}
		return res;
	}
}
//SRM 
