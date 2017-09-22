
import java.util.*;

public class PartList {
	public static ArrayList<Part1> partArray = new ArrayList<Part1>();

	public void add(Part1 part) {
		this.partArray.add(part);
	}

	public void remove(Part1 part) {
		this.partArray.remove(part);
	}

	public static int getArrSize() {
		return partArray.size();
	}

	public static void sortByNumber() {
		Collections.sort(partArray);

	}

	public void sortByName() {
		for (int i = 0; i < partArray.size(); i++) {
			partArray.get(i).getPartName();
			for (int j = 0; j > 0; j--) {
				if (Character.getNumericValue(this.partArray.get(j).getPartName().charAt(0)) < Character.getNumericValue(this.partArray.get(j - 1).getPartName().charAt(0))) {
					Part1 temp = this.partArray.get(j);
					this.partArray.set(j, this.partArray.get(j - 1));
					this.partArray.set(j - 1, temp);
				}

			}
		}
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < partArray.size(); i++) {
			temp += partArray.get(i).toString() + "\n";
		}
		return temp;
	}

	public Part1 get(int i) {
		return this.partArray.get(i);
	}

}
