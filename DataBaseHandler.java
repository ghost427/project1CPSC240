public class DataBaseHandler{

    public static void main (String[] args){
        Scanner in = new Scanner(new File("C:\\Users\\Connor Byrd\\project1CPSC240\\warehouseDB.txt"));
        int lineNum = in.nextInt();
        Part1[] bp = new Part1[lineNum];
        in.nextLine();
        for (int i = 0; i < lineNum; i++) {
            String line = in.nextLine();
            // System.out.println(line);
            String[] elements = line.split(",");
            bp[i] = new Part1(elements[0], Integer.parseInt(elements[1]), Double.parseDouble(elements[2]),
                    Double.parseDouble(elements[3]), Boolean.parseBoolean(elements[4],Integer.parseInt(elements[5])));
            System.out.println(line);
    }
}