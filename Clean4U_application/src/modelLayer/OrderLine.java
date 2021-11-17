package modelLayer;

public class OrderLine {
	private int id;
	private ProductDescription product;
	private int quantity;
	private double cost = 0.0;

	public OrderLine(int id, ProductDescription product,int quantity) {
		this.id=id;
		this.setProduct(product);
		this.quantity = quantity;
		setCost(product.getPrice()*quantity);
	}
	
	public OrderLine(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductDescription getProduct() {
		return product;
	}

	public void setProduct(ProductDescription product) {
		this.product = product;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
