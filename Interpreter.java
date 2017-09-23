import java.io.*;
import java.util.*;

public class Interpreter {
	private static boolean flag = true;
	private static String help = "Please select from the following menu:\n1. Read: read an inventory delivery file\n2.Enter: Enter a part\n3. Sell: Sell a part\n4. Display: Display the current inventory\n5. SortName: Sort all parts by the part name\n6. SortNumber: Sort all parts by number\n7. Quit: close the program\n";

	public static void main(String[] args) throws FileNotFoundException {
		PartList bikeParts = DataBaseHandler.openDatabase();

		while (flag) {
			System.out.println(help);
			System.out.println("Enter your command choice for the parts displayed: \n");
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
				int num = in.nextInt();
				System.out.println("please enter your part list Price: ");
				Double list = in.nextDouble();
				System.out.println("please enter your part sales Price: ");
				Double sales = in.nextDouble();
				System.out.println("true or fals, this part is on sale?: ");
				Boolean onSale = in.nextBoolean();
				System.out.println("please enter the quantity of this part: ");
				int count = in.nextInt();
				boolean match = true;
				while (match) {
					for (int i = 0; i < bikeParts.getArrSize(); i++) {
						if (num == PartList.partArray.get(i).getPartNumber()) {
							PartList.partArray.get(i).setQuantity(PartList.partArray.get(i).getQuan() + count);
							if (onSale != PartList.partArray.get(i).isOnSale()) {
								PartList.partArray.get(i).setOnSale(onSale);
							}
							match = false;

						}
					}
					if (match) {
						Part1 np = new Part1(name, num, list, sales, onSale, count);
						bikeParts.add(np);
						match=false;
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
					while (sentinal) {
						System.out.println("what is the exact name of this part?: ");
						String name = in.nextLine();
						for (int i = 0; i < bikeParts.getArrSize(); i++) {
							if (name == PartList.partArray.get(i).getPartName()) {
								i = bikeParts.getArrSize();
								System.out.println("there are " + PartList.partArray.get(i).getQuan()
										+ " left in stock. how many would you like to sell? :");
								int count = in.nextInt();
								if (PartList.partArray.get(i).getQuan() - count >= 0) {
									PartList.partArray.get(i).setQuantity(PartList.partArray.get(i).getQuan() - count);
									i = bikeParts.getArrSize();
									sentinal = false;

								} else {
									i = bikeParts.getArrSize();
									System.out.println("There are not that many available to sell.");
									sentinal = false;
								}
							} else {
								if (i == bikeParts.getArrSize()) {
									System.out.println("there is no part with that part number in the intentory");
								}
							}
						}
						sentinal = false;
					}
				}
				if (pick == 2) {
					while (sentinal) {
						System.out.println("what is the exact part number for this part?: ");
						int num = in.nextInt();
						for (int i = 0; i < bikeParts.getArrSize(); i++) {
							if (num == PartList.partArray.get(i).getPartNumber()) {
								System.out.println("there are " + PartList.partArray.get(i).getQuan()
										+ " left in stock. how many would you like to sell?: ");
								int count = in.nextInt();
								if (PartList.partArray.get(i).getQuan() - count >= 0) {
									PartList.partArray.get(i).setQuantity(PartList.partArray.get(i).getQuan() - count);
									sentinal = false;
								} else {
									i = bikeParts.getArrSize();
									System.out.println("There are not that many available to sell.");
									sentinal = false;
								}
							} else {
								if (i == bikeParts.getArrSize()) {
									System.out.println("there is no part with that part number in the intentory");
								}
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
				System.out.println("thank you for using this program!");
				try {
					PrintWriter pw = new PrintWriter("warehouseDB.txt", "UTF-8");
					int lineCount = bikeParts.getArrSize();
					pw.println(lineCount);
					for (int i = 0; i < bikeParts.getArrSize(); i++) {
						pw.println(bikeParts.get(i).toString());
					}
					pw.close();
					flag = false;
					System.exit(0);
				} catch (IOException e) {
					System.out.print("could not write to file!");
					e.printStackTrace();
				}

			}

		}
	}
}