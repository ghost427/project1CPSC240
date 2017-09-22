public class Part1 implements Comparable{
    private double listPrice;
    private double salesPrice;
    private int partNumber;
    private int quantity;
    private String partName;
    private boolean onSale;

    public Part1(String name, int partNum, double list, double sales, boolean onSale, int quantity) {
        this.partName = name;
        this.partNumber = partNum;
        this.listPrice = list;
        this.salesPrice = sales;
        this.onSale = onSale;
        this.quantity = quantity;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }
    
    public int getQuan() {
    	return quantity;
    }
    
    public void setQuan(int q) {
    	this.quantity=q;
    }
    
    public String toString() {
    	return partName +","+partNumber+","+listPrice+","+salesPrice+","+onSale+","+quantity;
    }
	@Override
	public int compareTo(Object arg0) {
		PartNumberComparator pnc = new PartNumberComparator();
		return pnc.compare(this,(Part1) arg0);
	}



}

