public class DreamingAboutCarrots {

	public int carrotsBetweenCarrots(int x1, int y1, int x2, int y2) {
		return gcd(Math.abs(x1-x2),Math.abs(y1-y2))-1;
	}
	int gcd(int x,int y)
	{
		while(y!=0)
		{
			int r=x%y;
			x=y;
			y=r;
		}
		return x;
	}
}
//srm 401 div 2 easy