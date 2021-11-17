package guiLayer;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import modelLayer.Address;

public class AddressListCellRenderer extends DefaultListCellRenderer{
	private static final long serialVersionUID = 1L;
	
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
//		return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		Address currAddress = (Address) value;
		String representation = "";
		if (currAddress != null) {
			representation = String.format("%s %s %s %d", currAddress.getAddressId(),currAddress.getCountry(), currAddress.getStreet(), currAddress.getStreetNumber() );
		}
		return new JLabel(representation);
	}

}
