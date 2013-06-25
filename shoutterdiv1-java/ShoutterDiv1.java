import java.util.*;
public class ShoutterDiv1 {
	String concat(String[] ss)
	{
		StringBuilder sb=new StringBuilder();
		for(String s:ss)sb.append(s);
		return sb.toString();
	}
	int n;
	int s[];
	int t[];
	boolean fr[][];
	public int count(String[] s1000, String[] s100, String[] s10, String[] s1, String[] t1000, String[] t100, String[] t10, String[] t1) {
		String S1000=concat(s1000);
		String S100=concat(s100);
		String S10=concat(s10);
		String S1=concat(s1);
		String T1000=concat(t1000);
		String T100=concat(t100);
		String T10=concat(t10);
		String T1=concat(t1);
		n=S1000.length();
		s=new int[n];
		t=new int[n];
		for(int i=0;i<n;i++)
		{
			s[i]=Integer.parseInt(S1000.charAt(i)+""+S100.charAt(i)+S10.charAt(i)+S1.charAt(i));
			t[i]=Integer.parseInt(T1000.charAt(i)+""+T100.charAt(i)+T10.charAt(i)+T1.charAt(i));
		}
		fr=new boolean[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				fr[i][j]=fr[j][i]=meets(s[i],t[i],s[j],t[j]);
			}
		}
		if(true)
		{
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
				{
					System.out.print((fr[i][j]?1:0)+" ");
				}
				System.out.println();
			}
		}
		System.out.println();
		return 0;
	}
	boolean meets(int s1,int t1,int s2,int t2)
	{
		return !(t1<s2)&&!(s1>t2);
	}

}
//SRM 
