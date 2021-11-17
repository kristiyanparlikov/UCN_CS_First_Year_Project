package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Address;
import modelLayer.Customer;
import modelLayer.Employee;
import modelLayer.Site;
import modelLayer.ZipCode;

public class AddressDB implements AddressDBIF{
		
		private static final String FIND_ALL_Q = "SELECT * FROM Addresses";
		private PreparedStatement findAllPS;
	
		private static final String FIND_BY_ID_Q = FIND_ALL_Q + " WHERE addressId = ?";
		private PreparedStatement findByIdPS;
		
		private static final String INSERT_Q = "INSERT INTO Addresses (country, zipCode, street, streetNum) VALUES (?,?,?,?)";
		private PreparedStatement insertPS;
		
		private static final String DELETE_Q = "DELETE FROM Addresses WHERE addressId = ?";
		private PreparedStatement deletePS;
		
		private static final String INSERT_ZIPCODE_Q = "INSERT INTO ZipCodes (zipCode, city) VALUES (?,?)";
		private PreparedStatement insertZipCodePS;
		
		
	public AddressDB() throws DataAccessException{
		init();
	}
	
	public void init() throws DataAccessException{
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findByIdPS = con.prepareStatement(FIND_BY_ID_Q);
			insertPS = con.prepareStatement(INSERT_Q);
			deletePS = con.prepareStatement(DELETE_Q);
			insertZipCodePS = con.prepareStatement(INSERT_ZIPCODE_Q);
		}catch (SQLException e){
			throw new DataAccessException ("Could not preapare statemnt", e);
		}
	}
	
	@Override
	public List<Address> findAll() throws DataAccessException {
		ResultSet rs;
		try {
			rs = this.findAllPS.executeQuery();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		List<Address> res = buildObjects(rs);
		return res;
	}
	
	@Override
	public Address insert(Address address) throws DataAccessException {
		String testCity = "TestCity";
		try {
			insertZipCodePS.setString(1, address.getZipCode());
			insertZipCodePS.setString(2, testCity);
			
			insertPS.setString(1, address.getCountry());
			insertPS.setString(2, address.getZipCode());
			insertPS.setString(3, address.getStreet());
			insertPS.setInt(4, address.getStreetNumber());
			
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not bind or execute query", e);
		}
		try {
			insertZipCodePS.executeUpdate();
			insertPS.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert new record", e);
		}

		return address;
	}
	
	@Override
	public Address findAddressById(int addressId) throws DataAccessException{
		Address res = null;
		try {
			findByIdPS.setInt(1, addressId);
			ResultSet rs = findByIdPS.executeQuery();
			if(rs.next()) {
				res = buildObject(rs);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not bind or execute query", e);
		}
		return res;
	}
	
	private Address buildObject (ResultSet rs) throws DataAccessException{
		Address currAddress = new Address();
		try {
			currAddress.setAddressId(rs.getInt("addressId"));
			currAddress.setCountry(rs.getString("country"));
			currAddress.setZipCode(rs.getString("zipCode"));
			currAddress.setStreet(rs.getString("street"));
			currAddress.setStreetNumber(rs.getInt("streetNum"));
		} catch (SQLException e) {
			throw new DataAccessException("Could not read resultset", e);
		}
		return currAddress;
	}
	
	private List<Address> buildObjects(ResultSet rs) throws DataAccessException {
		List<Address> res = new ArrayList<>();
		try {
			while (rs.next()) {
				Address currAddress = buildObject(rs);
				res.add(currAddress);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return res;
	}
	
	@Override
	public boolean delete(Address address) throws DataAccessException {
		try {
			deletePS.setInt(1,address.getAddressId());
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not bind or execute query", e);
		}
		try {
			if(deletePS.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not delete", e);
		}
		return false;
	}
}
