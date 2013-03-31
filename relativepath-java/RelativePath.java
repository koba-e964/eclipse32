import java.util.*;
public class RelativePath {

	public String makeRelative(String path, String current) {
		String[] sp=parse(current);
		String[] pt=parse(path);
		int ind=0;
		for(;ind<sp.length && ind<pt.length;)
		{
			if(!sp[ind].equals(pt[ind]))break;
			ind++;
		}
		System.out.println("path:");
		for(String  s:pt)
		{
			System.out.print(s+",");
		}
		System.out.println("\ncd");
		for(String s:sp)
		{
			System.out.print(s+",");
		}
		System.out.println();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<sp.length-ind;i++)
		{
			sb.append("../");
		}
		for(int i=ind;i<pt.length;i++)
		{
			sb.append(pt[i]);
			if(i<=pt.length-2)
				sb.append('/');
		}
		return sb.toString();
	}
	static String[] parse(String path)
	{
		String[] sp=path.split("/");
		if(sp.length==0)return new String[]{""};
		return sp;
	}

}
//SRM405 div2 medium