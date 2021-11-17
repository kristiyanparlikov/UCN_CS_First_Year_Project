package guiLayer;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllerLayer.DataAccessException;
import modelLayer.Customer;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private EditorPanel editorPanel;
	private JPanel menu;
	private JPanel panel_home;
	private JPanel panel_employees;
	private JPanel panel_companies;
	private JPanel panel_shifts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws DataAccessException 
	 */
	public Home() throws DataAccessException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/icon.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//MENU PANEL
		menu = new JPanel();
		menu.setBackground(new Color(153, 204, 255));
		menu.setBounds(-16, 2, 1000, 226);
		contentPane.add(menu);
		menu.setLayout(null);
		//EDITOR PANEL
		editorPanel = EditorPanel.getInstance();
		editorPanel.setBackground(Color.WHITE);
		editorPanel.setBounds(33, 239, 919, 401);
		contentPane.add(editorPanel);
		editorPanel.openPanelHome();
		
		
		//HELP BUTTON
		JButton btnHelp = new JButton("HELP");
		btnHelp.setBounds(23, 13, 97, 25);
		btnHelp.setHorizontalAlignment(SwingConstants.LEADING);
		btnHelp.setBackground(Color.WHITE);
		btnHelp.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		menu.add(btnHelp);
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Desktop.getDesktop().browse(new URI(
							"https://drive.google.com/file/d/17UZ8nDYNbhXBmnrEH1inwu5S34N3-4DH/view?usp=sharing"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		//HOME MENU PANEL
		
		panel_home = new JPanel();
		panel_home.setBounds(96, 180, 203, 46);
		panel_home.setBackground(new Color(47, 79, 79));
		menu.add(panel_home);
		panel_home.addMouseListener(new PanelButtonMouseAdapter(panel_home) {
			@Override
			public void mouseClicked(MouseEvent e) {
					editorPanel.openPanelHome();
			}});
		
		//HOME MENU LABEL
		JLabel lbl_panel_home = new JLabel("HOME");
		lbl_panel_home.setForeground(Color.WHITE);
		lbl_panel_home.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lbl_panel_home.setBounds(99, 13, 82, 20);
		panel_home.add(lbl_panel_home);
		
		
		//COMPANIES MENU PANEL
		
		panel_companies = new JPanel();
		panel_companies.setBounds(299, 180, 203, 46);
		panel_companies.setBackground(new Color(47, 79, 79));
		menu.add(panel_companies);
		panel_companies.addMouseListener(new PanelButtonMouseAdapter(panel_companies)  {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					editorPanel.openPanelCompany();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//COMPANIES MENU LABEL
		JLabel lbl_panel_companies = new JLabel("COMPANIES");
		lbl_panel_companies.setForeground(Color.WHITE);
		lbl_panel_companies.setBounds(76, 13, 116, 20);
		lbl_panel_companies.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		panel_companies.add(lbl_panel_companies);
		
		
		//EMPLOYEES MENU PANEL
		panel_employees = new JPanel();
		panel_employees.setBounds(502, 180, 203, 46);
		panel_employees.setBackground(new Color(47, 79, 79));
		menu.add(panel_employees);
		panel_employees.addMouseListener(new PanelButtonMouseAdapter(panel_employees)  {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					editorPanel.openPanelEmployee();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		//EMPLOYEES MENU LABEL
		JLabel lbl_panel_employees = new JLabel("EMPLOYEES");
		lbl_panel_employees.setForeground(Color.WHITE);
		lbl_panel_employees.setBackground(new Color(0, 153, 255));
		lbl_panel_employees.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lbl_panel_employees.setBounds(72, 13, 127, 20);
		panel_employees.add(lbl_panel_employees);
		
		//COMPANIES MENU PANEL
		
	    panel_shifts = new JPanel();
	    panel_shifts .setBounds(705, 180, 203, 46);
	    panel_shifts .setBackground(new Color(47, 79, 79));
		menu.add( panel_shifts );
		panel_shifts.addMouseListener(new PanelButtonMouseAdapter(panel_shifts)  {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							editorPanel.openPanelShifts();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		//COMPANIES MENU LABEL
		JLabel lbl_panel_shifts = new JLabel("SHIFTS");
		lbl_panel_shifts.setForeground(Color.WHITE);
		lbl_panel_shifts.setBounds(76, 13, 116, 20);
		lbl_panel_shifts.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		panel_shifts.add(lbl_panel_shifts);
				
		//LOGO PICTURE
		JLabel logo = new JLabel("");
		logo.setBounds(360, -11, 277, 191);
		logo.setBackground(new Color(0, 153, 255));
		logo.setIcon(new ImageIcon(Home.class.getResource("/images/logoclean.png")));
		menu.add(logo);
		
	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered (MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
			
		}
		@Override
		public void mouseExited (MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));
			
		}
		@Override
		public void mousePressed (MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
			
		}	
	}
}
