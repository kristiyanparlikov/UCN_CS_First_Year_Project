package guiLayer;

import java.awt.CardLayout;
import java.awt.Color;
import modelLayer.Customer;
import controllerLayer.DataAccessException;
import controllerLayer.PersonController;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JSplitPane;

public class PanelCompany extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textSearch;
	private JTextField field_taxnumber;
	private JTextField field_companyName;
	private JTextField field_firstName;
	private JTextField field_lastName;
	private JTextField field_phone;
	private JTextField field_email;
	private JTextField field_note;
	private JTable tblCompany;
	private CompanyTable companyTable;
	private PersonController personCtr;
	private PanelSites panelSites;
	private static EditorPanel editorPanel;
	
	

	/**
	 * Create the panel.
	 * @throws DataAccessException 
	 */
	public PanelCompany() throws DataAccessException  {
		companyTable = new CompanyTable();
		editorPanel = EditorPanel.getInstance();
		
		CardLayout cards = new CardLayout();
		setBackground(Color.WHITE);
		setBounds(0, 0, 919, 401);
        setLayout(null);
       
        
        //PANEL DISPLAY
        JPanel panelDisplay = new JPanel();
        panelDisplay.setBounds(0, 0, 530, 401);
        add(panelDisplay);
        panelDisplay.setBackground(Color.WHITE);
        panelDisplay.setLayout(null);
        
        //search field
        textSearch = new JTextField();
        textSearch.setBounds(142, 13, 158, 28);
        panelDisplay.add(textSearch);
        textSearch.setColumns(10);
        
        //button for search
        JButton btnFind = new JButton("FIND");
        btnFind.addActionListener(this::btnFindClicked);
        btnFind.setFont(new Font("Sitka Text", Font.PLAIN, 18));
        btnFind.setBackground(new Color(0, 153, 255));
        btnFind.setBounds(299, 13, 99, 28);
        panelDisplay.add(btnFind);
        
        //button to open the company
        JButton btnOpen = new JButton("OPEN");
        btnOpen.addActionListener(e -> {
			try {
				btnOpenClicked(e);
			} catch (DataAccessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
        btnOpen.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnOpen.setBackground(new Color(0, 153, 255));
        btnOpen.setBounds(58, 363, 105, 25);
        panelDisplay.add(btnOpen);
        
        //edit button
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(e -> {
			try {
				btnUpdateClicked(e);
			} catch (DataAccessException dae) {
				// TODO Auto-generated catch block
				dae.printStackTrace();
			}
		});
        btnUpdate.setBackground(new Color(0, 153, 255));
        btnUpdate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnUpdate.setBounds(206, 363, 123, 25);
        panelDisplay.add(btnUpdate);
        
        //delete button
        JButton btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(e -> {
			try {
				btnDeleteClicked(e);
			} catch (DataAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        btnDelete.setBackground(new Color(0, 153, 255));
        btnDelete.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnDelete.setBounds(375, 363, 113, 25);
        panelDisplay.add(btnDelete);
        
        //scroll pane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 73, 506, 260);
        panelDisplay.add(scrollPane);
        
        //company table
        tblCompany = new JTable();
        tblCompany.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCompany.setBackground(new Color(102, 204, 204));
        scrollPane.setViewportView(tblCompany);
        
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
        btnResetTable.setBounds(12, 37, 118, 23);
        btnResetTable.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        panelDisplay.add(btnResetTable);
        
        //PANEL CREATE
        JPanel panelCreate = new JPanel();
        panelCreate.setBounds(519, 0, 400, 401);
        add(panelCreate);
        panelCreate.setBackground(Color.WHITE);
        panelCreate.setLayout(null);
        
        //Labels in panel create
        JLabel lblTax = new JLabel("Tax number");
        lblTax.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblTax.setBounds(41, 43, 112, 35);
        panelCreate.add(lblTax);
        
        JLabel lblCompanyName = new JLabel("Name");
        lblCompanyName.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblCompanyName.setBounds(41, 84, 112, 35);
        panelCreate.add(lblCompanyName);
        
        JLabel lblFirstName = new JLabel("First name");
        lblFirstName.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblFirstName.setBounds(41, 125, 112, 35);
        panelCreate.add(lblFirstName);
        
        JLabel lblLastName = new JLabel("Last name");
        lblLastName.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblLastName.setBounds(41, 166, 112, 35);
        panelCreate.add(lblLastName);
        
        JLabel lblNewLabel_1_4 = new JLabel("Phone");
        lblNewLabel_1_4.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_4.setBounds(41, 207, 112, 35);
        panelCreate.add(lblNewLabel_1_4);
        
        JLabel lblNewLabel_1_5 = new JLabel("E-mail");
        lblNewLabel_1_5.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_5.setBounds(41, 248, 112, 35);
        panelCreate.add(lblNewLabel_1_5);
        
        JLabel lblNewLabel_1_6 = new JLabel("Note");
        lblNewLabel_1_6.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_6.setBounds(41, 286, 112, 35);
        panelCreate.add(lblNewLabel_1_6);
        
        //Text fields for panel create
        field_taxnumber = new JTextField();
        field_taxnumber.setColumns(10);
        field_taxnumber.setBounds(193, 39, 179, 28);
        panelCreate.add(field_taxnumber);
        
        field_companyName = new JTextField();
        field_companyName.setColumns(10);
        field_companyName.setBounds(193, 80, 179, 28);
        panelCreate.add(field_companyName);
        
        field_firstName = new JTextField();
        field_firstName.setColumns(10);
        field_firstName.setBounds(193, 121, 179, 28);
        panelCreate.add(field_firstName);
        
        field_lastName = new JTextField();
        field_lastName.setColumns(10);
        field_lastName.setBounds(193, 162, 179, 28);
        panelCreate.add(field_lastName);
        
        field_phone = new JTextField();
        field_phone.setColumns(10);
        field_phone.setBounds(193, 203, 179, 28);
        panelCreate.add(field_phone);
        
        field_email = new JTextField();
        field_email.setColumns(10);
        field_email.setBounds(193, 244, 179, 28);
        panelCreate.add(field_email);
        
        field_note = new JTextField();
        field_note.setColumns(10);
        field_note.setBounds(193, 289, 179, 51);
        panelCreate.add(field_note);
        
        //button create
        JButton btnCreate = new JButton("CREATE");
        btnCreate.addActionListener(e -> {
			try {
				btnCreateClicked(e);
			} catch (DataAccessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
        btnCreate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnCreate.setBackground(new Color(0, 153, 255));
        btnCreate.setBounds(260, 365, 112, 25);
        panelCreate.add(btnCreate);
        
        //label(text) on top create new company
        JLabel lblCreateNewCompany = new JLabel("CREATE NEW COMPANY");
        lblCreateNewCompany.setForeground(new Color(0, 153, 255));
        lblCreateNewCompany.setBackground(new Color(0, 153, 255));
        lblCreateNewCompany.setFont(new Font("Sitka Small", Font.PLAIN, 17));
        lblCreateNewCompany.setBounds(119, 13, 213, 16);
        panelCreate.add(lblCreateNewCompany);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 153, 255));
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(12, 0, 17, 401);
        panelCreate.add(separator);
        
        JButton btnClear = new JButton("CLEAR");
        btnClear.addActionListener(this::btnClearClicked);
        btnClear.setFont(new Font("Sitka Text", Font.PLAIN, 18));
        btnClear.setBackground(new Color(0, 153, 255));
        btnClear.setBounds(97, 363, 99, 28);
        panelCreate.add(btnClear);

        init();
        listAllCompanies();
	}
	private void init() {
		try {
			this.personCtr = new PersonController();
		} catch (DataAccessException e) {
			complain("Data store error", "Could not establish connection to the data storage", e);
		}

		// init table model for employee list and associate to the Employee table
		this.companyTable = new CompanyTable();
		this.tblCompany.setModel(companyTable);

		// listen to selection changes in the Employee table
		this.tblCompany.getSelectionModel().addListSelectionListener((e) -> tblCompanySelectionChanged());}

	private void complain(String title, String text, Exception e) {
		JOptionPane.showMessageDialog(this, text + " (" + e.getMessage() + ") ", title, JOptionPane.OK_OPTION);
	}
	
	private Object tblCompanySelectionChanged() {
		Customer company = getCurrentCustomer();
		displayCompanyObject(company);
		return null;
	}
	
	//we have to check this method for display company in the table
		private Customer getCurrentCustomer() {
			int selectedRow = this.tblCompany.getSelectedRow();
			Customer company = null;
			if (selectedRow > -1) {
				company = this.companyTable.getCustomerOfRow(selectedRow);
			}
			return company;	
			
	}
		
	private void btnClearClicked(ActionEvent e) {
		tblCompany.getSelectionModel().clearSelection();
		displayCompanyObject(null);
	}

 
	private void displayCompanyObject(Customer company) {
		String taxNumber = "";
		String companyName="";
		String firstName="";
		String lastName="";
		String phoneNumber ="";
		String email="";
		String note ="";
		
		if (company !=null) {
			taxNumber = company.getTaxNum();
			companyName = company.getCompanyName();
			firstName= company.getFirstName();
			lastName = company.getLastName();
			phoneNumber = company.getPhoneNumber();
			email = company.getEmail();
			note = company.getNote();
		}
		field_taxnumber.setText(taxNumber);
		field_companyName.setText(companyName);
		field_firstName.setText(firstName);
		field_lastName.setText(lastName);
		field_phone.setText(phoneNumber);
		field_email.setText(email);
		field_note.setText(note);
	}
	
	private void btnFindClicked(ActionEvent e) {
		try {
			int companyId = Integer.parseInt(textSearch.getText());
			List<Customer> companies = new ArrayList<>();
			Customer customer = this.personCtr.findCustomerById(companyId);
			companies.add(customer);
			companyTable.setData(companies);
			for(Customer cust : companies) {
				System.out.println(cust);
			}
		}catch (Exception ex) {
			complain("Application error", "Could not find customers by id.", ex);
		}
		textSearch.setText("");
	}
	
	private void btnDeleteClicked(ActionEvent e) throws DataAccessException {
		try {
			personCtr.deleteCustomer(getCurrentCustomer());
		}catch (Exception ex) {
			complain("Application error", "Could not delete employee.", ex);
		}
		listAllCompanies();
	}
	
	public void listAllCompanies() throws DataAccessException {
		
		List<Customer> companies = personCtr.getAllCustomers();
		companyTable.setData(companies);
	}
	
	private void btnUpdateClicked(ActionEvent e) throws DataAccessException {
		try {
			Customer customer = getCurrentCustomer();
			customer.setTaxNum(field_taxnumber.getText());
			customer.setCompanyName(field_companyName.getText());
			customer.setFirstName(field_firstName.getText());
			customer.setLastName(field_lastName.getText());
			customer.setPhoneNumber(field_phone.getText());
			customer.setEmail(field_email.getText());
			customer.setNote(field_note.getText());
			personCtr.updateCustomer(customer);
		}catch (Exception ex) {
			complain("Application error", "Could not update customer.", ex);
		}
		listAllCompanies();
	}
	
	private void btnResetClicked(ActionEvent e) throws DataAccessException {
		listAllCompanies();
		textSearch.setText("");
	}
	
	private void btnOpenClicked(ActionEvent e) throws DataAccessException {
		Customer customer = getCurrentCustomer();
		editorPanel.openPanelSites(customer);
		
	}
	
	private void btnCreateClicked(ActionEvent e) throws DataAccessException {
		try {
			PersonController perCon = new PersonController();
			perCon.insertCustomer(
					field_taxnumber.getText(),
					field_companyName.getText(),
					field_firstName.getText(),
					field_lastName.getText(),
					field_phone.getText(),
					field_email.getText(),
					field_note.getText());
		}catch (DataAccessException dae){
			// e1.printStackTrace();
			complain("Data access error", "Could not insert new company", dae);
		}
		listAllCompanies();
	}
}

	
	

	
	
	
	
	
	
