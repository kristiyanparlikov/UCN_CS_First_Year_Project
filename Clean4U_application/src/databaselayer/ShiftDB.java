package databaselayer;

import controllerLayer.DataAccessException;

public class ShiftDB {
	private final DBConnection dbcon;
	
	public ShiftDB() throws DataAccessException {
		dbcon = DBConnection.getInstance();
	}
}
