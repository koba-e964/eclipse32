package snippet.derived;

import snippet.Base;

public class Derived extends Base {
	void another()
	{
		Base b=new Base();
		b.method();
		((Derived)b).method();
	}
	@Override
	public void method()
	{
		super.method();
		((Base)this).method();
	}
}
