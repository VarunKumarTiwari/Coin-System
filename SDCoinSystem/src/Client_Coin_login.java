import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.Naming;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client_Coin_login extends Coin_System {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Coin_login window = new Client_Coin_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public Client_Coin_login() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		Interface_Coin inter;
		frame = new JFrame();

		// Background image of frame
		try {
			JLabel label78 = new JLabel(new ImageIcon(
			ImageIO.read(new File(getClass().getResource("/Img/Gradient_builder_2.jpg").toURI()))));
			frame.setContentPane(label78);
			frame.setContentPane(label78);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// end

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWelcomeToCoin = new JLabel("Welcome to Coin System");
		lblWelcomeToCoin.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblWelcomeToCoin.setBounds(81, 24, 279, 29);
		frame.getContentPane().add(lblWelcomeToCoin);

		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(94, 105, 71, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(94, 156, 71, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(218, 102, 142, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(218, 153, 142, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String un = textField.getText();
				int pass = Integer.parseInt(textField_1.getText());
				try {
					String url = "rmi:///";
					Interface_Coin inter = (Interface_Coin) Naming.lookup(url +un+pass);
					//inter.logcheck();
					Coin_System c = new Coin_System();
					c.frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
 				
				
				frame.dispose();
			}
		});
		btnNewButton.setBounds(162, 211, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
