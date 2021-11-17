package modelLayer;

public class Warehouse {
	private int warehouseId;
	private int AddressId;
	private String name;
	
	
	public Warehouse(int warehouseId, int addressId, String name) {
		this.warehouseId = warehouseId;
		AddressId = addressId;
		this.name = name;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int addressId) {
		AddressId = addressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
