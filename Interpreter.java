import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interpreter {

	public static void main(String[] args) throws FileNotFoundException {
		PartList bikeParts = DataBaseHandler.openDatabase();		
		
		//System.out.println(Importer.printHelp());
		System.out.println("Enter your command choice for the parts displayed: \n");
		Scanner userIn = new Scanner(System.in);
		int n = userIn.nextInt();
		if (n == 1) {		//read
			System.out.print(bikeParts.toString());
		} 
		
		else if (n == 2) {		//enter

		}
		
		else if (n == 3) {		//sell

		}
		
		else if (n == 4) {		//display
			
		}
		
		else if (n == 5) {		//sortname
			PartList.sortByName();

		}
		
		else if (n == 6) {		//sortNum

		}
		
		else if (n == 7) {
			System.out.println("thank you for using this program!");
			System.exit(0);
		}
	}

}