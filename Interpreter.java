import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interpreter {
	private static boolean flag = true;

	public static void main(String[] args) throws FileNotFoundException {
		PartList bikeParts = DataBaseHandler.openDatabase();

		while (flag) {
			System.out.println("Enter your command choice for the parts displayed, or enter 0 to display your choices again: \n");
			Scanner userIn = new Scanner(System.in);
			int n = userIn.nextInt();
			if (n == 1) { // read
				Scanner in = new Scanner(System.in);
				System.out.println("please enter a filename to read from: ");
				// Scanner in = new Scanner(new File("warehouseDB.txt"));

			}

			else if (n == 2) { // enter
				Scanner in = new Scanner(System.in);
				System.out.println("please enter your part name: ");
				String name = in.nextLine();
				System.out.println("please enter your part number: ");
				int num = Integer.parseInt(in.nextLine());
				System.out.println("please enter your part list Price: ");
				Double list = Double.parseDouble(in.nextLine());
				System.out.println("please enter your part sales Price: ");
				Double sales = Double.parseDouble(in.nextLine());
				System.out.println("Is this part on sale?: ");
				Boolean onSale = Boolean.parseBoolean(in.nextLine());
				System.out.println("please enter the quantity of this part: ");
				int count = Integer.parseInt(in.nextLine());
				for (int i = 0; i < bikeParts.getArrSize(); i++) {
					if (num == PartList.partArray.get(i).getPartNumber()) {
						PartList.partArray.get(i).setQuantity(PartList.partArray.get(i).getQuan() + count);
						if (onSale != PartList.partArray.get(i).isOnSale()) {
							PartList.partArray.get(i).setOnSale(onSale);
						}
					} else {
						Part1 np = new Part1(name, num, list, sales, onSale, count);
					}
				}
			}

			else if (n == 3) { // sell
				boolean sentinal = true;
				Scanner in = new Scanner(System.in);
				System.out.println("Would you like to enter this part by name or number?");
				System.out.println("1. by name");
				System.out.println("2. by number");
				int pick = in.nextInt();
				if (pick == 1) {
					System.out.println("what is the exact name of this part?: ");
					String name = in.nextLine();
					while (sentinal) {
						for (int i = 0; i < bikeParts.getArrSize(); i++) {
							if (name == PartList.partArray.get(i).getPartName()) {
								System.out.println("there are " + PartList.partArray.get(i).getQuan()+ " left in stock. how many would you like to sell? :");
								int count = in.nextInt();
								if (PartList.partArray.get(i).getQuan() - count >= 0) {
									PartList.partArray.get(i).setQuantity(PartList.partArray.get(i).getQuan() - count);
									sentinal = false;
								} else {
									System.out.println("please enter a quantity less than or equal to our current stock of this part: ");
								}
							} else {
								System.out.println("there is no part with that name in the intentory");
								sentinal = true;
							}
						}
					}
				}
				if (pick == 2) {
					System.out.println("what is the exact part number for this part?: ");
					int num = in.nextInt();
					
						for (int i = 0; i < bikeParts.getArrSize(); i++) {
							while (sentinal) {
							if (num == PartList.partArray.get(i).getPartNumber()) {
								System.out.println("there are " + PartList.partArray.get(i).getQuan()+ " left in stock. how many would you like to sell?: ");
								int count = in.nextInt();
								if (PartList.partArray.get(i).getQuan() - count >= 0) {
									PartList.partArray.get(i).setQuantity(PartList.partArray.get(i).getQuan() - count);
									sentinal = false;
								} else {
									System.out.println("please enter a quantity less than or equal to our current stock of this part: ");
								}
							}
							else {
								System.out.println("there is no part with that part number in the intentory");
								sentinal = true;
							}
						}
					}
				}

			}

			else if (n == 4) { // display
				System.out.println(bikeParts.toString());
			}

			else if (n == 5) { // sortname
				bikeParts.sortByName();
				for (int i = 0; i < bikeParts.getArrSize(); i++) {
					System.out.println(bikeParts.get(i));

				}
			}

			else if (n == 6) { // sortNum
				bikeParts.sortByNumber();
				for (int i = 0; i < bikeParts.getArrSize(); i++) {
					System.out.println(bikeParts.get(i));

				}
			}

			else if (n == 7) {
				flag = false;
				System.out.println("thank you for using this program!");
				System.exit(0);
			}
			else if(n==0) {
				Importer.printHelp();
			}

		}
	}
}