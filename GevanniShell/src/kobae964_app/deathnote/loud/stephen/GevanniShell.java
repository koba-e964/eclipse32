package kobae964_app.deathnote.loud.stephen;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GevanniShell {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		File pwd=new File(".").getCanonicalFile();
		while(scan.hasNextLine()){
			System.out.println(">");
			String line=scan.nextLine();
			String[] parse=line.split("\\s");
			if(parse[0].equals("exit"))
			{
				break;
			}
			if(parse[0].equals("sl"))
			{
				Gevanni.main(new String[0]);
			}
			if(parse[0].equals("cd"))
			{
				if(parse.length==0)
				{
					System.err.println("err:cd ??");
					continue;
				}
				pwd=new File(pwd,parse[1]);
			}
		}

	}

}
