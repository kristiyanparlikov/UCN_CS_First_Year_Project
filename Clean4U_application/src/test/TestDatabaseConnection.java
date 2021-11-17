package test;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import databaselayer.DBConnection;

class TestDatabaseConnection {

	static DBConnection con = null;
	
	@BeforeAll
	public static void setUp() throws Exception {
		con = DBConnection.getInstance();
	}
	
	@Test
	@DisplayName ("Test Database connection")
	@Tag("Test ID 1")
	public void isConnected() throws Exception {
		assertNotNull("Connected - connection cannot be null", con);
	}
}