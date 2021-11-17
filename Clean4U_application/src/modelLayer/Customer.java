package modelLayer;

public class Customer extends Person{
	private String taxNum;
	private String companyName;
	
	public Customer(int id, String taxNum, String companyName, String firstName,
			String lastName, String phoneNumber, String email, String note) {
		super(id, firstName,lastName,phoneNumber, email, note);
		this.taxNum = taxNum;
		this.companyName = companyName;
	}
	
	public Customer(String taxNum, String companyName, String firstName, 
			String lastName, String phoneNumber, String email, String note) {
		super(firstName,lastName,phoneNumber, email, note);
		this.taxNum = taxNum;
		this.companyName = companyName;
	}
	public Customer() {
	}
	public Customer(int id) {
	}
	public String getTaxNum() {
		return taxNum;
	}
	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return getCompanyName() + " ; Person's full name: " + getFirstName() + " " + getLastName();
	}
	

}
