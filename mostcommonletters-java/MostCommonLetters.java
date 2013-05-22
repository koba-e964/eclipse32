import java.util.*;
public class MostCommonLetters {

	public String listMostCommon(String[] text) {
		int freq[]=new int[27];
		for(String s:text)
		{
			for(char ch:s.toCharArray())
			{
				if(ch==' '){}
				else
				{
					freq[ch-'a'+1]++;
				}
			}
		}
		int max=0;
		for(final int f:freq)
		{
			if(max<f)max=f;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<freq.length;i++)
		{
			if(max==freq[i])
				sb.append((char)('a'+i-1));
		}
		return sb.toString();
	}

}
//SRM