import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interpreter {

	public static void main(String[] args) throws FileNotFoundException {
		PartList bikeParts = DataBaseHandler.openDatabase();
		
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");

		System.out.println("Enter your command choice for the parts displayed: \n");
		Scanner userIn = new Scanner(System.in);
		int n = userIn.nextInt();
		if (n == 1) {

		} else if (n == 2) {

		} 
		else if (n == 3) {

		} 
		else if (n == 4) {

		} 
		else if (n == 5) {

		} 
		else if (n == 6) {

		} 
		else if (n == 7) {
			System.out.println("thank you for using this program!");
			System.exit(0);
		}
	}

}