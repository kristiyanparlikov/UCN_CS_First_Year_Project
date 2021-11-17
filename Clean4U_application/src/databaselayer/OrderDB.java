package databaselayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.OrderLine;
import modelLayer.ProductDescription;
import modelLayer.RequestedProducts;
import modelLayer.Service;
import modelLayer.Warehouse;

public class OrderDB {
	
	/**
	public List<RequestedProducts> getAllOrders() {

		List<RequestedProducts> orders = new ArrayList<>();

		String query = "SELECT * FROM RequestedProducts";

		try {
			ResultSet res = dbcon.executeQuery(query);
			ProductDB productDB = new ProductDB();
			ServiceDB serviceDB = new ServiceDB();
			WarehouseDB warehouseDB = new WarehouseDB();
			


			while (res.next()) {
				
				Service service = serviceDB.getSpecificService(res.getInt("serviceId"));
				Warehouse warehouse = warehouseDB.getSpecificWarehouse(res.getInt("warehouseId"));

				// Get the Order from the DB
				RequestedProducts order = new RequestedProducts(
						res.getInt("orderId"),
						service, 
						warehouse,
						res.getDate("date").toLocalDate());
				
				//TODO -- probably have to make the second part in a while loop because there might me more orderlines in one order

				// Get the SalesLineItem from the DB
				String lineQuery = "SELECT * FROM 'OrderLine' WHERE orderId=" + order.getOrderId();
				ResultSet lineRes = dbcon.executeQuery(lineQuery);
				OrderLine orderLine = new OrderLine(
						lineRes.getInt("orderLineId"),
						lineRes.getInt("quantity"));

				// Get the Product from the DB
				ProductDescription product = productDB.getSpecificProduct(lineRes.getInt("productID"));
				orderLine.setProduct(product);
				order.addOrderLine(orderLine);

				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}
	*/
	/**
	public RequestedProducts getOrderByID(int id) {
		ServiceDB serviceDB = new ServiceDB();
		WarehouseDB warehouseDB = new WarehouseDB();

		RequestedProducts order = null;
		String query = "SELECT * FROM RequestedProducts WHERE RPOrderId=" + id;

		ResultSet res;
		try {
			res = dbcon.executeQuery(query);
			res.next();
			order = new RequestedProducts(
					res.getInt("RPOrderId"),
					serviceDB.getSpecificService(res.getInt("serviceId")),
					warehouseDB.getSpecificWarehouse(res.getInt("warehouseId")),
					res.getDate("date").toLocalDate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	*/
	
	
	
}
