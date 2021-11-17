package databaselayer;

import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Employee;

public interface EmployeeDBIF {
	Employee findEmployeeById(int employeeId, boolean fullAssociation) throws DataAccessException;
	List<Employee> findAll(boolean fullAssociation) throws DataAccessException;
	Employee insert(Employee employee) throws DataAccessException;
	boolean delete(Employee employee) throws DataAccessException;
	boolean update(Employee employee) throws DataAccessException;
}
