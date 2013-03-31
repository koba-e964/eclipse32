package kobae964_app.algo;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class RangeCoderTest {
	byte[] content;
	@Before
	public void setUp()
	{
		int n=0x100000;
		content=new byte[n];
		Random rnd=new Random();
		rnd.nextBytes(content);
	}
	@Test
	public void testEncode() {
		fail("Not yet implemented"); // TODO
	}

}
