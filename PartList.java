import java.util.*;

public class PartList {
	public static ArrayList<Part1> partArray=new ArrayList<Part1>();
	
	public void add(Part1 part) {
		this.partArray.add(part);
	}
	
	public static int getArrSize() {
		return partArray.size();
	}

}
