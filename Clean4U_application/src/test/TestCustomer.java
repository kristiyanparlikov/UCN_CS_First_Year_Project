package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import controllerLayer.DataAccessException;
import controllerLayer.PersonController;

class TestCustomer {
	
	private static PersonController personController;
	
	@BeforeAll
	public static void setUp() throws DataAccessException {
		personController = new PersonController();
	}
	
	@Test
	@DisplayName("Insertion customer")
	@Tag("Test ID 2")
	public void insert() throws DataAccessException {
		personController.insertCustomer("4458984", "Bob the Builder Inc.", "Bob", "Strong", "784596258", "bob@thebuilder.com", "note");
	}
	
	@Test
	@DisplayName("Update customer")
	@Tag("Test ID 3")
	public void update() throws DataAccessException {
		personController.updateCustomer(personController.findCustomerById(12));
	}
	
	@Test
	@DisplayName("Find customer by ID")
	@Tag("Test ID 4")
	public void find() throws DataAccessException {
		assertNotNull(personController.findCustomerById(12));
	}
	
	@Test
	@DisplayName("Get all customers")
	@Tag("Test ID 5")
	public void getAll() throws DataAccessException {
		assertNotNull(personController.getAllCustomers());
	}
	
	@Test
	@DisplayName("Delete customer")
	@Tag("Test ID 6")
	public void delete() throws DataAccessException {
		personController.deleteCustomer(personController.findCustomerById(13));
	}
}
