package controllerLayer;

import java.util.List;

import databaselayer.CustomerDB;
import databaselayer.CustomerDBIF;
import databaselayer.EmployeeDB;
import databaselayer.EmployeeDBIF;
import modelLayer.Customer;
import modelLayer.Employee;

public class PersonController {
	private CustomerDBIF customerDB;
	private EmployeeDBIF employeeDB;
	
	public PersonController() throws DataAccessException {
		customerDB = new CustomerDB();
		employeeDB = new EmployeeDB();
	}
	
	//insert customer
	public Customer insertCustomer (String taxNum, String companyName, String firstName, String lastName,
			String phoneNum, String email, String note)throws DataAccessException {
		Customer c = new Customer(taxNum, companyName, firstName, lastName, phoneNum, email, note);
		customerDB.insert(c);
		return c;
	}
	//insert employee
	public Employee insertEmployee(String firstName, String lastName, String phoneNumber, String email, Employee manager, double salary, String specialization, String note) throws DataAccessException {
		Employee e = new Employee(firstName, lastName, phoneNumber, email, manager, salary, specialization, note);
		employeeDB.insert(e);
		return e;
	}
	
	//update customer
	public boolean updateCustomer(Customer customer) throws DataAccessException {
		return (customerDB.update(customer));
	}
	
	//update employee
	public boolean updateEmployee(Employee employee) throws DataAccessException { 
		return (employeeDB.update(employee));
	}
	
	//find customer by ID
	public Customer findCustomerById(int id) throws DataAccessException {
        return customerDB.findCustomerById(id);
    }
	
	//get all customers
	public List<Customer> getAllCustomers() throws DataAccessException {
        List<Customer> res = customerDB.findAll();
		return res;
    }
	
	//find employee by ID
	public Employee findEmployeeById(int id) throws DataAccessException {
        return employeeDB.findEmployeeById(id, false);
    }
	
	//get all employees
	public List<Employee> getAllEmployees() throws DataAccessException {
		List<Employee> res = employeeDB.findAll(false);
		return res;
	}
	
	
	//delete customer
	public boolean deleteCustomer(Customer customer) throws DataAccessException { 
		return customerDB.delete(customer); 
	}
	
	//delete employee
	public boolean deleteEmployee(Employee employee) throws DataAccessException { 
		return employeeDB.delete(employee);
		}
	

}
