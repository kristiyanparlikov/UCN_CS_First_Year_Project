package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Customer;

public class CustomerDB implements CustomerDBIF{

	private static final String FIND_ALL_Q = "SELECT * FROM Customers";
	private PreparedStatement findAllPS;
	
	private static final String FIND_BY_ID_Q = FIND_ALL_Q + " WHERE customerId = ?";
	private PreparedStatement findByIdPS;
	
	private static final String INSERT_Q = "INSERT INTO Customers (taxNum,companyName,firstName,lastName,phoneNum,email,note) VALUES (?,?,?,?,?,?,?)";
	private PreparedStatement insertPS;
	
	private static final String DELETE_Q = "DELETE FROM Customers WHERE customerId = ?";
	private PreparedStatement deletePS;
	
	private static final String UPDATE_Q = "UPDATE Customers SET taxNum = ?, companyName = ?, firstName = ?, lastName = ?, phoneNum = ?, email = ?, note = ? WHERE customerId = ?";
	private PreparedStatement updatePS;
	
	public CustomerDB () throws DataAccessException {
		init();
	}
	
	private void init() throws DataAccessException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findByIdPS = con.prepareStatement(FIND_BY_ID_Q);
			insertPS = con.prepareStatement(INSERT_Q);
			deletePS = con.prepareStatement(DELETE_Q);
			updatePS = con.prepareStatement(UPDATE_Q);
		}catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	@Override
	public Customer findCustomerById(int customerId) throws DataAccessException {
		Customer res = null;
		try {
			findByIdPS.setInt(1, customerId);
			ResultSet rs = findByIdPS.executeQuery();
			if (rs.next()) {
				res = buildObject(rs);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not bind or execute query", e);
		}
		return res;
	}
	
	private Customer buildObject(ResultSet rs) throws DataAccessException{
		Customer currCustomer = new Customer();
		try {
			currCustomer.setId(rs.getInt("customerId"));
			currCustomer.setTaxNum(rs.getString("taxNum"));
			currCustomer.setCompanyName(rs.getString("companyName"));
			currCustomer.setFirstName(rs.getString("firstName"));
			currCustomer.setLastName(rs.getString("lastName"));
			currCustomer.setPhoneNumber(rs.getString("phoneNum"));
			currCustomer.setEmail(rs.getString("email"));
			currCustomer.setNote(rs.getString("note"));
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return currCustomer;
	}
	
	private List<Customer> buildObjects(ResultSet rs) throws DataAccessException {
		List<Customer> res = new ArrayList<>();
		try {
			while (rs.next()) {
				Customer currCustomer = buildObject(rs);
				res.add(currCustomer);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return res;
	}

	@Override
	public List<Customer> findAll() throws DataAccessException {
		ResultSet rs;
		try {
			rs = this.findAllPS.executeQuery();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		List<Customer> res = buildObjects(rs);
		return res;
	}

	@Override
	public Customer insert(Customer customer) throws DataAccessException {
		try {
			insertPS.setString(1, customer.getTaxNum());
			insertPS.setString(2, customer.getCompanyName());
			insertPS.setString(3, customer.getFirstName());
			insertPS.setString(4, customer.getLastName());
			insertPS.setString(5, customer.getPhoneNumber());
			insertPS.setString(6, customer.getEmail());
			insertPS.setString(7, customer.getNote());
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not bind or execute query", e);
		}
		try {
			insertPS.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not insert new record", e);
		}

		return customer;
	}

	@Override
	public boolean delete(Customer customer) throws DataAccessException {
		try {
			deletePS.setInt(1,customer.getId());
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
	
	public boolean update(Customer customer) throws DataAccessException {
		try {
			//set fields
			updatePS.setString(1, customer.getTaxNum());
			updatePS.setString(2, customer.getCompanyName());
			updatePS.setString(3, customer.getFirstName());
			updatePS.setString(4, customer.getLastName());
			updatePS.setString(5, customer.getPhoneNumber());
			updatePS.setString(6, customer.getEmail());
			updatePS.setString(7, customer.getNote());
			//where
			updatePS.setInt(8,customer.getId());
		}catch (SQLException e){
			throw new DataAccessException("Could not bind or execute query", e);
		}try {
			if(updatePS.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not delete", e);
		}
		return false;
	}
}
