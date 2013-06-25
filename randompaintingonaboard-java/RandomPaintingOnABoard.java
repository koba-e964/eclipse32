import java.util.*;
public class RandomPaintingOnABoard {
	int n,m;
	int dat[][];
	int sum;
	public double expectedSteps(String[] prob) {
		n=prob.length;
		m=prob[0].length();
		dat=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				dat[i][j]=prob[i].charAt(j)-'0';
			}
		}
		sum=0;
		for(int[] row:dat){
			for(int q:row)sum+=q;
		}
		return sol(0,0);
	}
	double sol(){
		boolean[][] used=new boolean[n][m];
		return -1;
	}
	HashMap<Long, Double> memo=new HashMap<Long, Double>();
	double sol(int ru,int cu){
		long key=(long)ru|((long)cu<<n);
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		int a=0;
		double tot=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++){
				if((ru&(1<<i))!=0&&(cu&(1<<j))!=0)continue;
				double sub=sol(ru|(1<<i),cu|(1<<j));
				tot+=dat[i][j]*sub;
				a+=dat[i][j];
			}
		}
		if(a==0)return 0;
		double res=tot/a+(double)sum/a;
		memo.put(key, res);
		return res;
	}

}
//SRM 583 hard(950 points)
