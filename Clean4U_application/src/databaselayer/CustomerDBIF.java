package databaselayer;

import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Customer;

public interface CustomerDBIF {
	Customer findCustomerById(int customerId) throws DataAccessException;
	List<Customer> findAll() throws DataAccessException;
	Customer insert(Customer customer) throws DataAccessException;
	boolean delete(Customer customer) throws DataAccessException;
	boolean update(Customer customer) throws DataAccessException;
}
