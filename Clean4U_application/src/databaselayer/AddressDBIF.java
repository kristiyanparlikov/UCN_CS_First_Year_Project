package databaselayer;

import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Address;

public interface AddressDBIF {
	Address findAddressById(int addressId) throws DataAccessException;
	List<Address> findAll() throws DataAccessException;
	Address insert(Address address) throws DataAccessException;
	boolean delete(Address address) throws DataAccessException;

}
