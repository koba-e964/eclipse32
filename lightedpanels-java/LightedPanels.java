//400 div2 hard
public class LightedPanels {

	private int m;
	private int n;
	long bits(int l)
	{
		if(l<=63)return (1L<<l)-1;
		return -1;
	}
	public int minTouch(String[] board) {
		m = board.length;
		n = board[0].length();
		long ibo=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i].charAt(j)=='.')ibo|=1L<<(i*n+j);
			}
		}
		long[] mat=new long[m*n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				mat[i*n+j]=set(mat[i*n+j],i-1,j-1);
				mat[i*n+j]=set(mat[i*n+j],i-1,j);
				mat[i*n+j]=set(mat[i*n+j],i-1,j+1);

				mat[i*n+j]=set(mat[i*n+j],i,j-1);
				mat[i*n+j]=set(mat[i*n+j],i,j);
				mat[i*n+j]=set(mat[i*n+j],i,j+1);

				mat[i*n+j]=set(mat[i*n+j],i+1,j-1);
				mat[i*n+j]=set(mat[i*n+j],i+1,j);
				mat[i*n+j]=set(mat[i*n+j],i+1,j+1);
			}
		}
		System.out.println("\ncondition:");
		dump(ibo,mat);
		//gauss-elim
		int cur=0;
		long free=bits(m*n);
		for(int k=0;k<m*n;k++)
		{
			//find 1
			f1l:
			for(int i=cur;i<m*n;i++)
			{
				if(((mat[i]>>>k)&1L)!=0)
				{
					swap(mat,cur,i);
					long mask=(1L<<cur)^(1L<<i);
					if((ibo&mask)==0 || (ibo&mask)==mask)
					{
						//
					}
					else
					{
						ibo^=mask;
					}
					break f1l;
				}
			}
			if((mat[cur]&(1L<<k))==0L)
			{
				continue;
			}
			for(int i=0;i<m*n;i++)
			{
				if(i!=cur && (mat[i]&(1L<<k))!=0)
				{
					mat[i]^=mat[cur];
					ibo^=((ibo>>cur)&1L)<<i;
				}
			}
			free^=1L<<k;
			cur++;
		}
		System.out.println("result:");
		dump(ibo, mat);
		System.out.printf("free=%x\n",free);
		for(int i=0;i<m*n;++i)
		{
			if((ibo&(1L<<i))!=0 && mat[i]==0)
				return -1;
		}
		long[] freevec=new long[m*n-cur];
		for(int i=0,t=0;i<m*n;i++)
		{
			if((free&(1L<<i))!=0)
			{
				//build freevec[t]
				for(int j=0;j<m*n;j++)
				{
					freevec[t]|=((mat[j]>>>i)&1L)<<j;
				}
				t++;
			}
		}
		for(long f:freevec)
		{
			System.out.printf("f:%x\n",f);
		}

		return search(ibo,freevec);
	}
	private void dump(long ibo, long[] mat) {
		System.out.printf("\nibo=%x\n",ibo);
		for(int i=0;i<n*m;i++)
		{
			System.out.printf("mat[%d]=%x\n",i, mat[i]);
		}
	}
	int search(long ibo,long[] freevec)
	{
		dp(ibo,freevec,0,0);
		return res;
	}
	int res=100;
	void dp(long ibo,long freevec[],int fs,int start)
	{
		if(fs>=res)return;
		if(start>freevec.length)return;
		int count=fs;
		for(int i=0;i<m*n;i++)
		{
			count+=(ibo>>>i)&1L;
			//if(count>=res)break;
		}
		if(res>count)res=count;
		if(start<freevec.length)
		{
			dp(ibo,freevec,fs,start+1);
			dp(ibo^freevec[start],freevec,fs+1,start+1);
		}
		return;

	}
	long next(long v,long free)
	{
		long comp=v^free;
		long min=comp&(-comp);
		return (v&(min-1))|min;
	}
	void swap(long[] ary,int i,int j)
	{
		long tmp=ary[i];
		ary[i]=ary[j];
		ary[j]=tmp;
	}
	long set(long val,int x,int y)
	{
		if(x<0 || y<0 || x>=m || y>=n)return val;
		return val^(1L<<(x*n+y));
	}
}
