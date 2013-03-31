package kobae964_app.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MersenneTwisterTest {

	@Test
	public void testNext() {
		long seed=System.currentTimeMillis();
		MersenneTwister inst=new MersenneTwister(seed);
		int nBuckets=0x80;
		int freq[]=new int[nBuckets];
		int trial=1<<26;
		for(int i=0;i<trial;i++)
		{
			int result=inst.nextInt(nBuckets*10);
			freq[result/10]++;
		}
		for(int i=0;i<nBuckets;i++)
		{
			System.out.println(i+":"+freq[i]);
		}
	}

}
