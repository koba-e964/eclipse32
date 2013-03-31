import java.util.*;
public class HappyCells {
	String[] grid;
	public int[] getHappy(String[] grid) {
		this.grid=grid;
		int[] h=new int[3];
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length();j++)
			{
				int res=happy(i,j);
				System.out.printf("(%d,%d)->%d\n", i, j, res);
				if(res==0)continue;
				h[res-1]++;
			}
		}
		return h;
	}
	int happy(int x,int y)
	{
		if(grid[x].charAt(y)=='X')return 0;
		int oo=0,of=0,d_o=0,d_f=0;
		int[] res;
		res=getVal(x-1,y-1);
		d_o+=res[0];d_f+=res[1];
		res=getVal(x-1,y+1);
		d_o+=res[0];d_f+=res[1];
		res=getVal(x+1,y-1);
		d_o+=res[0];d_f+=res[1];
		res=getVal(x+1,y+1);
		d_o+=res[0];d_f+=res[1];

		res=getVal(x,y-1);
		oo+=res[0];of+=res[1];
		res=getVal(x,y+1);
		oo+=res[0];of+=res[1];
		res=getVal(x-1,y);
		oo+=res[0];of+=res[1];
		res=getVal(x+1,y);
		oo+=res[0];of+=res[1];
		if(oo==of && d_o==d_f)return 1;
		if(oo==of && d_o!=d_f)return 2;
		if(oo!=of && d_o==d_f)return 3;
		return 0;
	}
	int[] getVal(int x,int y)//occupied -> 1/1
	{
		if(x<0 || x>=grid.length)return new int[]{0,0};
		if(y<0 || y>=grid[0].length())return new int[]{0,0};
		return grid[x].charAt(y)=='X'?new int[]{1,1}:new int[]{0,1};
	}
}
//SRM406 div2 easy