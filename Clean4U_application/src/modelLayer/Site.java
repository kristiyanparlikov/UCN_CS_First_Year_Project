package modelLayer;

public class Site {
	private int siteId;
	private Customer customer;
	private Address address;
	private String typeOfSite;
	private double sizeOfArea;
	private String openHour;
	private String closeHour;
	private boolean status;
	
	public Site() {
		
	}
	
	public Site(int siteId, Customer customer, Address address, String typeOfSite, 
			double sizeOfArea, String openHour, String closeHour, boolean status) {
		this.siteId = siteId;
		this.setCustomer(customer);
		this.setAddress(address);
		this.typeOfSite = typeOfSite;
		this.sizeOfArea = sizeOfArea;
		this.openHour = openHour;
		this.closeHour = closeHour;
		this.status = status;
	}
	
	public Site(Customer customer, Address address, String typeOfSite, 
			double sizeOfArea, String openHour, String closeHour, boolean status) {
		this.setCustomer(customer);
		this.setAddress(address);
		this.typeOfSite = typeOfSite;
		this.sizeOfArea = sizeOfArea;
		this.openHour = openHour;
		this.closeHour = closeHour;
		this.status = status;
	}
	
public Site(int id) {
		this.siteId = id;
	}


	public String getTypeOfSite() {
		return typeOfSite;
	}
	public void setTypeOfSite(String typeOfSite) {
		this.typeOfSite = typeOfSite;
	}
	public double getSizeOfArea() {
		return sizeOfArea;
	}
	public void setSizeOfArea(double sizeOfArea) {
		this.sizeOfArea = sizeOfArea;
	}
	public String getOpenHour() {
		return openHour;
	}
	public void setOpenHour(String openHour) {
		this.openHour = openHour;
	}
	public String getCloseHour() {
		return closeHour;
	}
	public void setCloseHour(String closeHour) {
		this.closeHour = closeHour;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	
	
}
