package kobae964_app.algo;

import static org.junit.Assert.*;

import java.util.Random;

import kobae964_app.algo.RangeCoder.Frequency;

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
	public void testEncode0() {
		byte[] data={0,1,2,3,4};
		RangeCoder rc=new RangeCoder(new Frequency());
		rc.encode(data);
		byte[] content=rc.getContent();
		for(int i=0;i<content.length;i++)
		{
			System.out.printf("%02x ", content[i]&0xff);
		}
	}

}
