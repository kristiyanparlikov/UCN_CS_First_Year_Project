package guiLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controllerLayer.AddressController;
import controllerLayer.DataAccessException;
import controllerLayer.PersonController;
import controllerLayer.SiteController;
import modelLayer.Address;
import modelLayer.Customer;
import modelLayer.Site;
import java.awt.event.ActionListener;

public class PanelSites extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField field_sizeArea;
	private JTextField field_openHour;
	private JTextField field_closeHour;
	private JTable tblSites;
	private SitesTable sitesTable;
	private Customer selectedCompany;
	private SiteController siteCtr;
	private JComboBox<String> cmbType;
	private JComboBox<Address> cmbAddress;
	private JComboBox<String> cmbStatus;
	private AddressController addressCtr;
	private JTextField field_Street;
	private JTextField field_StreetNum;
	private JTextField field_Country;
	private JTextField field_ZipCode;
	private JPanel panelAddress;
	private JPanel panelCreate;

	/**
	 * Create the panel.
	 * @throws DataAccessException 
	 */
	public PanelSites(Customer customer) throws DataAccessException {
		this.selectedCompany=customer;
		setVisible(true);
		setBounds(0, 0, 919, 401);
		setLayout(null);
        
        panelAddress = new JPanel();
        panelAddress.setLayout(null);
        panelAddress.setBackground(Color.WHITE);
        panelAddress.setBounds(519, 0, 400, 401);
        add(panelAddress);
        panelAddress.setVisible(false);
        
        JLabel lblCreateNewAddress = new JLabel("CREATE NEW ADDRESS");
        lblCreateNewAddress.setForeground(new Color(0, 153, 255));
        lblCreateNewAddress.setFont(new Font("Sitka Small", Font.PLAIN, 17));
        lblCreateNewAddress.setBackground(new Color(0, 153, 255));
        lblCreateNewAddress.setBounds(90, 11, 237, 29);
        panelAddress.add(lblCreateNewAddress);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBackground(new Color(0, 153, 255));
        separator_1.setBounds(12, 0, 17, 401);
        panelAddress.add(separator_1);
        
        JButton btnCreateAddress = new JButton("CREATE");
        btnCreateAddress.addActionListener(e -> {
			try {
				btnCreateAddressClicked(e);
			} catch (DataAccessException e4) {
				// TODO Auto-generated catch block
				//e4.printStackTrace();
			}
		});
        btnCreateAddress.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnCreateAddress.setBackground(new Color(0, 153, 255));
        btnCreateAddress.setBounds(214, 365, 113, 25);
        panelAddress.add(btnCreateAddress);
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblCountry.setBounds(54, 62, 112, 35);
        panelAddress.add(lblCountry);
        
        JLabel lblZipCode = new JLabel("Zipcode");
        lblZipCode.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblZipCode.setBounds(54, 103, 127, 35);
        panelAddress.add(lblZipCode);
        
        JLabel lblStreet = new JLabel("Street");
        lblStreet.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblStreet.setBounds(54, 144, 112, 35);
        panelAddress.add(lblStreet);
        
        JLabel lblStreetNum = new JLabel("Street Nº");
        lblStreetNum.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblStreetNum.setBounds(54, 185, 112, 35);
        panelAddress.add(lblStreetNum);
        
        field_Street = new JTextField();
        field_Street.setColumns(10);
        field_Street.setBounds(190, 152, 179, 28);
        panelAddress.add(field_Street);
        
        field_StreetNum = new JTextField();
        field_StreetNum.setColumns(10);
        field_StreetNum.setBounds(190, 193, 179, 28);
        panelAddress.add(field_StreetNum);
        
        field_Country = new JTextField();
        field_Country.setColumns(10);
        field_Country.setBounds(190, 68, 179, 28);
        panelAddress.add(field_Country);
        
        field_ZipCode = new JTextField();
        field_ZipCode.setColumns(10);
        field_ZipCode.setBounds(190, 109, 179, 28);
        panelAddress.add(field_ZipCode);
        
        JButton btnCancel = new JButton("CANCEL");
        btnCancel.addActionListener(e -> {
			try {
				btnCancelClicked(e);
			} catch (DataAccessException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		});
        btnCancel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnCancel.setBackground(new Color(0, 153, 255));
        btnCancel.setBounds(91, 365, 113, 25);
        panelAddress.add(btnCancel);
		
		//PANEL CREATE
        panelCreate = new JPanel();
        panelCreate.setBackground(Color.WHITE);
        panelCreate.setBounds(519, 0, 400, 401);
        add(panelCreate);
        panelCreate.setLayout(null);
        
        //label(text) on top create new site
        JLabel lblCreateNewCompany = new JLabel("CREATE NEW SITE");
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
        
        JButton btnCreate = new JButton("CREATE");
        btnCreate.addActionListener(e -> {
			try {
				btnCreateClicked(e);
			} catch (DataAccessException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		});
        btnCreate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnCreate.setBackground(new Color(0, 153, 255));
        btnCreate.setBounds(240, 363, 113, 25);
        panelCreate.add(btnCreate);
        
        JLabel lblNewLabel_1_1 = new JLabel("AddressID");
        lblNewLabel_1_1.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(54, 62, 112, 35);
        panelCreate.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Type");
        lblNewLabel_1_2.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(54, 103, 127, 35);
        panelCreate.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Size of area");
        lblNewLabel_1_3.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_3.setBounds(54, 144, 112, 35);
        panelCreate.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_3_1 = new JLabel("Open hour");
        lblNewLabel_1_3_1.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_3_1.setBounds(54, 185, 112, 35);
        panelCreate.add(lblNewLabel_1_3_1);
        
        JLabel lblNewLabel_1_3_1_1 = new JLabel("Close hour");
        lblNewLabel_1_3_1_1.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_3_1_1.setBounds(54, 226, 112, 35);
        panelCreate.add(lblNewLabel_1_3_1_1);
        

        JLabel lblNewLabel_1_3_1_2 = new JLabel("Status");
        lblNewLabel_1_3_1_2.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblNewLabel_1_3_1_2.setBounds(54, 268, 112, 35);
        panelCreate.add(lblNewLabel_1_3_1_2);
     
        //fields for create new site
        cmbAddress = new JComboBox<Address>();
        cmbAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbAddress.setBackground(new Color(0, 153, 255));
        cmbAddress.setBounds(190, 67, 179, 28);
        panelCreate.add(cmbAddress);
        
        field_sizeArea = new JTextField();
        field_sizeArea.setColumns(10);
        field_sizeArea.setBounds(190, 152, 179, 28);
        panelCreate.add(field_sizeArea);
        
        field_openHour = new JTextField();
        field_openHour.setColumns(10);
        field_openHour.setBounds(190, 193, 179, 28);
        panelCreate.add(field_openHour);
        
        field_closeHour = new JTextField();
        field_closeHour.setColumns(10);
        field_closeHour.setBounds(190, 234, 179, 28);
        panelCreate.add(field_closeHour);
        
        cmbStatus = new JComboBox<String>();
        cmbStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbStatus.setBounds(190, 275, 179, 28);
        panelCreate.add(cmbStatus);
        
        cmbType = new JComboBox<String>();
        cmbType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbType.setBackground(new Color(0, 153, 255));
        cmbType.setBounds(190, 111, 179, 28);
        panelCreate.add(cmbType);
        
        JButton btnAddAddress = new JButton("Add Address");
        btnAddAddress.addActionListener(e -> {
			try {
				btnAddAddressClicked(e);
			} catch (DataAccessException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		});
        btnAddAddress.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnAddAddress.setBackground(new Color(0, 153, 255));
        btnAddAddress.setBounds(58, 363, 158, 25);
        panelCreate.add(btnAddAddress);
        
        
        //PANEL DISPLAY
        JPanel panelDisplay = new JPanel();
        panelDisplay.setBackground(Color.WHITE);
        panelDisplay.setBounds(0, 0, 530, 401);
        add(panelDisplay);
        panelDisplay.setLayout(null);
        
        //edit button
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(e -> {
			try {
				btnUpdateClicked(e);
			} catch (DataAccessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
        btnUpdate.setBackground(new Color(0, 153, 255));
        btnUpdate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnUpdate.setBounds(116, 363, 129, 25);
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
        btnDelete.setBounds(299, 363, 113, 25);
        panelDisplay.add(btnDelete);
        
        //scroll pane for table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 73, 506, 260);
        panelDisplay.add(scrollPane);
        
        //table sites
        tblSites = new JTable();
        scrollPane.setViewportView(tblSites);
        JLabel lblCustomer = new JLabel("Company selected: " + selectedCompany.toString());
        lblCustomer.setBounds(12, 23, 506, 25);
        panelDisplay.add(lblCustomer);
   
        init();
        listAllCompanySites();
	}
	
	private void init() {
		try {
			this.siteCtr = new SiteController();
			this.addressCtr = new AddressController();
		}catch (DataAccessException e) {
			complain("Data store error", "Could not establish connection to the data storage", e);
		}
		
		this.sitesTable = new SitesTable();
		this.tblSites.setModel(sitesTable);
		
		this.tblSites.getSelectionModel().addListSelectionListener((e) -> tblSiteSelectionChanged());
		
		this.cmbAddress.setRenderer(new AddressListCellRenderer());
		try {
			fillTypeCmb();
		}catch (DataAccessException e) {
			// e.printStackTrace();
			complain("Data access error", "Could not fill site type list", e);
		}
		try {
			fillStatusCmb();
		}catch (DataAccessException e) {
			// e.printStackTrace();
			complain("Data access error", "Could not fill site status list", e);
		}
		try {
			fillAddressCmb();
		}catch (DataAccessException e) {
			// e.printStackTrace();
			complain("Data access error", "Could not fill addresses list", e);
		}
	}
	
	private void complain(String title, String text, Exception e) {
		JOptionPane.showMessageDialog(this, text + " (" + e.getMessage() + ") ", title, JOptionPane.OK_OPTION);
	}
	
	private void fillTypeCmb() throws DataAccessException {
		DefaultComboBoxModel<String> typeModel = new DefaultComboBoxModel<>(new String[] {"Office", "Gym", "House", "Clinics", "Hospital", "Mall"});
		cmbType.setModel(typeModel);
	}
	
	private void fillStatusCmb() throws DataAccessException {
		DefaultComboBoxModel<String> statusModel = new DefaultComboBoxModel<>(new String[] {"Active", "Inactive"});
		cmbStatus.setModel(statusModel);
	
	}
	
	private void fillAddressCmb() throws DataAccessException {
		List<Address> addresses = this.addressCtr.findAllAddresses();
		if(addresses != null) {
			DefaultComboBoxModel<Address> addressComboBoxModel = new DefaultComboBoxModel<>(addresses.toArray(new Address[addresses.size()]));
			this.cmbAddress.setModel(addressComboBoxModel);
			Site currSite = getCurrentSite();
			if (currSite != null) {
				this.cmbAddress.setSelectedItem(currSite.getAddress());
			}
		}
	}
	
	private Object tblSiteSelectionChanged() {
		Site site = getCurrentSite();
		displaySiteObject(site);
		return null;
	}
	
	private Site getCurrentSite() {
		int selectedRow = this.tblSites.getSelectedRow();
		Site site = null;
		if (selectedRow > -1) {
			site = this.sitesTable.getSiteOfRow(selectedRow);
		}
		return site;	
		
	}
	private void displaySiteObject(Site site) {
		Address address = null;
		String type = "";
		String sizeOfArea = "";
		String openHour = "";
		String closeHour = "";
		boolean status = false;
		
		if(site != null) {
			address = site.getAddress();
			type = site.getTypeOfSite();
			sizeOfArea = String.valueOf(site.getSizeOfArea());
			openHour = site.getOpenHour();
			closeHour = site.getCloseHour();
			status = site.getStatus();
		}
		if(status == true) {
			cmbStatus.setSelectedIndex(0);
		}else {
			cmbStatus.setSelectedIndex(1);
		}
		cmbAddress.setSelectedItem(address);
		cmbType.setSelectedItem(type);
		field_sizeArea.setText(sizeOfArea);
		field_openHour.setText(openHour);
		field_closeHour.setText(closeHour);
		
		
		try {
			fillTypeCmb();
		}catch (DataAccessException e) {
			// e.printStackTrace();
			complain("Data access error", "Could not fill site type list", e);
		}
		try {
			fillStatusCmb();
		}catch (DataAccessException e) {
			// e.printStackTrace();
			complain("Data access error", "Could not fill site status list", e);
		}
		try {
			fillAddressCmb();
		}catch (DataAccessException e) {
			// e.printStackTrace();
			complain("Data access error", "Could not fill addresses list", e);
		}
	}
	
	private void listAllCompanySites() throws DataAccessException {
		List<Site> sites = siteCtr.getAllCustomerSites(selectedCompany);
		if(sites.size()>0) {
			sitesTable.setData(sites);
		}else {
			JOptionPane.showMessageDialog(null, "Customer has no sites created. Click OK to create one!");
		}
	}
	
	private void btnCreateClicked(ActionEvent e) throws DataAccessException{
		
			Address address = (Address) cmbAddress.getSelectedItem();
			String type = (String) cmbType.getSelectedItem();
			String areaSizeStr = field_sizeArea.getText();
			String openHour = field_openHour.getText();
			String closeHour = field_closeHour.getText();
			String statusStr = (String) cmbStatus.getSelectedItem();
			boolean status = false;
			if (statusStr.equals("Active")){
				status = true;
			}
			try {
				double areaSize = Double.parseDouble(areaSizeStr);
				try {
					siteCtr.insertSite(this.selectedCompany, address, type, areaSize, openHour, closeHour, status);
				}catch (DataAccessException dae) {
					 dae.printStackTrace();
					complain("Data access error", "Could not insert new site", dae); 
					
				}
			}catch (NumberFormatException nfe) {
				complain("Input error", "Salary must be floating point value (nnn.nn)", nfe);
			}
		listAllCompanySites();
	}
	
	
	
	private void btnDeleteClicked(ActionEvent e) throws DataAccessException {
		try {
			siteCtr.deleteSite(getCurrentSite());
		}catch (Exception ex) {
			complain("Application error", "Could not delete employee.", ex);
		}
		listAllCompanySites();
	}
	
	private void btnUpdateClicked(ActionEvent e) throws DataAccessException {
		try {
			Site site = getCurrentSite();
			site.setCustomer(selectedCompany);
			site.setAddress((Address) cmbAddress.getSelectedItem());
			site.setTypeOfSite((String) cmbType.getSelectedItem());
			site.setSizeOfArea(Double.parseDouble(field_sizeArea.getText()));
			site.setOpenHour(field_openHour.getText());
			site.setCloseHour(field_closeHour.getText());
			if(cmbStatus.getSelectedItem().equals("Active")){
				site.setStatus(true);
			}else {
				site.setStatus(false);
			}
			siteCtr.updateSite(site);
		}catch (Exception ex) {
			complain("Application error", "Could not update site.", ex);
		}
		listAllCompanySites();
	}
	
	private void btnCancelClicked(ActionEvent e) throws DataAccessException {
		panelAddress.setVisible(false);
		panelCreate.setVisible(true);
	}
	
	private void btnAddAddressClicked(ActionEvent e) throws DataAccessException {
		panelCreate.setVisible(false);
		panelAddress.setVisible(true);
	}
	
	private void btnCreateAddressClicked(ActionEvent e) throws DataAccessException {
		String country = field_Country.getText();
		String zipCode = field_ZipCode.getText();
		String street = field_Street.getText();
		String streetNumStr = field_StreetNum.getText();
		
		try {
			int streetNum = Integer.parseInt(streetNumStr);
			try {
				addressCtr.insertAddress(country, zipCode, street, streetNum);
			}catch (DataAccessException dae) {
				 dae.printStackTrace();
				complain("Data access error", "Could not insert new address", dae);
			}
		}catch (NumberFormatException nfe) {
				complain("Input error", "Street Number must be a number ", nfe);
			}
		finally {
			fillAddressCmb();
			field_Country.setText("");	
			field_ZipCode.setText("");
			field_Street.setText("");
			field_StreetNum.setText("");
			panelAddress.setVisible(false);
			panelCreate.setVisible(true);
		}
	}
}

