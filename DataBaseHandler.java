import java.util.*;

import java.io.*;

public class DataBaseHandler {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.print(Importer.printHelp());
		Scanner in = new Scanner(new File("C:\\Users\\slstr\\project1CPSC240\\warehouseDB.txt"));
		int lineNum = in.nextInt();
		Part1[] bp = new Part1[lineNum];
		in.nextLine();
		for (int i = 0; i < lineNum; i++) {
			String line = in.nextLine();
			// System.out.println(line);
			String[] elements = line.split(",");
			bp[i] = new Part1(elements[0], Integer.parseInt(elements[1]), Double.parseDouble(elements[2]),
					Double.parseDouble(elements[3]), Boolean.parseBoolean(elements[4]),Integer.parseInt(elements[5]));
			System.out.println(line);
			System.out.println("------------------------------------------------------------------------------");
		}
		System.out.println("Enter your command choice for the parts displayed: \n");
		Scanner userIn=new Scanner(System.in);
		int n=userIn.nextInt();
		if(n==1) {
			
		}
		else if(n==2) {
			
		}
		else if(n==3) {
			
		}else if(n==4) {
			
		}
		else if(n==5) {
			
		}
		else if(n==6) {
			
		}
		else if(n==7) {
			System.out.println("thank you for using this program!");
			System.exit(0);
		}
	}
		
	}
