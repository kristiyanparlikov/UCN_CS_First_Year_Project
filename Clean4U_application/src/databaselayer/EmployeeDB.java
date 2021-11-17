package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Customer;
import modelLayer.Employee;

public class EmployeeDB implements EmployeeDBIF{
	
	private static final String FIND_ALL_Q = "SELECT * FROM Employees";
	private PreparedStatement findAllPS;
	
	private static final String FIND_BY_ID_Q = FIND_ALL_Q + " WHERE employeeId = ?";
	private PreparedStatement findByIdPS;
	
	private static final String INSERT_Q = "INSERT INTO Employees (firstName,lastName,phoneNum,email,managerId,salary,specialization,note) VALUES (?,?,?,?,?,?,?,?)"; 
	private PreparedStatement insertPS;
	
	private static final String DELETE_Q = "DELETE FROM Employees WHERE employeeId = ?";
	private PreparedStatement deletePS;
	
	private static final String UPDATE_Q = "UPDATE Employees SET firstName = ?, lastName = ?, phoneNum = ?, email = ?, managerId = ?, salary = ?, specialization = ?, note = ? WHERE employeeId = ?";
	private PreparedStatement updatePS;
	
	public EmployeeDB() throws DataAccessException{
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
	public Employee findEmployeeById(int employeeId, boolean fullAssociation) throws DataAccessException {
		Employee res = null;
		try {
			findByIdPS.setInt(1, employeeId);
			ResultSet rs = findByIdPS.executeQuery();
			if (rs.next()) {
				res = buildObject(rs, fullAssociation);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not bind or execute query", e);
		}
		return res;
	}
	
	private Employee buildObject(ResultSet rs, boolean fullAssociation) throws DataAccessException {
		Employee currEmployee = new Employee();
		try {
			currEmployee.setId(rs.getInt("employeeId"));
			currEmployee.setFirstName(rs.getString("firstName"));
			currEmployee.setLastName(rs.getString("lastName"));
			currEmployee.setPhoneNumber(rs.getString("phoneNum"));
			currEmployee.setEmail(rs.getString("email"));
			currEmployee.setManager(new Employee(rs.getInt("managerId")));
			currEmployee.setSalary(rs.getDouble("salary"));
			currEmployee.setSpecialization(rs.getString("specialization"));
			currEmployee.setNote(rs.getString("note"));
			if (fullAssociation) {
				Employee manager = findEmployeeById(currEmployee.getManager().getId(), false); // set to false to avoid
																								// potentially rolling
																								// up the entire
																								// database
				currEmployee.setManager(manager);
	
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return currEmployee;
	}
	
	private List<Employee> buildObjects(ResultSet rs, boolean fullAssociation) throws DataAccessException {
		List<Employee> res = new ArrayList<>();
		try {
			while (rs.next()) {
				Employee currEmployee = buildObject(rs, fullAssociation);
				res.add(currEmployee);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return res;
	}
	
	@Override
	public List<Employee> findAll(boolean fullAssociation) throws DataAccessException {
		ResultSet rs;
		try {
			rs = this.findAllPS.executeQuery();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		List<Employee> res = buildObjects(rs, fullAssociation);
		return res;
	}
	
	@Override
	public Employee insert(Employee employee) throws DataAccessException {
		try {
			insertPS.setString(1, employee.getFirstName());
			insertPS.setString(2, employee.getLastName());
			insertPS.setString(3, employee.getPhoneNumber());
			insertPS.setString(4, employee.getEmail());
			insertPS.setDouble(6, employee.getSalary());
			insertPS.setString(7, employee.getSpecialization());
			insertPS.setString(8, employee.getNote());
			if (employee.getManager() != null) {
				insertPS.setInt(5, employee.getManager().getId());
			} else {
				insertPS.setNull(5, Types.CHAR);
			}
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

		return employee;
	}
	
	@Override
	public boolean delete(Employee employee) throws DataAccessException {
		try {
			deletePS.setInt(1,employee.getId());
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

	public boolean update(Employee employee) throws DataAccessException {
		try {
			//set fields
			updatePS.setString(1, employee.getFirstName());
			updatePS.setString(2, employee.getLastName());
			updatePS.setString(3, employee.getPhoneNumber());
			updatePS.setString(4, employee.getEmail());
			updatePS.setInt(5, employee.getManager().getId());
			updatePS.setDouble(6, employee.getSalary());
			updatePS.setString(7, employee.getSpecialization());
			updatePS.setString(8, employee.getNote());
			//where
			updatePS.setInt(9,employee.getId());
		}catch (SQLException e){
			throw new DataAccessException("Could not bind or execute query", e);
		}try {
			if(updatePS.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not update", e);
		}
		return false;
	}
	


	
}
