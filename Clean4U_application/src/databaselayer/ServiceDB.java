package databaselayer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Service;
import modelLayer.Site;

public class ServiceDB implements ServiceDBIF {
	private SiteDB siteDB;
	
	private static final String FIND_ALL_Q = "SELECT * FROM Services";
	private PreparedStatement findAllPS;
	
	private static final String FIND_ALL_SITE_SERVICES_Q = FIND_ALL_Q + " WHERE siteId = ?";
	private PreparedStatement findAllSiteServicesPS;
	
	private static final String FIND_BY_ID_Q = FIND_ALL_Q + " WHERE serviceId = ?";
	private PreparedStatement findByIdPS;
	
	private static final String INSERT_Q = "INSERT INTO Service (siteId, type, specifics) VALUES (?,?,?)";
	private PreparedStatement insertPS;
	
	private static final String DELETE_Q = "DELETE FROM Service WHERE serviceId = ?";
	private PreparedStatement deletePS;
	
	private static final String UPDATE_Q = "UPDATE Service SET siteId = ?, type = ?, specifics=? WHERE serviceId = ?";
	private PreparedStatement updatePS;
	
	public ServiceDB()throws DataAccessException{
		siteDB= new SiteDB();
		init();
	}
	
	private void init() throws DataAccessException{
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findAllSiteServicesPS = con.prepareStatement(FIND_ALL_SITE_SERVICES_Q);
			insertPS = con.prepareStatement(INSERT_Q);
			deletePS = con.prepareStatement(DELETE_Q);
			updatePS = con.prepareStatement(UPDATE_Q);
			findByIdPS = con.prepareStatement(FIND_BY_ID_Q);
		}catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	@Override
	public List<Service> findAllSiteServices(Site site, boolean fullAssociation) throws DataAccessException {
		ResultSet rs;
		try {
			findAllSiteServicesPS.setInt(1,site.getSiteId());
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not bind or execute query", e);
		}
		try {
			rs = this.findAllSiteServicesPS.executeQuery();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		List<Service> res = buildObjects(rs, fullAssociation);
		return res;
	}
	
	private Service buildObject(ResultSet rs, boolean fullAssociation) throws DataAccessException {
		Service currService = new Service();
		try {
			currService.setServiceId(rs.getInt("serviceId"));
			currService.setSite(new Site(rs.getInt("siteId")));
			currService.setType(rs.getString("type"));
			currService.setSpecifics(rs.getString("specifics"));
			if (fullAssociation) {
				Site site = siteDB.findSiteById(rs.getInt("siteId")); 
																								
				currService.setSite(site);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return currService;
	}
	
	private List<Service> buildObjects(ResultSet rs, boolean fullAssociation) throws DataAccessException {
		List<Service> res = new ArrayList<>();
		try {
			while (rs.next()) {
				Service currService = buildObject(rs, fullAssociation);
				res.add(currService);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return res;
	}

	@Override
	public Service insert(Service service) throws DataAccessException {
		try {
			insertPS.setInt(1, service.getSite().getSiteId());
			insertPS.setString(2, service.getType());
			insertPS.setString(3, service.getSpecifics());
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

		return service;
	}

	@Override
	public boolean delete(Service service) throws DataAccessException {
		try {
			deletePS.setInt(1,service.getServiceId());
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
	public boolean update(Service service) throws DataAccessException {
		try {
			//set fields
			updatePS.setInt(1, service.getSite().getSiteId());
			updatePS.setString(2, service.getType());
			updatePS.setString(3, service.getSpecifics());
			//where
			updatePS.setInt(8,service.getServiceId());
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
	
	public Service buildObjectB (ResultSet rs) throws DataAccessException{
		Service currService = new Service();
		try {
			currService.setServiceId(rs.getInt("serviceId"));
			currService.setSite(new Site(rs.getInt("siteId")));
			currService.setType(rs.getString("type"));
			currService.setSpecifics(rs.getString("specifics"));
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not read resultset", e);
		}
		return currService;
	}
	
	
}
