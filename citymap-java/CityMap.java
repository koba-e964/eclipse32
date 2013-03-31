import java.util.*;
public class CityMap {
	int h,w;
	public String getLegend(String[] cityMap, int[] POIs) {
		int[] app=new int[26];
		h=cityMap.length;
		w=cityMap[0].length();
		for(String str:cityMap)
		{
			for(char ch:str.toCharArray())
			{
				if(ch!='.')
				{
					app[ch-'A']++;
				}
			}
		}
		int n=POIs.length;
		char[] ret=new char[POIs.length];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<26;j++)
			{
				if(app[j]==POIs[i])
				{
					ret[i]=(char)('A'+j);
				}
			}
		}
		return new String(ret);
	}

}
//SRM 574