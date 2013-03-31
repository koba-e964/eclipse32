package com.fc2.web.ncneller.wordbook.cui;

import java.io.*;

import com.fc2.web.ncneller.wordbook.*;

public class CUIExec extends Object{

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Wordbook Test\nClass:"+CUIExec.class.getName());
		WordDataBase database=new WordDataBase();
		database.regist(new File("assets/words.txt"));
		database.display();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			Comp[] cs=State.current().getScreenInfo();	
			for(Comp c : cs)
			{
				System.out.print(c);
			}
			System.out.println();
			String line=br.readLine();
			if(line.equals(""))
			{
				break;
			}
			String[] split=Parser.split(line);
			if(split.length==0)
			{
				continue;
			}
			try
			{
				int num=Integer.parseInt(split[0]);
				String[] rest=new String[split.length-1];
				System.arraycopy(split, 1, rest, 0, rest.length);
				State.current().command(num, rest);
			}
			catch(NumberFormatException nfe)
			{
				nfe.printStackTrace();
			}
		}
	}

}
