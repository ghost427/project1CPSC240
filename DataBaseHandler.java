import java.util.*;

import java.io.*;

public class DataBaseHandler {

	public static PartList openDatabase() throws FileNotFoundException {
		System.out.print(Importer.printHelp());
		Scanner in = new Scanner(new File("warehouseDB.txt"));
		int lineNum = Integer.parseInt(in.nextLine());
		PartList bp = new PartList();
		for (int i = 0; i < lineNum; i++) {
			String line = in.nextLine();
			// System.out.println(line);
			String[] elements = line.split(",");
			bp.add(new Part1(elements[0], Integer.parseInt(elements[1]), Double.parseDouble(elements[2]),
					Double.parseDouble(elements[3]), Boolean.parseBoolean(elements[4]), Integer.parseInt(elements[5])));
		}
		in.close();
		return bp;
		
	}

}
