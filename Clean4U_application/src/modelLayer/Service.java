package modelLayer;

public class Service {
	private int serviceId;
	private String type;
	private String specifics;
	private Site site;
	
	public Service(){
		
	}
	public Service(int serviceId, Site site, String type, String specifics) {
		this.serviceId = serviceId;
		this.setSite(site);
		this.type = type;
		this.specifics = specifics;
	}
	
	public Service ( Site site, String type, String specifics) {
		this.setSite(site);
		this.type = type;
		this.specifics = specifics;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecifics() {
		return specifics;
	}
	public void setSpecifics(String specifics) {
		this.specifics = specifics;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	public Site getSite() {
		return site;
	}
	
	public void setSite (Site site) {
		this.site=site;
	}
}
