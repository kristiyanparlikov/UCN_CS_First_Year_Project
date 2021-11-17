package guiLayer;

import java.util.List;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import modelLayer.Customer;

public class CompanyTable extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Customer> data;
	private static final String[] COL_NAMES={ "ID", "Tax number", "Company name", "First name", "Last name", "Phone number", "Email", "Note" };
	
		public CompanyTable () {
			setData(null);
		}
		public CompanyTable (List<Customer> data) {
			setData(data);
		}
		
		public Customer getCustomerById(int id) {
			for(Customer customer : data) {
				if(customer.getId() == id) {
					return customer;
				}
			}
			return null;
		}
		
		@Override
		public int getColumnCount() {
			return COL_NAMES.length;
		}
		
		@Override
		public String getColumnName (int column) {
			return COL_NAMES[column];
		}
		
		public void setData(List<Customer> data) {
			if (data !=null) {
				this.data =data;
			}else {
				this.data =new ArrayList<>(0);
			}
			super.fireTableDataChanged();
		}
		
		public Customer getCustomerOfRow (int index) {
			if (index < 0 || index >= data.size()) {
				return null;
		}
			return this.data.get(index);
		}	
			
			@Override
			public Object getValueAt(int row, int column) {
				Customer c = data.get(row);
				switch (column) {
				case 0:
					return c.getId();
				case 1:
					return c.getTaxNum();
				case 2:
					return c.getCompanyName();
				case 3:
					return c.getFirstName();
				case 4:
					return c.getLastName();
				case 5:
					return c.getPhoneNumber();
				case 6:
					return c.getEmail();
				case 7:
					return c.getNote();
				default:
					return "UNKNOWN COL NAME";
				}
			}
			
			@Override
			public int getRowCount() {
				return data.size();
			}
		

}

