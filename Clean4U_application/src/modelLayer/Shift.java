package modelLayer;

import java.util.Date;

public class Shift {
	private int shiftId;
	private int serviceId;
	private int employeeId;
	private Date date;
	private Date startHour;
	private Date endHour;
	
	public Shift(int serviceId, int employeeId, Date date, Date startHour, Date endHour) {
		this.serviceId = serviceId;
		this.employeeId = employeeId;
		this.date = date;
		this.startHour = startHour;
		this.endHour = endHour;
	}
	
	public Shift(int shiftId, int serviceId, int employeeId, Date date, Date startHour, Date endHour) {
		this.shiftId = shiftId;
		this.serviceId = serviceId;
		this.employeeId = employeeId;
		this.date = date;
		this.startHour = startHour;
		this.endHour = endHour;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getStartHour() {
		return startHour;
	}
	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}
	public Date getEndHour() {
		return endHour;
	}
	public void setEndHour(Date endHour) {
		this.endHour = endHour;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getShiftId() {
		return shiftId;
	}
	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}
	
	
}
