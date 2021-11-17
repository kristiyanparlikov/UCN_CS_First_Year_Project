package guiLayer;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import controllerLayer.DataAccessException;
import modelLayer.Customer;

public class EditorPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelCompany panelCompany;
	private PanelEmployee panelEmployee;
	private PanelSites panelSites;
	private PanelHome panelHome;
	private PanelShifts panelShifts;
	private PanelServices panelServices;
	private CardLayout cardLayout;
	private static EditorPanel editorPanel = null; 
	
	private EditorPanel() {
		cardLayout = new CardLayout();
		
		setBackground(Color.WHITE);
		setBounds(33, 239, 919, 401);
		setLayout(cardLayout);
	}
	
	public static EditorPanel getInstance() 
    { 
        if (editorPanel == null) 
        	editorPanel = new EditorPanel(); 
  
        return editorPanel; 
    } 
	
	public void openPanelHome() {
		panelHome = new PanelHome();
		this.add(panelHome, "HOME");
		cardLayout.show(this, "HOME");
	}
	
	public void openPanelCompany() throws DataAccessException {
		panelCompany = new PanelCompany();
		this.add(panelCompany, "COMPANY");
		cardLayout.show(this, "COMPANY");
	}
	public void openPanelEmployee() throws DataAccessException {
		panelEmployee = new PanelEmployee();
		this.add(panelEmployee, "EMPLOYEE");
		cardLayout.show(this, "EMPLOYEE");
	}
	
	public void openPanelSites(Customer customer) throws DataAccessException {
		panelSites = new PanelSites(customer);
		this.add(panelSites, "SITES");
		cardLayout.show(this, "SITES");
	}
	
	public void openPanelShifts() throws DataAccessException {
		panelShifts = new PanelShifts();
		this.add(panelShifts, "SHIFTS");
		cardLayout.show(this, "SHIFTS");
	}
	
	public void openPanelServices() throws DataAccessException {
		//panelServices = new PanelServices();
		this.add(panelShifts, "SERVICES");
		cardLayout.show(this, "SERVICES");
	}
	
}
