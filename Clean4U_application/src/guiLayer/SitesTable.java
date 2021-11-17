package guiLayer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelLayer.Site;

public class SitesTable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private List<Site> data;
	private static final String[] COL_NAMES={ "ID", "Customer Id", "Address Id", "Type", "Size of Area", "Openning hour", "Closing hour", "status" };
	
		public SitesTable () {
			setData(null);
		}
		public SitesTable (List<Site> data) {
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
		
		public void setData(List<Site> data) {
			if (data !=null) {
				this.data =data;
			}else {
				this.data =new ArrayList<>(0);
			}
			super.fireTableDataChanged();
		}
		
		public Site getSiteOfRow (int index) {
			if (index < 0 || index >= data.size()) {
				return null;
		}
			return this.data.get(index);
		}	
			
			@Override
			public Object getValueAt(int row, int column) {
				Site s = data.get(row);
				switch (column) {
				case 0:
					return s.getSiteId();
				case 1:
					return s.getCustomer().getId();
				case 2:
					return s.getAddress().getAddressId();
				case 3:
					return s.getTypeOfSite();
				case 4:
					return s.getSizeOfArea();
				case 5:
					return s.getOpenHour();
				case 6:
					return s.getCloseHour();
				case 7:
					return s.getStatus();
				default:
					return "UNKNOWN COL NAME";
				}
			}
			
			@Override
			public int getRowCount() {
				return data.size();
			}
		

}
