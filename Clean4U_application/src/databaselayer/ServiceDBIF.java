package databaselayer;

import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Service;
import modelLayer.Site;

public interface ServiceDBIF {
	List<Service> findAllSiteServices (Site site, boolean fullAssociation) throws DataAccessException;
	Service insert(Service service) throws DataAccessException;
	boolean delete(Service service) throws DataAccessException;
	boolean update(Service service) throws DataAccessException;
}
