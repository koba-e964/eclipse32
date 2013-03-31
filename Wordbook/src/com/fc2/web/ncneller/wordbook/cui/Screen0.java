package com.fc2.web.ncneller.wordbook.cui;

public class Screen0 extends Screen {
	But learning=new But("äwèK", this);
	But quit=new But("Ç‚ÇﬂÇÈ",this);
	Comp[] comps=new Comp[]{learning,quit};
	@Override
	public Comp[] getScreenInfo() {
		return comps;
	}

	@Override
	public void action(Comp c) {
		if(c==learning)
		{
			State.setScreen(1);
			return;
		}
		if(c==quit)
		{
			System.exit(0);
			return;
		}
	}

	@Override
	public void command(int num, String[] args) {
		try
		{
			comps[num].action(args);
		}
		catch(ArrayIndexOutOfBoundsException aioobx)
		{
			aioobx.printStackTrace();
		}
	}

}
