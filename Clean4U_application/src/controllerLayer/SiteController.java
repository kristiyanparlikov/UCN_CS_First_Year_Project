package controllerLayer;

import java.util.List;


import databaselayer.SiteDB;
import databaselayer.SiteDBIF;
import databaselayer.ServiceDB;
import databaselayer.ServiceDBIF;
import modelLayer.Address;
import modelLayer.Customer;
import modelLayer.Site;
import modelLayer.Service;

public class SiteController {
	private SiteDBIF siteDB;
	private ServiceDBIF serviceDB;
	
	public SiteController() throws DataAccessException {
		siteDB = new SiteDB();
		serviceDB = new ServiceDB();
	}
	//insert site
	public Site insertSite (Customer customer, Address address, String typeOfSite, 
			double sizeOfArea, String openHour, String closeHour, boolean status)throws DataAccessException {
		Site site = new Site(customer, address, typeOfSite, sizeOfArea, openHour, closeHour, status);
		siteDB.insert(site);
		return site;
	}
	//update site
	public boolean updateSite(Site site) throws DataAccessException{
		return (siteDB.update(site));
	}
	//get all sites of a customer
	public List<Site> getAllCustomerSites(Customer customer) throws DataAccessException {
		return siteDB.findAllCustomerSites(customer,false);
	}
	//delete site
	public boolean deleteSite(Site site) throws DataAccessException {
		return siteDB.delete(site);
	}
	
	//find site by id
	public Site findSiteById(int id) throws DataAccessException {
		return siteDB.findSiteById(id);
	}
	
	//SERVICE
	
	//insert service
	public boolean insertService (Site site, String type, String specifics)throws DataAccessException {
		Service service = new Service(site, type, specifics);
		serviceDB.insert(service);
		return service != null;
	}
	//update service
	public boolean updateService(Service service) throws DataAccessException{
		return (serviceDB.update(service));
	}
	
	//get all services done on a site
	public List<Service> getAllSiteServices(Site site) throws DataAccessException {
		return serviceDB.findAllSiteServices(site, false);
	}
	//delete service
	public boolean deleteService(Service service) throws DataAccessException{
		return serviceDB.delete(service);
	}
	
	
	/**
	//insert shift
	public Shift insertShift (Shift shift)throws DataAccessException {
		shiftDB.insert(shift);
		return shift;
	}
	//update shift
	public void updateShift(int shiftId, int serviceId, int employeeId, Date date, Date startHour, Date endHour) throws DataAccessException{
		shiftDB.update(shiftId);
	}
	//find shift
	public Shift findShift (int shiftId) throws DataAccessException {
		return shiftDB.find(shiftId);
	}
	//delete shift
	public Shift deleteShift(Shift shift) throws DataAccessException {
		shiftDB.delete(shift);
		return shift;
	}
	
	*/
}