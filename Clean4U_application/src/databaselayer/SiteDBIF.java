package databaselayer;

import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Customer;
import modelLayer.Site;

public interface SiteDBIF {
	List<Site> findAllCustomerSites(Customer customer, boolean fullAssociation) throws DataAccessException;
	Site insert(Site site) throws DataAccessException;
	boolean delete(Site site) throws DataAccessException;
	boolean update(Site site) throws DataAccessException;
	Site findSiteById(int id) throws DataAccessException;
}
