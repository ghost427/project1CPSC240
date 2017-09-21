import java.util.*;

public class PartList {
	public static ArrayList<Part1> partArray=new ArrayList<Part1>();
	
	public void add(Part1 part) {
		this.partArray.add(part);
	}
	
	public void remove(Part1 part) {
		this.partArray.remove(part);
	}
	
	public static int getArrSize() {
		return partArray.size();
	}
	
	public static void sortByName() {
		System.out.print(partArray.get(0).toString());
		for(int i=0;i<partArray.size();i++) {
			
		}
		/**Collections.sort(partArray, new Comparator<String>(){
			public int compare(String s1,String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		}*/
	}
	
	public String toString() {
		String temp="";
		for(int i=0;i<partArray.size();i++) {
			temp+=partArray.get(i).toString()+"\n";
		}
		return temp;
	}
	

}