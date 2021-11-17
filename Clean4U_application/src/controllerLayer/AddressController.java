package controllerLayer;

import java.util.List;

import databaselayer.AddressDB;
import databaselayer.AddressDBIF;
import databaselayer.ZipCodeDB;
import modelLayer.Address;
import modelLayer.ZipCode;

public class AddressController {
	private AddressDBIF addressDB;
	
	public AddressController() throws DataAccessException{
		addressDB = new AddressDB();
	}
	
	//find address with ID
	public Address findAdressById(int id) throws DataAccessException {
		return addressDB.findAddressById(id);
	}
	
	public List<Address> findAllAddresses() throws DataAccessException {
		return addressDB.findAll();
	}
	
	public Address insertAddress(String country, String zipCode, String street, int streetNum) throws DataAccessException {
		Address a = new Address(country, zipCode, street, streetNum);
		addressDB.insert(a);
		return a;
	}
	
	public boolean deleteAddress (Address address) throws DataAccessException {
		return addressDB.delete(address);
	}
	
	
}
	

