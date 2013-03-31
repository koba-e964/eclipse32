public class WordAbbreviation {

	public String[] getAbbreviations(String[] words) {
		int n=words.length;
		boolean[] dec=new boolean[n];
		String[] res=new String[n];
		for(int i=0;i<n;i++){res[i]="";dec[i]=false;}
		int rem=n;
		int cur=0;
		while(rem>0)
		{
			System.out.println("rem="+rem+",cur="+cur);
			for(int i=0;i<n;i++)
			{
				if(!dec[i])
				{
					res[i]+=words[i].charAt(cur);
				}
			}
			for(int i=0;i<n;i++)
			{
				if(dec[i])continue;
				boolean uniq=true;
				for(int j=0;j<n && uniq ;j++)
				{
					
					uniq=i==j ||  !res[i].equals(res[j]);
				}
				dec[i]=uniq;
				rem-=uniq?1:0;
			}
			cur++;
		}
		return res;
	}

}
