import java.util.*;
public class TurnOnLamps {

	int[] tree;
	int n;
	long[] pmem;//0...1<<(n-1)
	long path(int x){
		if(x==0)return 0;
		return (1L<<(x-1))|path(tree[x]);
	}
	public int minimize(int[] roads, String initState, String isImportant) {
		n=roads.length+1;
		tree=new int[n];
		tree[0]=-1;
		for(int i=1;i<n;i++){
			tree[i]=roads[i-1];
		}
		pmem=new long[n];
		for(int i=0;i<n;i++){
			pmem[i]=path(i);
		}
		long mask=0;
		for(int i=0;i<n-1;i++){
			if(isImportant.charAt(i)=='1')
				mask|=1L<<i;
		}
		long goal=mask;
		for(int i=0;i<n-1;i++)
		{
			if(initState.charAt(i)=='1')
				goal^=1L<<i;
		}
		System.out.printf("%x,goal=%x\n",mask,goal);
		for(int i=0;i<n;i++){
			pmem[i]&=mask;
		}
		//ge
		long[] inv=new long[n];
		for(int i=0;i<n;i++){
			inv[i]=1L<<i;
		}
		int r=0;
		for(int k=0;k<n;k++){
			boolean found=false;
			for(int p=r;p<n;p++){
				if((pmem[p]&(1L<<k))!=0){
					found=true;
					swap(pmem,r,p);
					swap(inv,r,p);
					break;
				}
			}
			if(!found)continue;
			for(int q=0;q<n;q++){
				if(q==r)continue;
				if((pmem[q]&(1L<<k))!=0)
				{
					pmem[q]^=pmem[r];
					inv[q]^=inv[r];
				}
			}
			r++;
		}
		for(int i=0;i<n;i++)
		{
			System.out.printf("pmem[%d]=%x, inv[%d]=%x\n",i,pmem[i],i,inv[i]);
		}
		long sol=0;
		for(int i=0;i<n;i++){
			if((goal&pmem[i])!=0){
				goal^=pmem[i];
				sol^=inv[i];
			}
		}
		return (Long.bitCount(sol)+1)/2;
	}
	void swap(long [] t,int x,int y){
		long tmp=t[x];
		t[x]=t[y];
		t[y]=tmp;
	}
}
//SRM 
