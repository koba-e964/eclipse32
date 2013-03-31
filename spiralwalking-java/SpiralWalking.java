import java.util.*;
public class SpiralWalking {
	boolean[][] vis;
	public int totalPoints(String[] levelMap) {
		int n=levelMap.length;
		int m=levelMap[0].length();
		vis=new boolean[n][m];
		int rem=n*m;
		int dir=0;
		int x0=0,x1=m-1,y0=0,y1=n-1;
		int sum=0;
		for(String lv:levelMap)
		{
			for(char ch:lv.toCharArray())
			{
				sum+=ch-'0';
			}
		}
		while(x0<=x1 && y0<=y1)
		{
			if(y0==y1)
			{
				break;
			}
			if(x0==x1)
			{
				sum-=levelMap[y0].charAt(x0)-'0';
				break;
			}
			if(y0==y1-1)
			{
				sum-=levelMap[y0].charAt(x1)-'0';
				sum-=levelMap[y1].charAt(x1)-'0';
				break;
			}
			if(x0==x1-1)
			{
				sum+=levelMap[y0+1].charAt(x0)-'0';
			}
			sum-=levelMap[y0].charAt(x1)-'0';
			sum-=levelMap[y1].charAt(x1)-'0';
			sum-=levelMap[y1].charAt(x0)-'0';
			sum-=levelMap[y0+1].charAt(x0)-'0';
			x0++;x1--;y0++;y1--;
		}
		return sum;
	}

}
//SRM 407 div 2  easy