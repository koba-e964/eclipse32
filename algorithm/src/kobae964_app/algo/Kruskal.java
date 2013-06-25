package kobae964_app.algo;

import java.util.*;

public class Kruskal {
	private int n;
	private List<Edge> edges;
	/**
	 * 
	 * @param n |V|
	 * @param einfo
	 */
	Kruskal(int n,int einfo[][]){
		this.n=n;
		edges=new ArrayList<Kruskal.Edge>();
		for(int[] e:einfo){
			Edge edge=new Edge(e[0],e[1],e[2]);
			edges.add(edge);
		}
		par=new int[n];
		Collections.sort(edges);
	}
	int[][] solve(){
		int[][] ret=new int[n-1][];
		int cnt=0;//index of ret
		initUF();
		for(Edge e:edges){
			if(cnt>=n-1){
				break;
			}
			if(root(e.x)==root(e.y)){
				continue;
			}
			unite(e.x,e.y);
			ret[cnt]=new int[]{e.x,e.y};
			cnt++;
		}
		if(cnt!=n-1){
			throw new RuntimeException("Error: Vertices are not connected");
		}
		return ret;
	}
	int par[];
	void initUF(){
		for(int i=0;i<n;i++){
			par[i]=i;
		}
	}
	int root(int x){
		return par[x]==x?x:(par[x]=root(par[x]));
	}
	void unite(int x,int y){
		par[root(x)]=root(y);
	}
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int weight;
		Edge(int x,int y,int w){
			this.x=x;
			this.y=y;
			this.weight=w;
		}
		@Override
		public int compareTo(Edge o) {
			return weight-o.weight;
		}
		
	}
}
