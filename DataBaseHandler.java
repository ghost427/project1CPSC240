/**
 * @author Connor Byrd
 * @Description opens database txt doc and reads in initial Arraylist of parts
 * @return Initial arrayList to the class PartList
 */
import java.util.*;
import java.io.*;

public class DataBaseHandler {

	public static PartList openDatabase(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileName));
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
