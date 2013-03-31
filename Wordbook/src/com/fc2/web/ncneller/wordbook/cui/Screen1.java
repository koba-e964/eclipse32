package com.fc2.web.ncneller.wordbook.cui;

public class Screen1 extends Screen{
	TextBox tb=new TextBox("Select Number");
	InBox ib=new InBox();
	But ok=new But("OK", this);
	Comp[] list=new Comp[]{tb,ib,ok};
	public Comp[] getScreenInfo()
	{
		return list;
	}
	public void action(Comp c)
	{
		if(c==ok)
		{
			System.out.println("Text="+ib.str+"\n");
			return;
		}
		return;
	}
	public void command(int num,String[] args)
	{
		try
		{
			list[num].action(args);
		}
		catch(ArrayIndexOutOfBoundsException aioobx)
		{
			aioobx.printStackTrace();
		}
	}
}
