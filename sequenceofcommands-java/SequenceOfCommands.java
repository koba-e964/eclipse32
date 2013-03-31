import java.util.*;
public class SequenceOfCommands {

	public String whatHappens(String[] commands) {
		int x=0,y=0,dir=0;
		for(int i=0;i<4;i++)
		{
			for(String cmd:commands)
			{
				for(char ch:cmd.toCharArray())
				{
					switch(ch)
					{
					case 'L':
						dir+=1;
						dir%=4;
						break;
					case 'R':
						dir+=3;
						dir%=4;
						break;
					case 'S':
						switch(dir)
						{
						case 0:
							x++;
							break;
						case 1:
							y++;
							break;
						case 2:
							x--;
							break;
						case 3:
							y--;
							break;
						default:
							throw new AssertionError();	
						}
					}
				}
			}
		}
		return x==0 && y== 0 ? "bounded":"unbounded";
	}

}
//SRM 473 div2 medium