package guiLayer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelLayer.Employee;

public class EmployeeTable extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private List<Employee> data;
	private static final String[] COL_NAMES={ "ID", "First name", "Last name", "Phone number", "Email", "ManagerId", "Salary", "Specialization" };
	
		public EmployeeTable () {
			setData(null);
	}
		public EmployeeTable (List<Employee> data) {
			setData(data);
		}
	
		@Override
		public int getColumnCount() {
			return COL_NAMES.length;
		}
		
		@Override
		public String getColumnName (int column) {
			return COL_NAMES[column];
		}
		
		public void setData(List<Employee> data) {
			if (data !=null) {
				this.data =data;
			}else {
				this.data =new ArrayList<>(0);
			}
			super.fireTableDataChanged();
		}
		
		public Employee getEmployeeOfRow (int index) {
			if (index < 0 || index >= data.size()) {
				return null;
		}
			return this.data.get(index);
		}	
			
			@Override
			public Object getValueAt(int row, int column) {
				Employee e = data.get(row);
				switch (column) {
				case 0:
					return e.getId();
				case 1:
					return e.getFirstName();
				case 2:
					return e.getLastName();
				case 3:
					return e.getPhoneNumber();
				case 4:
					return e.getEmail();
				case 5:
					return e.getManager().getId();
				case 6:
					return e.getSalary();
				case 7:
					return e.getSpecialization();
				default:
					return "UNKNOWN COL NAME";
				}
			}
			
			@Override
			public int getRowCount() {
				return data.size();
			}
		

}
