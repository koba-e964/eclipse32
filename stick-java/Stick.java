import java.util.*;
public class Stick {

	public int pieces(int x) {
		return x/64+Integer.bitCount(x%64);
	}

}
//SRM