package modelLayer;

public class ProductDescription {
	private int barcode;
	private String name;
	private String category;
	private double price;
	
	public ProductDescription(int barcode, String name, String category, double price) {
		this.barcode = barcode;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public ProductDescription() {
		
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
