package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import controllerLayer.AddressController;
import controllerLayer.DataAccessException;
import controllerLayer.PersonController;
import controllerLayer.SiteController;

class TestSites {
	private static SiteController siteController;
	private static PersonController personController;
	private static AddressController addressController;

	@BeforeAll
	public static void setUp() throws DataAccessException {
		siteController = new SiteController();
		personController = new PersonController();
		addressController = new AddressController();
	}
	
	@Test
	@DisplayName("Inserting site")
	@Tag("test ID 12")
	public void insert() throws DataAccessException {
		siteController.insertSite(personController.findCustomerById(6), addressController.findAdressById(2), "Gym", 558.5, "7:00", "17:00",true);
	}

	@Test
	@DisplayName("Update site")
	@Tag("test ID 13")
	public void update() throws DataAccessException {
		siteController.updateSite(siteController.findSiteById(4));
	}
	
	@Test
	@DisplayName("Find site by ID")
	@Tag("test ID 14")
	public void find() throws DataAccessException {
		assertNotNull(siteController.findSiteById(4));
	}
	
	@Test
	@DisplayName("Get all sites for customer")
	@Tag("test ID 15")
	public void getAll() throws DataAccessException {
		assertNotNull(siteController.getAllCustomerSites(personController.findCustomerById(14)));
	}
	
	@Test
	@DisplayName("Delete site")
	@Tag("test ID 16")
	public void delete() throws DataAccessException {
		siteController.deleteSite(siteController.findSiteById(4));
	}

}
