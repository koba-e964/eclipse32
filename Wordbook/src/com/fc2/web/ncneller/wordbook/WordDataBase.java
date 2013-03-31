package com.fc2.web.ncneller.wordbook;

import java.util.*;

import java.io.*;

import android.util.Log;


class WordComparator implements java.util.Comparator<WordEntry>
{
	public int compare(WordEntry a,WordEntry b)
	{
		return 0;
	}
}

public class WordDataBase {
	public List<WordEntry> words;
	public static String[] attrib={"word","type","japanese","pronunc","usage"};
	public WordDataBase()
	{
		this.words=new ArrayList<WordEntry>(0x400);
	}
	public WordEntry get(int index)
	{
		if(index<0 && index>=words.size())
		{
			throw new IndexOutOfBoundsException(getClass().getName()+".get(int)");
		}
		return words.get(index);
	}
	public int regist(String filename)
	{
		return regist((filename==null)?(File)null:new File(filename));
	}
	public int regist(Scanner sc)
	{
		int sum=0;
		while(sc.hasNextLine())
		{
			try
			{
				String line=sc.nextLine();
				if(line==null)
				{
					break;
				}
				WordEntry we=new WordEntry();
				String[] split=Parser.split(line);
				int len=Math.min(split.length,attrib.length);
				for(int i=0;i<len;i++)
				{
					we.add(WordDataBase.attrib[i],split[i]);
				}
				for(int i=len;i<attrib.length;i++)
				{
					we.add(WordDataBase.attrib[i],"");
				}
				words.add(we);
				sum++;
			}
			catch(Exception x)
			{
				Log.e(TAG,"Exception "+x);
				return sum;
			}
		}
		return sum;
	}
	public int regist(File file)
	{
		try
		{
			return this.regist(new Scanner(file));
		}
		catch(IOException iox)
		{
			Log.d(TAG,iox.toString());
		}
		return 0;
	}
	public void display()
	{
		for(WordEntry we:words)
		{
			System.out.println(we);
		}
	}
	public int size()
	{
		return words.size();
	}

	static final String TAG=WordDataBase.class.getName();
}
