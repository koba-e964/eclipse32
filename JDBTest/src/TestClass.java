import java.util.Scanner;


public class TestClass {
	public static void main(String[] args){
		Object obj;
		for(int i=0;i<262144;i++){
			obj=new Object(){int x,y;};
		}
		new Scanner(System.in).nextLine();
	}
}
