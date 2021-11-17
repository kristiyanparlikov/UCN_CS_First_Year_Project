package guiLayer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelLayer.Service;

public class ServicesTable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private List<Service> data;
	private static final String[] COL_NAMES={ "ID", "Site Id", "Type", "Specifics" };
	
		public ServicesTable () {
			setData(null);
		}
		public ServicesTable (List<Service> data) {
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
		
		public void setData(List<Service> data) {
			if (data !=null) {
				this.data =data;
			}else {
				this.data =new ArrayList<>(0);
			}
			super.fireTableDataChanged();
		}
		
		public Service getServiceOfRow (int index) {
			if (index < 0 || index >= data.size()) {
				return null;
		}
			return this.data.get(index);
		}	
			
			@Override
			public Object getValueAt(int row, int column) {
				Service s = data.get(row);
				switch (column) {
				case 0:
					return s.getServiceId();
				case 1:
					return s.getSite().getSiteId();
				case 2:
					return s.getType();
				case 3:
					return s.getSpecifics();
				default:
					return "UNKNOWN COL NAME";
				}
			}
			
			@Override
			public int getRowCount() {
				return data.size();
			}
		

}