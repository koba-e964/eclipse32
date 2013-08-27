import java.util.*;
public class Excavations {
	int n;
	int m;
	public long count(int[] kind, int[] depth, int[] found, int K) {
		n=kind.length;
		m=found.length;
		Set<Integer> ds=new HashSet<Integer>();
		for(int d:depth){
			ds.add(d);
		}
		long set=0L;
		for(int f:found){
			set|=1L<<f;
		}
		return 0;
	}
	
}
//SRM 584 div1 medium
