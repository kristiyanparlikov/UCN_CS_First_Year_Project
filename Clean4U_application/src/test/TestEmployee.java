package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import controllerLayer.DataAccessException;
import controllerLayer.PersonController;

class TestEmployee {
	
	private static PersonController personController;
	
	@BeforeAll
	public static void setUp() throws DataAccessException {
		personController = new PersonController ();
	}
	
	@Test
	@DisplayName("Inserting employee")
	@Tag("Test ID 7")
	public void insert() throws Exception {
		personController.insertEmployee("Bob","Newman", "775448558","bob@newman.com",personController.findEmployeeById(24), 2500,"Window cleaner", "note"); 
	}
	 
	@Test
	@DisplayName("Update employee")
	@Tag("Test ID 8")
	public void update() throws DataAccessException {
		personController.updateEmployee(personController.findEmployeeById(25));
	}
	
	@Test
	@DisplayName("Find employee by ID")
	@Tag("Test ID 9")
	public void find() throws DataAccessException {
		assertNotNull(personController.findEmployeeById(27));
	}
	
	@Test
	@DisplayName("Get all employees")
	@Tag("Test ID 10")
	public void getAll() throws DataAccessException {
		assertNotNull(personController.getAllEmployees());
	}
	
	@Test
	@DisplayName("Delete employee")
	@Tag("Test ID 11")
	public void delete() throws DataAccessException {
		personController.deleteEmployee(personController.findEmployeeById(30));
	}
}
