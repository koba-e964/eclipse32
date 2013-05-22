import java.util.*;
public class Subway2 {

	public double minTime(int length, int maxAcceleration, int maxVelocity) {
		double tmp=Math.sqrt(length*maxAcceleration);
		if(tmp>maxVelocity)
		{
			double t=(maxVelocity/(double)maxAcceleration);
			return 2*(t+(length/2.0-0.5*maxAcceleration*t*t)/maxVelocity);
		}
		return tmp/maxAcceleration*2;
	}

}
//SRM413 div2 easy