package controllerLayer;

import java.util.Date;

import modelLayer.OrderLine;
import modelLayer.RequestedProducts;

public class OrderController { 
	
	/*RequestedProducts management - ProductDB under construction*/
	/**
	//insert RequestedProduct
	public boolean insertRequstedProduct (RequestedProducts requestedProducts)throws DataAccessException {
		requestedProductsDB.insert(requestedProducts);
		return requestedProducts;
	}
	//update RequestedProducts
	public void updateRequestedProduct(int serviceId, int warehouseId, int orderID, Date date, double totalCost) throws DataAccessException{
		requestedProductsDB.update(orderID);
	}
	//find requestedProductsDB
	public RequestedProducts findRequestedProducts (int orderID) throws DataAccessException {
		return requestedProductsDB.find(orderID);
	}
	//delete RequestedProducts
	public RequestedProducts deleteRequestedProducts(RequestedProducts requestedProducts) throws DataAccessException {
		requestedProductsDB.delete(requestedProducts);
		return requestedProducts;
	}
	*/
	
	/*orderLine management - currently under construction*/
	//insert orderLine
	/**
	public OrderLine insertOrderLine (OrderLine orderLine)throws DataAccessException {
		orderLineDB.insert(orderLine);
		return orderLine;
	}
	//update orderLine
	public void updateOrderLine(int id, int orderId, int productId,int quantity) throws DataAccessException{
		orderLineDB.update(id);
	}
	//find orderLine
	public OrderLine findOrderLine (int id) throws DataAccessException {
		return orderLineDB.find(id);
	}
	//delete orderLine
	public OrderLine deleteOrderLine(OrderLine orderLine) throws DataAccessException {
		orderLineDB.delete(orderLine);
		return orderLine;
	}
	*/
	
	
	
}
