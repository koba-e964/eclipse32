import java.util.*;
public class NewArenaPassword {
	int n;
	String old;
	int k;
	public int minChange(String old, int K) {
		k=K;
		this.old=old;
		n=old.length();
		int count=0;
		for(int i=0;i<n-k;i++)
		{
			count+=change(i);
		}
		return count;
		
	}
	int change(int ind)
	{
		if(n==k)return 0;
		int total=0;
		int[] freq=new int[26];
		for(int i=ind;i<n;i+=n-k)
		{
			total++;
			freq[old.charAt(i)-'a']++;
		}
		int max=0;
		for(int i:freq)
		{
			if(max<i)max=i;
		}
		return total-max;
	}
}
//SRM 572 div1 easy