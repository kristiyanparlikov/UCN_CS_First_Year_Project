package guiLayer;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controllerLayer.DataAccessException;
import controllerLayer.PersonController;
import modelLayer.Customer;
import modelLayer.Employee;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEmployee extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField field_firstName;
	private JTextField field_lastName;
	private JTextField field_phone;
	private JTextField field_email;
	private JTextField field_salary;
	private JTextField field_note;
	private JTextField textField;
	private JTable tblEmployee;
	private PersonController personCtr;
	private EmployeeTable employeeTable;
	private JComboBox<Employee> cmbManager;
	private JComboBox<String> cmbSpecialization;

	/**
	 * Create the panel.
	 * @throws DataAccessException 
	 */
	public PanelEmployee() throws DataAccessException {
		setVisible(true);
		setBounds(0, 0, 919, 401);
		setLayout(null);
		
		//PANEL CREATE
        JPanel panelCreate = new JPanel();
        panelCreate.setBackground(Color.WHITE);
        panelCreate.setBounds(519, 0, 400, 401);
        add(panelCreate);
        panelCreate.setLayout(null);
        
        //Text fields for panel create
        field_firstName = new JTextField();
        field_firstName.setColumns(10);
        field_firstName.setBounds(195, 42, 179, 28);
        panelCreate.add(field_firstName);
        
        field_lastName = new JTextField();
        field_lastName.setColumns(10);
        field_lastName.setBounds(195, 83, 179, 28);
        panelCreate.add(field_lastName);
        
        field_phone = new JTextField();
        field_phone.setColumns(10);
        field_phone.setBounds(195, 124, 179, 28);
        panelCreate.add(field_phone);
        
        field_email = new JTextField();
        field_email.setColumns(10);
        field_email.setBounds(195, 165, 179, 28);
        panelCreate.add(field_email);
        
        field_salary = new JTextField();
        field_salary.setColumns(10);
        field_salary.setBounds(195, 247, 179, 28);
        panelCreate.add(field_salary);
        
        field_note = new JTextField();
        field_note.setColumns(10);
        field_note.setBounds(195, 328, 179, 28);
        panelCreate.add(field_note);
        
        //button create
        JButton btnCreate = new JButton("CREATE");
        btnCreate.addActionListener(e -> {
			try {
				btnCreateClicked(e);
			} catch (DataAccessException ex) {
				ex.printStackTrace();
			}
		});
        btnCreate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnCreate.setBackground(new Color(0, 153, 255));
        btnCreate.setBounds(242, 363, 112, 25);
        panelCreate.add(btnCreate);
        
        //label(text) on top create new company
        JLabel lblCreateNewCompany = new JLabel("CREATE NEW EMPLOYEE");
        lblCreateNewCompany.setForeground(new Color(0, 153, 255));
        lblCreateNewCompany.setBackground(new Color(0, 153, 255));
        lblCreateNewCompany.setFont(new Font("Sitka Small", Font.PLAIN, 17));
        lblCreateNewCompany.setBounds(95, 13, 237, 16);
        panelCreate.add(lblCreateNewCompany);
        
        //separator
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 153, 255));
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(12, 0, 17, 401);
        panelCreate.add(separator);
        
        //labels(text) for creating employee
        JLabel lblCvr = new JLabel("First name");
        lblCvr.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblCvr.setBounds(41, 38, 112, 35);
        panelCreate.add(lblCvr);
        
        JLabel lblNewLabel_1_1 = new JLabel("Last name");
        lblNewLabel_1_1.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(41, 79, 112, 35);
        panelCreate.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Phone ");
        lblNewLabel_1_2.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(41, 120, 112, 35);
        panelCreate.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Email");
        lblNewLabel_1_3.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_3.setBounds(41, 161, 112, 35);
        panelCreate.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_4 = new JLabel("ManagerID");
        lblNewLabel_1_4.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_4.setBounds(41, 202, 112, 35);
        panelCreate.add(lblNewLabel_1_4);
        
        JLabel lblNewLabel_1_5 = new JLabel("Salary");
        lblNewLabel_1_5.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_5.setBounds(41, 243, 112, 35);
        panelCreate.add(lblNewLabel_1_5);
        
        JLabel lblNewLabel_1_6 = new JLabel("Specialization");
        lblNewLabel_1_6.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_6.setBounds(41, 281, 125, 35);
        panelCreate.add(lblNewLabel_1_6);
        
        JLabel lblNewLabel_1_6_1 = new JLabel("Note");
        lblNewLabel_1_6_1.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_6_1.setBounds(41, 321, 125, 35);
        panelCreate.add(lblNewLabel_1_6_1);
        
        cmbManager = new JComboBox<>();
        cmbManager.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbManager.setBackground(new Color(0, 153, 255));
        cmbManager.setBounds(195, 206, 179, 28);
        panelCreate.add(cmbManager);
        
        cmbSpecialization = new JComboBox<>();
        cmbSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbSpecialization.setBackground(new Color(0, 153, 255));
        cmbSpecialization.setBounds(195, 287, 179, 28);
        panelCreate.add(cmbSpecialization);
        
        JButton btnClear = new JButton("CLEAR");
        btnClear.addActionListener(this::btnClearClicked);
        btnClear.setFont(new Font("Sitka Text", Font.PLAIN, 18));
        btnClear.setBackground(new Color(0, 153, 255));
        btnClear.setBounds(76, 363, 99, 25);
        panelCreate.add(btnClear);
        
        
        //PANEL DISPLAY
        JPanel panelDisplay = new JPanel();
        panelDisplay.setBackground(Color.WHITE);
        panelDisplay.setBounds(0, 0, 530, 401);
        add(panelDisplay);
        panelDisplay.setLayout(null);
        
        //search field
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(135, 13, 164, 28);
        panelDisplay.add(textField);
        
        //button for search
        JButton btnFind = new JButton("FIND");
        btnFind.addActionListener(this::btnFindClicked);
        btnFind.setFont(new Font("Sitka Text", Font.PLAIN, 18));
        btnFind.setBackground(new Color(0, 153, 255));
        btnFind.setBounds(299, 13, 99, 28);
        panelDisplay.add(btnFind);
        
        //edit button
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(e -> {
			try {
				btnUpdateClicked(e);
			} catch (DataAccessException e2) {
				e2.printStackTrace();
			}
		});
        btnUpdate.setBackground(new Color(0, 153, 255));
        btnUpdate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnUpdate.setBounds(96, 363, 125, 25);
        panelDisplay.add(btnUpdate);
        
        //delete button
        JButton btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(e -> {
			try {
				btnDeleteClicked(e);
			} catch (DataAccessException e1) {
				e1.printStackTrace();
			}
		});
        btnDelete.setBackground(new Color(0, 153, 255));
        btnDelete.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnDelete.setBounds(324, 363, 113, 25);
        panelDisplay.add(btnDelete);
        
        //scroll pane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 73, 506, 260);
        panelDisplay.add(scrollPane);
        
        //employee table
        tblEmployee = new JTable();
        scrollPane.setViewportView(tblEmployee);
        tblEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblEmployee.setBackground(new Color(102, 204, 204));
        
        JButton btnResetTable = new JButton("RESET");
        btnResetTable.setBackground(new Color(0, 153, 255));
        btnResetTable.addActionListener(e -> {
			try {
				btnResetClicked(e);
			} catch (DataAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        btnResetTable.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnResetTable.setBounds(12, 37, 118, 23);
        panelDisplay.add(btnResetTable);
        
        init();
        listAllEmployees();
	}
	
	
	private void init() {
		try {
			this.personCtr = new PersonController();
		} catch (DataAccessException e) {
			complain("Data store error", "Could not establish connection to the data storage", e);
		}
		// init table model for employee list and associate to the Employee table
		this.employeeTable = new EmployeeTable();
		this.tblEmployee.setModel(employeeTable);
		
		// listen to selection changes in the Employee table
		this.tblEmployee.getSelectionModel().addListSelectionListener((e) -> tblEmployeeSelectionChanged());

		this.cmbManager.setRenderer(new EmployeeListCellRenderer());
		
		// fill combo-boxes
		try {
			this.fillManagerCmb();
		} catch (DataAccessException e) {
			// e1.printStackTrace();
			complain("Data store error", "Could not fill list of managers", e);
		}
		fillSpecializationCmb();
	}
	private void complain(String title, String text, Exception e) {
		JOptionPane.showMessageDialog(this, text + " (" + e.getMessage() + ") ", title, JOptionPane.OK_OPTION);
	}
	
	private void fillManagerCmb() throws DataAccessException {
		List<Employee> employees = this.personCtr.getAllEmployees();
		Employee currEmployee = getCurrentEmployee();
		if (currEmployee != null) {
			employees.remove(currEmployee);
		}
		DefaultComboBoxModel<Employee> supervisorComboBoxModel = new DefaultComboBoxModel<>();
		for (int i = 0; i < employees.size(); i++) {
			supervisorComboBoxModel.addElement(employees.get(i));
		}
		this.cmbManager.setModel(supervisorComboBoxModel);
		this.cmbManager.setSelectedItem(currEmployee != null ? currEmployee.getManager() : null);
	}
	
	private void fillSpecializationCmb() {
		DefaultComboBoxModel<String> specializationModel = new DefaultComboBoxModel<>(new String[] {"Floor cleaner", "Window cleaner", "Facade cleaner", "Escalator cleaner", "Disinfectionist", "Snow cleaner"});
		cmbSpecialization.setModel(specializationModel);
	}
	
	private Object tblEmployeeSelectionChanged() {
		Employee employee = getCurrentEmployee();
		displayEmployeeObject(employee);
		return null;
	}
	
	private void btnResetClicked(ActionEvent e) throws DataAccessException {
			listAllEmployees();
			textField.setText("");
	}
	
	//we have to check this method for display company in the table
	private Employee getCurrentEmployee() {
		int selectedRow = this.tblEmployee.getSelectedRow();
		Employee employee = null;
		if (selectedRow > -1) {
			employee = this.employeeTable.getEmployeeOfRow(selectedRow);
		}
		return employee;	
		
	}
	
	private void btnFindClicked(ActionEvent e) {
		try {
			int employeeId = Integer.parseInt(textField.getText());
			List<Employee> employees = new ArrayList<>();
			Employee employee = this.personCtr.findEmployeeById(employeeId);
			employees.add(employee);
			employeeTable.setData(employees);
			for(Employee empl : employees) {
				System.out.println(empl);
			}
		}catch (Exception ex) {
			complain("Application error", "Could not find employees by id.", ex);
		}
	}
	
	private void displayEmployeeObject(Employee currEmployee) {
		String firstName = "";
		String lastName="";
		String phoneNum="";
		String email="";
		String salary="";
		String specialization = "";
		String note = "";
		Employee manager = null;
		
		if (currEmployee !=null) {
			firstName = currEmployee.getFirstName();
			lastName = currEmployee.getLastName();
			phoneNum= currEmployee.getPhoneNumber();
			email = currEmployee.getEmail();
			salary = String.format(Locale.US,"%.2f", currEmployee.getSalary());
			specialization = currEmployee.getSpecialization();
			note = currEmployee.getNote();
			manager = currEmployee.getManager();
		}
		field_firstName.setText(firstName);
		field_lastName.setText(lastName);
		field_phone.setText(phoneNum);
		field_email.setText(email);
		field_salary.setText(salary);
		cmbSpecialization.setSelectedItem(specialization);
		field_note.setText(note);
		cmbManager.setSelectedItem(manager);
		
		try {
			fillManagerCmb();
		} catch (DataAccessException e) {
			// e.printStackTrace();
			complain("Data access error", "Could not fill supervisor list", e);
		}fillSpecializationCmb();
	}
	
	private void btnCreateClicked(ActionEvent e) throws DataAccessException {
		String firstName = field_firstName.getText();
		String lastName = field_lastName.getText();
		String phoneNum = field_phone.getText();
		String email = field_email.getText();
		String salaryStr = field_salary.getText();
		String specialization = (String) cmbSpecialization.getSelectedItem();
		String note = field_note.getText();
		Employee manager = (Employee) cmbManager.getSelectedItem();
		try {
			double salary = Double.parseDouble(salaryStr);
			try {
				personCtr.insertEmployee(firstName, lastName, phoneNum, email, manager, salary, specialization, note);
			} catch (DataAccessException dae) {
				// e1.printStackTrace();
				complain("Data access error", "Could not insert new employee", dae);
			}
		}catch (NumberFormatException nfe) {
			complain("Input error", "Salary must be floating point value (nnn.nn)", nfe);
		}
		listAllEmployees();
	}
	
	private void btnDeleteClicked(ActionEvent e) throws DataAccessException {
		try {
			personCtr.deleteEmployee(getCurrentEmployee());
		}catch (Exception ex) {
			complain("Application error", "Could not delete employee.", ex);
		}
		listAllEmployees();
	}
	
	private void btnUpdateClicked(ActionEvent e) throws DataAccessException {
		try {
			Employee employee = getCurrentEmployee();
			employee.setFirstName(field_firstName.getText());
			employee.setLastName(field_lastName.getText());
			employee.setPhoneNumber(field_phone.getText());
			employee.setEmail(field_email.getText());
			employee.setManager((Employee) cmbManager.getSelectedItem()); 
			employee.setSalary(Double.parseDouble(field_salary.getText()));
			employee.setSpecialization((String)cmbSpecialization.getSelectedItem());
			employee.setNote(field_note.getText());
			personCtr.updateEmployee(employee);
		}catch (Exception ex) {
			complain("Application error", "Could not update employee.", ex);
		}
		listAllEmployees();
	}
	
	private void listAllEmployees() throws DataAccessException {
		List<Employee> employees = personCtr.getAllEmployees();
		employeeTable.setData(employees);
	}
	
	private void btnClearClicked(ActionEvent e) {
		tblEmployee.getSelectionModel().clearSelection();
		displayEmployeeObject(null);
	}
}