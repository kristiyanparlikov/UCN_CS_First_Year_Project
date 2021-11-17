package guiLayer;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

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

import controllerLayer.DataAccessException;
import controllerLayer.SiteController;

import javax.swing.JComboBox;
import modelLayer.Employee;
import modelLayer.Site;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class PanelServices extends JPanel {
	private static final long serialVersionUID = 1L;
	private static EditorPanel editorPanel;
	private JTextField field_specific;
	private JTextField textSearch;
	private JTable table;
	private Site selectedSite;
	private SiteController siteCtr;
	private ServicesTable servicesTable;
	private JTable tblServices;
	
	/**
	 * Create the panel.
	 */
	public PanelServices(Site site) throws DataAccessException {
		selectedSite = site;
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
        textSearch.setBounds(139, 13, 160, 28);
        panelDisplay.add(textSearch);
        textSearch.setColumns(10);
        
        //button for search
        JButton btnFind = new JButton("FIND");
        btnFind.setFont(new Font("Sitka Text", Font.PLAIN, 18));
        btnFind.setBackground(new Color(0, 153, 255));
        btnFind.setBounds(299, 13, 99, 28);
        panelDisplay.add(btnFind);
        
        //edit button
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBackground(new Color(0, 153, 255));
        btnUpdate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnUpdate.setBounds(108, 363, 123, 25);
        panelDisplay.add(btnUpdate);
        
        //delete button
        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBackground(new Color(0, 153, 255));
        btnDelete.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnDelete.setBounds(311, 363, 113, 25);
        panelDisplay.add(btnDelete);
        
        //scroll pane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 73, 506, 260);
        panelDisplay.add(scrollPane);
        
        //company table
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"SiteID", "Type", "Specific"
        	}
        ));
        scrollPane.setViewportView(table);
        
        //reset button
        JButton btnResetTable = new JButton("RESET");
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
        JLabel lblTax = new JLabel("SiteID");
        lblTax.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblTax.setBounds(41, 143, 112, 35);
        panelCreate.add(lblTax);
        
        JLabel lblCompanyName = new JLabel("Type");
        lblCompanyName.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblCompanyName.setBounds(41, 191, 112, 35);
        panelCreate.add(lblCompanyName);
        
        JLabel lblFirstName = new JLabel("Specific");
        lblFirstName.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblFirstName.setBounds(41, 239, 112, 35);
        panelCreate.add(lblFirstName);
        
        //Text fields for panel create
        field_specific = new JTextField();
        field_specific.setColumns(10);
        field_specific.setBounds(171, 245, 179, 28);
        panelCreate.add(field_specific);
        
        JComboBox<Employee> cmbSiteID = new JComboBox<Employee>();
        cmbSiteID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbSiteID.setBackground(new Color(0, 153, 255));
        cmbSiteID.setBounds(171, 143, 179, 28);
        panelCreate.add(cmbSiteID);
        
        JComboBox<String> cmbtype = new JComboBox<String>();
        cmbtype.setModel(new DefaultComboBoxModel(new String[] {"Floor cleaning", "Window cleaning", "Facade cleaning", "Escalator cleaning", "Disinfectioning", "Snow cleaning"}));
        cmbtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbtype.setBackground(new Color(0, 153, 255));
        cmbtype.setBounds(171, 193, 179, 28);
        panelCreate.add(cmbtype);
        
        //button create
        JButton btnCreate = new JButton("CREATE");
        btnCreate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnCreate.setBackground(new Color(0, 153, 255));
        btnCreate.setBounds(213, 365, 112, 25);
        panelCreate.add(btnCreate);
        
        //label(text) on top create new company
        JLabel lblCreateNewService = new JLabel("CREATE NEW SERVICE");
        lblCreateNewService.setForeground(new Color(0, 153, 255));
        lblCreateNewService.setBackground(new Color(0, 153, 255));
        lblCreateNewService.setFont(new Font("Sitka Small", Font.PLAIN, 17));
        lblCreateNewService.setBounds(112, 39, 213, 16);
        panelCreate.add(lblCreateNewService);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 153, 255));
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(12, 0, 17, 401);
        panelCreate.add(separator);
        
        JButton btnClear = new JButton("CLEAR");
        btnClear.setFont(new Font("Sitka Text", Font.PLAIN, 18));
        btnClear.setBackground(new Color(0, 153, 255));
        btnClear.setBounds(68, 363, 99, 28);
        panelCreate.add(btnClear);
        
        init();
        
        

       
	}
	
	private void init() {
		try {
			this.siteCtr = new SiteController();
		}catch (DataAccessException e) {
			complain("Data store error", "Could not establish connection to the data storage", e);
		}
		this.servicesTable = new ServicesTable();
		this.tblServices.setModel(servicesTable);
	}
	
	private void complain(String title, String text, Exception e) {
		JOptionPane.showMessageDialog(this, text + " (" + e.getMessage() + ") ", title, JOptionPane.OK_OPTION);
	}
}
