package guiLayer;

import java.awt.Component;
import modelLayer.Employee;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;


public class EmployeeListCellRenderer extends DefaultListCellRenderer {
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
//		return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		Employee currEmployee = (Employee) value;
		String representation = "";
		if (currEmployee != null) {
			representation = String.format("%s %s %s", currEmployee.getId(),currEmployee.getFirstName(), currEmployee.getLastName());
		}
		return new JLabel(representation);
	}

}
