import java.io.File;
import java.util.Scanner;
import java.util.Properties;

public class jPokedex
{
	public static String cResetBg = "\u001B[40m";
	public static String cBlueBg = "\u001B[44m";
	public static String cReset = "\u001B[0m";
	public static String cWhite = "\u001B[37m";
	public static String clearScr = "\033[H\033[2J";

	
	public static void main(String[] args) throws Exception
	{
		Scanner waitingInput = new Scanner(System.in);

		System.out.println(clearScr);
		System.out.flush();
		System.out.println(cBlueBg + "Sort by Pokemon's Number" + cResetBg);
		System.out.println("Sort by Pokemon's Name");
		System.out.println("Sort by Pokemon's Type1");
		System.out.println("Sort by Pokemon's Type2");
		System.out.println("Sort by Highest Stat");
		System.out.println("Sort by  Species");
		System.out.println("Sort by Height");
		System.out.println("Sort by Weight\n");

		System.out.println("Use arrow keys to make selection and press Enter to confirm");
		String menuInput = waitingInput.next();
		System.out.println(waitingInput.hasNext());
		
	}
}

