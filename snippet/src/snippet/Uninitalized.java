package snippet;

public class Uninitalized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] array=new Object[16];
		System.out.println(array[0]);
		Object uninit;
		if(t())
		{
			uninit=null;
		}
		else
			return;
		System.out.println(uninit);

	}
	static boolean t(){return false;}
	

}
