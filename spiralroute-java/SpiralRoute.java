import java.util.*;
public class SpiralRoute {

	public int[] thronePosition(int width, int length) {
		int x=0,y=0;
		outer:
		while(width>0 && length>0)
		{
			switch(width)
			{
			case 1:
				y+=length-1;
				break outer;
			case 2:
				if(length>=2)
				{
					y+=1;
					break outer;
				}
			}
			switch(length)
			{
			case 1:
				x+=width-1;
				break outer;
			case 2:
				y+=1;
				break outer;
			}
			width-=2;
			length-=2;
			x++;
			y++;
		}
		return new int[]{x,y};
	}

}
//SRM 371 div1 easy
