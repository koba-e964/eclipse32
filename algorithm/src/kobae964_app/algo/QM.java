package kobae964_app.algo;

import java.util.Arrays;

/**
 * Quine-McCluskey algorithm
 * @author koba-e964
 *
 */
public class QM {
	/**
	 * data[i][0]:pattern (bitwise)
	 * data[i][1]:value(1->True, 0->False, otherwise->Don't care)
	 * @param data constraint
	 */
	int[] stat;
	public QM(int n,int[][] data){
		if(n>=16)
			throw new RuntimeException("Too large n="+n);
		stat=new int[1<<n];
		Arrays.fill(stat, 2);
		for(int[] entry:data){
			int x=entry[0];
			stat[x]=entry[1]!=0&&entry[1]!=1?2:entry[1];
		}
	}
}
