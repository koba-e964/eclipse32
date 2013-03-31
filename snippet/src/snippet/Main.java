package snippet;

public final class Main {
	int Main;
	Main(){Main=0;}
	Main(Main Main){this.Main=Main.Main+1;}
	Main Main()
	{
		return new Main(this);
	}
	static Main Main(Main Main)
	{return new Main();}
	public static void main(String... args)
	{
		Main Main=Main(null);
		Main=Main.Main();
		System.exit(Main.Main);
	}
}
