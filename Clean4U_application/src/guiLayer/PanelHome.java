package guiLayer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHome() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 919, 401);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelHome.class.getResource("/images/240_F_127389862_pMUoWAQMoKsq6QOrF8kq8S9KaXOCjlHP.jpg")));
		lblNewLabel.setBounds(114, 34, 724, 328);
		add(lblNewLabel);
		setVisible(true);
	}

}
