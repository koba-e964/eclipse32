package kobae964_app.algo;

import java.util.Arrays;

public final class Prim {
	int n;
	int edges[][];
	int[] l;
	int[] label;
	boolean[] vec;
	final int INF=0x3fffffff;
	/**
	 * 
	 * @param n |V|
	 * @param einfo
	 */
	Prim(int n,int[][] einfo){
		this.n=n;
		edges=new int[n][n];
		l=new int[n];
		label=new int[n];
		vec=new boolean[n];
		for(int[] row:edges)
			Arrays.fill(row, INF);
		for(int[] e:einfo){
			edges[e[0]][e[1]]=edges[e[1]][e[0]]=e[2];
		}
	}
	int[][] solve(int start){
		Arrays.fill(l,INF);
		Arrays.fill(label, -1);
		Arrays.fill(vec,false);
		l[start]=0;
		int ui=start;
		vec[ui]=true;
		for(int i=0;i<n-1;i++){
			for(int v=0;v<n;v++){
				if(vec[v])continue;
				if(l[v]>edges[ui][v]){
					l[v]=edges[ui][v];
					label[v]=ui;
				}
			}
			int minv=-1;
			for(int v=0;v<n;v++){
				if(vec[v])continue;
				minv=minv==-1?v:
					l[minv]>l[v]?v:minv;
			}
			if(minv==-1){
				throw new RuntimeException("No appropriate edges");
			}
			ui=minv;
			vec[ui]=true;
		}
		int[][] ret=new int[n-1][];
		int cnt=0;
		for(int i=0;i<n;i++){
			if(label[i]==-1)continue;
			ret[cnt]=new int[2];
			ret[cnt][0]=label[i];
			ret[cnt][1]=i;
			cnt++;
		}
		if(cnt!=n-1){
			throw new RuntimeException("Error: too few edges:"+cnt);
		}
		print("l",l);
		print("label",label);
		return ret;
	}
	private static void print(String msg,int[] ar){
		System.out.print(msg+":");
		for(int a:ar){
			System.out.print(" "+a);
		}
		System.out.println();
	}
}
