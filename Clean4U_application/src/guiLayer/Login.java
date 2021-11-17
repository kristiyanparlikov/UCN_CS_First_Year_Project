package guiLayer;

import java.awt.Color;
import java.util.*;


import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Login {

	private static JFrame frame;
	private JPasswordField passwordField;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		init();
	}



	public void init() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/icon.jpg")));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Clean4U");
		frame.setBounds(600,200, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setToolTipText("Password");
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
				public void keyPressed(java.awt.event.KeyEvent evt) {
				String password = passwordField.getText();
				String username = txtUsername.getText();
				if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
						if (password.contains("123") && username.contains("group2")) { 
							passwordField.setText(null);
							txtUsername.setText(null);
							Home.main(null);
							frame.dispose();
						}	
						else {
							JOptionPane.showMessageDialog(null, "Incorrect password or username, please try again","Login error",JOptionPane.ERROR_MESSAGE);
							passwordField.setText(null);
							txtUsername.setText(null);
						}		
			}
			}
		});
		passwordField.setBounds(88, 362, 302, 44);
		frame.getContentPane().add(passwordField);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setBounds(88, 272, 302, 44);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.setForeground(new Color(248, 248, 255));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				String username = txtUsername.getText();
				
				if (password.contains("123") && username.contains("group2")) { 
					passwordField.setText(null);
					txtUsername.setText(null);
					Home.main(null);
					frame.dispose();
				
				}	
				else {
					JOptionPane.showMessageDialog(null, "Incorrect password or username, please try again","Login error",JOptionPane.ERROR_MESSAGE);
					passwordField.setText(null);
					txtUsername.setText(null);
				}
			}
	
		});
		
		  
		
		btnNewButton.setBounds(187, 458, 115, 44);
		frame.getContentPane().add(btnNewButton);
		
		JLabel logo = new JLabel("");
		logo.setBackground(new Color(135, 206, 250));
		logo.setIcon(new ImageIcon(Login.class.getResource("/images/logoclean.png")));
		logo.setBounds(124, 13, 278, 191);
		frame.getContentPane().add(logo);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(88, 254, 96, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(88, 343, 96, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(new Color(135, 206, 250));
		textPane.setBounds(43, 222, 404, 303);
		frame.getContentPane().add(textPane);
		
	}
}
