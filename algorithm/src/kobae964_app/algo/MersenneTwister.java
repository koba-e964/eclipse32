package kobae964_app.algo;

import java.util.Random;

public class MersenneTwister extends Random{
	private static final long serialVersionUID = -6793576902033925883L;
	@Override
	protected int next(int bits) {
		if(bits>=33 || bits<=0)
			throw new IllegalArgumentException("bits out of [1,32]");
	    long y;
	    final long mag01[]={0x0L, MATRIX_A};
	    /* mag01[x] = x * MATRIX_A  for x=0,1 */

	    if (mti >= SIZE) { /* generate N words at one time */
	        int kk;


	        for (kk=0;kk<SIZE-M;kk++) {
	            y = (vec[kk]&UPPER_MASK)|(vec[kk+1]&LOWER_MASK);
	            vec[kk] = (int) (vec[kk+M] ^ (y >> 1) ^ mag01[(int) (y & 0x1L)]);
	        }
	        for (;kk<SIZE-1;kk++) {
	            y = (vec[kk]&UPPER_MASK)|(vec[kk+1]&LOWER_MASK);
	            vec[kk] = (int) (vec[kk+(M-SIZE)] ^ (y >> 1) ^ mag01[(int) (y & 0x1L)]);
	        }
	        y = (vec[SIZE-1]&UPPER_MASK)|(vec[0]&LOWER_MASK);
	        vec[SIZE-1] = (int) (vec[M-1] ^ (y >> 1) ^ mag01[(int) (y & 0x1L)]);

	        mti = 0;
	    }
	    y = vec[mti++];

	    /* Tempering */
	    y ^= (y >> 11);
	    y ^= (y << 7) & 0x9d2c5680L;
	    y ^= (y << 15) & 0xefc60000L;
	    y ^= (y >> 18);

	    return (int)(y&((1L<<bits)-1));
	}
	public MersenneTwister(long seed)
	{
		super(0);
		vec=new int[SIZE];
		this.initializeBySeed((int) seed);
	}
	@Override
	public synchronized void setSeed(long seed)
	{
		/*do nothing*/
	}
	void initializeBySeed(int seed)
	{
	    vec[0]= (int) seed;
	    for (mti=1; mti<SIZE; mti++) {
	        vec[mti] = 
		    (int) (1812433253L * (vec[mti-1] ^ (vec[mti-1] >> 30)) + mti); 
	    }
		mti=0;
		for(int i=0;i<SIZE*32;i++)
		{
			next(32);
		}
	}
	private int[] vec;
	private int mti;
	private final int SIZE=624;
	private final int M=397;
	private final long MATRIX_A=0x9908b0dfL;   /* constant vector a */
	final long UPPER_MASK=0x80000000L; /* most significant w-r bits */
	final long LOWER_MASK=0x7fffffffL; /* least significant r bits */

}
