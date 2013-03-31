package com.fc2.web.ncneller.wordbook;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

	static Pattern whitespace=Pattern.compile("\\s");
	public static String[] split(String line)
	{
		String[] split0=whitespace.split(line);
		List<String> split1=new ArrayList<String>(split0.length);
		for(String tmp:split0)
		{
			if(tmp.length()!=0)
			{
				split1.add(tmp);
			}
		}
		return split1.toArray(new String[0]);
	}
}
