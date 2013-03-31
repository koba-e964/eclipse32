public class GrabbingTaxi {

	public int minTime(int[] tXs, int[] tYs, int gX, int gY, int walkTime, int taxiTime) {
		int min=Integer.MAX_VALUE;
		int n=tXs.length;
		for(int i=0;i<=n;i++)
		{
			int x=i==n?gX:tXs[i],y=i==n?gY:tYs[i];
			int res=time(x,y,gX,gY,walkTime,taxiTime);
			if(min>res)min=res;
		}
		return min;
	}
	int time(int tx,int ty,int gx,int gy,int w,int t)
	{
		return (Math.abs(tx)+Math.abs(ty))*w+(Math.abs(gx-tx)+Math.abs(gy-ty))*t;
	}
}
