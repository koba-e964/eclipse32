import java.util.*;
public class ThreePhotos {

	public int removeCubes(String[] A, String[] B, String[] C) {
		int n=A.length;
		boolean cube[]=new boolean[n*n*n];
		for(int x=0;x<n;x++)
		{
			for(int y=0;y<n;y++)
			{
				if(A[x].charAt(y)!='Y')
				{
					for(int z=0;z<n;z++)
						cube[x+y*n+z*n*n]=true;//removed
				}
			}
		}
		for(int x=0;x<n;x++)
		{
			for(int z=0;z<n;z++)
			{
				if(B[x].charAt(z)!='Y')
				{
					for(int y=0;y<n;y++)
						cube[x+y*n+z*n*n]=true;//removed
				}
			}
		}
		for(int y=0;y<n;y++)
		{
			for(int z=0;z<n;z++)
			{
				if(C[y].charAt(z)!='Y')
				{
					for(int x=0;x<n;x++)
						cube[x+y*n+z*n*n]=true;//removed
				}
			}
		}

		for(int x=0;x<n;x++)
		{
			for(int y=0;y<n;y++)
			{
				if(A[x].charAt(y)=='Y')
				{
					boolean rem=false;
					for(int z=0;z<n&&!rem;z++)
						rem=!cube[x+y*n+z*n*n];//removed
					if(!rem)
					{
						return -1;
					}
				}
			}
		}
		for(int x=0;x<n;x++)
		{
			for(int z=0;z<n;z++)
			{
				if(B[x].charAt(z)=='Y')
				{
					boolean rem=false;
					for(int y=0;y<n&&!rem;y++)
						rem=!cube[x+y*n+z*n*n];//removed
					if(!rem)
					{
						return -1;
					}
				}
			}
		}
		for(int y=0;y<n;y++)
		{
			for(int z=0;z<n;z++)
			{
				if(C[y].charAt(z)=='Y')
				{
					boolean rem=false;
					for(int x=0;x<n&&!rem;x++)
						rem=!cube[x+y*n+z*n*n];//removed
					if(!rem)
					{
						return -1;
					}
				}
			}
		}
		int count=0;
		for(boolean b:cube)
		{
			count+=b?1:0;
		}
		return count;
	}

}
//SRM