package modelLayer;

public class ZipCode {
	private String zipCode;
	private String city;
	
	
	public ZipCode(String zipCode, String city) {
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public ZipCode() {
		
	}


	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}	
	
}
