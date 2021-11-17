package modelLayer;

import java.time.LocalDate;
import java.util.LinkedList; 

public class RequestedProducts {
	private int orderId;
	private LocalDate date;
	private LinkedList<OrderLine> orderLines;
	private Service service;
	private Warehouse warehouse;
	private double totalCost;
	
	public RequestedProducts(int orderId, Service service, Warehouse warehouse, LocalDate date) {
		this.orderId = orderId;
		this.setDate(date);
		this.setService(service);
		this.setWarehouse(warehouse);
		orderLines = new LinkedList<>();
		totalCost = getTotalCost();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderID) {
		this.orderId = orderID;
	}
	public boolean addOrderLine(OrderLine orderLine) {
		return orderLines.add(orderLine);
	}
	public double getTotalCost() {
		for(OrderLine ol : orderLines) {
			totalCost += ol.getCost();
		}
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public LinkedList<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(LinkedList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}
