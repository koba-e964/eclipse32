import java.util.*;
public class FIELDDiagrams {

	public long countDiagrams(int n) {
		tbl=new long[n+1][n+1];
		tbl[1][1]=1;
		for(int i=2;i<=n;i++)
		{
			tbl[i][1]=i;
			for(int j=2;j<=i;j++)
			{
				tbl[i][j]=tbl[i][j-1]+tbl[i-1][j];
			}
		}
		long count=0;
		for(int i=1;i<=n;i++)
		{
			count+=tbl[n][i];
		}
		return count;
	}
	long[][] tbl;

}
//SRM401 div1 easy