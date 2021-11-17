package guiLayer;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import controllerLayer.DataAccessException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import modelLayer.Employee;

public class PanelShifts extends JPanel {
	private static final long serialVersionUID = 1L;
	private static EditorPanel editorPanel;
	private JTextField textSearch;
	private JTextField field_starthour;
	private JTextField field_endHour;
	private JTable tblShifts;

	/**
	 * Create the panel.
	 */
	public PanelShifts() throws DataAccessException {
		editorPanel = EditorPanel.getInstance();
				
		CardLayout cards = new CardLayout();
		setBackground(Color.WHITE);
		setBounds(0, 0, 919, 401);
		setLayout(null);
        

        
        //PANEL CREATE
        JPanel panelCreate = new JPanel();
        panelCreate.setBounds(519, 0, 400, 401);
        add(panelCreate);
        panelCreate.setBackground(Color.WHITE);
        panelCreate.setLayout(null);
        
        //Labels in panel create
        JLabel lblTax = new JLabel("ServiceID");
        lblTax.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblTax.setBounds(41, 85, 112, 35);
        panelCreate.add(lblTax);
        
        JLabel lblCompanyName = new JLabel("EmployeeID");
        lblCompanyName.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblCompanyName.setBounds(41, 133, 112, 35);
        panelCreate.add(lblCompanyName);
        
        JLabel lblFirstName = new JLabel("Date");
        lblFirstName.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblFirstName.setBounds(41, 181, 112, 35);
        panelCreate.add(lblFirstName);
        
        JLabel lblLastName = new JLabel("Start hour");
        lblLastName.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblLastName.setBounds(41, 221, 112, 35);
        panelCreate.add(lblLastName);
        
        JLabel lblEndHour = new JLabel("End hour");
        lblEndHour.setFont(new Font("Sitka Small", Font.PLAIN, 16));
        lblEndHour.setBounds(41, 259, 112, 35);
        panelCreate.add(lblEndHour);
        
        field_starthour = new JTextField();
        field_starthour.setColumns(10);
        field_starthour.setBounds(185, 225, 179, 28);
        panelCreate.add(field_starthour);
        
        field_endHour = new JTextField();
        field_endHour.setColumns(10);
        field_endHour.setBounds(185, 266, 179, 28);
        panelCreate.add(field_endHour);
        
        
        //button create
        JButton btnCreate = new JButton("CREATE");
        btnCreate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnCreate.setBackground(new Color(0, 153, 255));
        btnCreate.setBounds(225, 365, 112, 25);
        panelCreate.add(btnCreate);
        
        //label(text) on top create new company
        JLabel lblCreateNewCompany = new JLabel("CREATE NEW SHIFT");
        lblCreateNewCompany.setForeground(new Color(0, 153, 255));
        lblCreateNewCompany.setBackground(new Color(0, 153, 255));
        lblCreateNewCompany.setFont(new Font("Sitka Small", Font.PLAIN, 17));
        lblCreateNewCompany.setBounds(110, 30, 213, 16);
        panelCreate.add(lblCreateNewCompany);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 153, 255));
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(12, 0, 17, 401);
        panelCreate.add(separator);
        
        JButton btnClear = new JButton("CLEAR");
        //btnClear.addActionListener(this::btnClearClicked);
        btnClear.setFont(new Font("Sitka Text", Font.PLAIN, 18));
        btnClear.setBackground(new Color(0, 153, 255));
        btnClear.setBounds(75, 363, 99, 28);
        panelCreate.add(btnClear);
        
        //combo boxes
        JComboBox<Employee> cmbManager = new JComboBox<Employee>();
        cmbManager.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbManager.setBackground(new Color(0, 153, 255));
        cmbManager.setBounds(185, 85, 179, 28);
        panelCreate.add(cmbManager);
        
        JComboBox<Employee> cmbEmployees = new JComboBox<Employee>();
        cmbEmployees.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cmbEmployees.setBackground(new Color(0, 153, 255));
        cmbEmployees.setBounds(185, 133, 179, 28);
        panelCreate.add(cmbEmployees);
        
        JComboBox<String> comboBoxDays = new JComboBox<>();
        comboBoxDays.setBackground(new Color(0, 153, 255));
        comboBoxDays.setModel(new DefaultComboBoxModel<>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboBoxDays.setBounds(185, 184, 50, 28);
		panelCreate.add(comboBoxDays);

		JComboBox<String> comboBoxMonths = new JComboBox<>();
		comboBoxMonths.setBackground(new Color(0, 153, 255));
		comboBoxMonths.setModel(new DefaultComboBoxModel<>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBoxMonths.setBounds(247, 184, 50, 28);
		panelCreate.add(comboBoxMonths);

		JComboBox<String> comboBoxYears = new JComboBox<>();
		comboBoxYears.setBackground(new Color(0, 153, 255));
		comboBoxYears.setModel(new DefaultComboBoxModel<>(
				new String[] { "2020", "2021", "2022", "2023", "2024", "2025" }));
		comboBoxYears.setBounds(309, 184, 55, 28);
		panelCreate.add(comboBoxYears);

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
        btnFind.setFont(new Font("Sitka Text", Font.PLAIN, 18));
        btnFind.setBackground(new Color(0, 153, 255));
        btnFind.setBounds(299, 13, 99, 28);
        panelDisplay.add(btnFind);
        
        //button to open the company
        JButton btnOpen = new JButton("OPEN");
        btnOpen.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnOpen.setBackground(new Color(0, 153, 255));
        btnOpen.setBounds(58, 363, 105, 25);
        panelDisplay.add(btnOpen);
        
        //edit button
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBackground(new Color(0, 153, 255));
        btnUpdate.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnUpdate.setBounds(206, 363, 123, 25);
        panelDisplay.add(btnUpdate);
        
        //delete button
        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBackground(new Color(0, 153, 255));
        btnDelete.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        btnDelete.setBounds(375, 363, 113, 25);
        panelDisplay.add(btnDelete);
        
        //scroll pane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 73, 506, 260);
        panelDisplay.add(scrollPane);
        
        //company table
        tblShifts = new JTable();
        scrollPane.setViewportView(tblShifts);
        
        
        JButton btnResetTable = new JButton("RESET");
        btnResetTable.setBackground(new Color(0, 153, 255));
        btnResetTable.setBounds(12, 37, 118, 23);
        btnResetTable.setFont(new Font("Sitka Small", Font.PLAIN, 18));
        panelDisplay.add(btnResetTable);
        
        
        
       
		
	}
}
