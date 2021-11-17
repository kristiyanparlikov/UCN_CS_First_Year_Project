package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Address;
import modelLayer.Customer;
import modelLayer.Employee;
import modelLayer.Site;


public class SiteDB implements SiteDBIF{
	private AddressDB addressDB;
	private CustomerDB customerDB;
	
	private static final String FIND_ALL_Q = "SELECT * FROM Sites";
	private PreparedStatement findAllPS;
	
	private static final String FIND_ALL_CUSTOMER_SITES_Q = FIND_ALL_Q + " WHERE customerId = ?";
	private PreparedStatement findAllCustomerSitesPS;
	
	private static final String FIND_BY_ID_Q = FIND_ALL_Q + " WHERE siteId = ?";
	private PreparedStatement findByIdPS;
	
	private static final String INSERT_Q = "INSERT INTO Sites (customerId,addressId,typeOfSite,sizeOfArea,openHour,closeHour,status) VALUES (?,?,?,?,?,?,?)";
	private PreparedStatement insertPS;
	
	private static final String DELETE_Q = "DELETE FROM Sites WHERE siteId = ?";
	private PreparedStatement deletePS;
	
	private static final String UPDATE_Q = "UPDATE Sites SET customerId = ?, addressId = ?, typeOfSite = ?, sizeOfArea = ?, openHour = ?, closeHour = ?, status = ? WHERE siteId = ?";
	private PreparedStatement updatePS;


	public SiteDB()throws DataAccessException{
		addressDB = new AddressDB();
		customerDB = new CustomerDB();
		init();
	}
		private void init() throws DataAccessException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findAllCustomerSitesPS = con.prepareStatement(FIND_ALL_CUSTOMER_SITES_Q);
			insertPS = con.prepareStatement(INSERT_Q);
			deletePS = con.prepareStatement(DELETE_Q);
			updatePS = con.prepareStatement(UPDATE_Q);
			findByIdPS = con.prepareStatement(FIND_BY_ID_Q);
		}catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
		@Override
	public List<Site> findAllCustomerSites(Customer customer, boolean fullAssociation) throws DataAccessException {
		ResultSet rs;
		try {
			findAllCustomerSitesPS.setInt(1,customer.getId());
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not bind or execute query", e);
		}
		try {
			rs = this.findAllCustomerSitesPS.executeQuery();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		List<Site> res = buildObjects(rs, fullAssociation);
		return res;
	}
	
	private Site buildObject(ResultSet rs, boolean fullAssociation) throws DataAccessException {
		Site currSite = new Site();
		try {
			currSite.setSiteId(rs.getInt("siteId"));
			currSite.setCustomer(new Customer(rs.getInt("customerId")));
			currSite.setAddress(new Address(rs.getInt("addressId")));
			currSite.setTypeOfSite(rs.getString("typeOfSite"));
			currSite.setSizeOfArea(rs.getDouble("sizeOfArea"));
			currSite.setOpenHour(rs.getString("openHour"));
			currSite.setCloseHour(rs.getString("closeHour"));
			currSite.setStatus(rs.getBoolean("status"));
			if (fullAssociation) {
				Customer company = customerDB.findCustomerById(rs.getInt("customerId")); 
				Address address = addressDB.findAddressById(currSite.getAddress().getAddressId());																			
																								
				currSite.setCustomer(company);
				currSite.setAddress(address);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return currSite;
	}
	
	private List<Site> buildObjects(ResultSet rs, boolean fullAssociation) throws DataAccessException {
		List<Site> res = new ArrayList<>();
		try {
			while (rs.next()) {
				Site currSite = buildObject(rs, fullAssociation);
				res.add(currSite);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return res;
	}
	
	@Override
	public Site insert(Site site) throws DataAccessException {
		try {
			insertPS.setInt(1, site.getCustomer().getId());
			insertPS.setInt(2, site.getAddress().getAddressId());
			insertPS.setString(3, site.getTypeOfSite());
			insertPS.setDouble(4, site.getSizeOfArea());
			insertPS.setString(5, site.getOpenHour());
			insertPS.setString(6, site.getCloseHour());
			insertPS.setBoolean(7, site.getStatus());
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

		return site;
	}
	
	@Override
	public boolean delete(Site site) throws DataAccessException {
		try {
			deletePS.setInt(1,site.getSiteId());
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
	
	@Override
	public boolean update(Site site) throws DataAccessException {
		try {
			//set fields
			updatePS.setInt(1, site.getCustomer().getId());
			updatePS.setInt(2, site.getAddress().getAddressId());
			updatePS.setString(3, site.getTypeOfSite());
			updatePS.setDouble(4, site.getSizeOfArea());
			updatePS.setString(5, site.getOpenHour());
			updatePS.setString(6, site.getCloseHour());
			updatePS.setBoolean(7, site.getStatus());
			//where
			updatePS.setInt(8,site.getSiteId());
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
	
	@Override
	public Site findSiteById(int id) throws DataAccessException{
		Site res = null;
		try {
			findByIdPS.setInt(1, id);
			ResultSet rs = findByIdPS.executeQuery(); 
			if(rs.next()) {
				res = buildObjectB(rs);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not bind or exacute query", e);
		}
		return res;
	}
	
	public Site buildObjectB (ResultSet rs) throws DataAccessException{
		Site currSite = new Site();
		try {
			currSite.setSiteId(rs.getInt("siteId"));
			currSite.setCustomer(new Customer(rs.getInt("customerId")));
			currSite.setAddress(new Address(rs.getInt("addressId")));
			currSite.setTypeOfSite(rs.getString("type"));
			currSite.setSizeOfArea(rs.getDouble("areaSize"));
			currSite.setOpenHour(rs.getString("openHour"));
			currSite.setCloseHour(rs.getString("closeHour"));
			currSite.setStatus(rs.getBoolean("status"));
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return currSite;
	}
}


