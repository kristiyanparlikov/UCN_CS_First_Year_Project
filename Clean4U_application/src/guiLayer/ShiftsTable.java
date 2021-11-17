package guiLayer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelLayer.Shift;

public class ShiftsTable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private List<Shift> data;
	private static final String[] COL_NAMES={ "ID", "Service Id", "Employee Id", "Date", "Start hour", "End hour" };
	
		public ShiftsTable () {
			setData(null);
		}
		public ShiftsTable (List<Shift> data) {
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
		
		public void setData(List<Shift> data) {
			if (data !=null) {
				this.data =data;
			}else {
				this.data =new ArrayList<>(0);
			}
			super.fireTableDataChanged();
		}
		
		public Shift getSiteOfRow (int index) {
			if (index < 0 || index >= data.size()) {
				return null;
		}
			return this.data.get(index);
		}	
			
			@Override
			public Object getValueAt(int row, int column) {
				Shift s = data.get(row);
				switch (column) {
				case 0:
					return s.getShiftId();
				case 1:
					return s.getServiceId();
				case 2:
					return s.getEmployeeId();
				case 3:
					return s.getDate();
				case 4:
					return s.getStartHour();
				case 5:
					return s.getEndHour();
				default:
					return "UNKNOWN COL NAME";
				}
			}
			
			@Override
			public int getRowCount() {
				return data.size();
			}
		
}
