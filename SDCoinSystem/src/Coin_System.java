import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.rmi.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;

public class Coin_System {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	Interface_Coin c;
	public int[] arr;
	public int[] resultarr;
	public int[] resultarr2;

	// public arraycoins arrcoin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coin_System window = new Coin_System();
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
	public Coin_System() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		String url = "rmi:///";
		c = (Interface_Coin) Naming.lookup(url + "varun12345");

		frame = new JFrame();
		// Background image of frame

		try {
			JLabel label78 = new JLabel(new ImageIcon(
					ImageIO.read(new File(getClass().getResource("/Img/Gradient_builder_2.jpg").toURI()))));

			frame.setContentPane(label78);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// end
		frame.setBounds(100, 100, 676, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCoinsSysytem = new JLabel("Coin System");
		lblCoinsSysytem.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCoinsSysytem.setBounds(10, 11, 169, 35);
		frame.getContentPane().add(lblCoinsSysytem);

		JLabel lblNoOf = new JLabel("No. of 1 cents");
		lblNoOf.setBounds(423, 105, 90, 14);
		frame.getContentPane().add(lblNoOf);

		JLabel lblNewLabel = new JLabel("No. of 10 cents");
		lblNewLabel.setBounds(423, 51, 90, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNoOf_1 = new JLabel("No. of 5 cents");
		lblNoOf_1.setBounds(423, 80, 90, 14);
		frame.getContentPane().add(lblNoOf_1);

		JLabel lblNoOf_2 = new JLabel("No. of 25 cents");
		lblNoOf_2.setBounds(423, 26, 90, 14);
		frame.getContentPane().add(lblNoOf_2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(576, 26, 63, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("New label");
		label.setBounds(576, 53, 63, 14);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(576, 80, 63, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(576, 105, 63, 14);
		frame.getContentPane().add(label_2);

		JLabel lblBill = new JLabel("Bill");
		lblBill.setBounds(39, 78, 46, 14);
		frame.getContentPane().add(lblBill);

		textField = new JTextField();
		textField.setBounds(183, 75, 137, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblMoneyHandOver = new JLabel("Cash");
		lblMoneyHandOver.setBounds(39, 120, 100, 14);
		frame.getContentPane().add(lblMoneyHandOver);

		textField_1 = new JTextField();
		textField_1.setBounds(183, 117, 137, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0.9f, 0.9f, 0.9f, 0.2f));
		// panel. .setContentPane(new JLabel(new ImageIcon(ImageIO.read(new
		// File(getClass().getResource("/Img/Gradient_builder_2.jpg").toURI())))));
		panel.setBounds(26, 236, 365, 30);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label_3 = new JLabel("No. of 1 cents");
		label_3.setBounds(10, 11, 83, 14);
		panel.add(label_3);

		JLabel lblNoOf_3 = new JLabel("No. of 5 cents");
		lblNoOf_3.setBounds(99, 11, 77, 14);
		panel.add(lblNoOf_3);

		JLabel lblNoOf_4 = new JLabel("No. of 10 cents");
		lblNoOf_4.setBounds(186, 11, 93, 14);
		panel.add(lblNoOf_4);

		JLabel lblNoOf_5 = new JLabel("No. of 25 cents");
		lblNoOf_5.setBounds(278, 11, 87, 14);
		panel.add(lblNoOf_5);

		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setBounds(66, 275, 40, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel label_4 = new JLabel("0");
		label_4.setBounds(159, 275, 40, 14);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("0");
		label_5.setBounds(246, 275, 40, 14);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("0");
		label_6.setBounds(338, 275, 40, 14);
		frame.getContentPane().add(label_6);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(183, 160, 137, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel[] Lablename = { lblNewLabel_1, label, label_1, label_2 }; // Label names to print the stock values
		JLabel[] resultLable = { label_6, label_5, label_4, lblNewLabel_2 };// Label names to print the coins values

		JButton btnCalculate = new JButton("Calculate");

		// btnCalculate.setBackground(new Color(0.9f,0.9f,0.9f,0.2f));

		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double bill = Double.parseDouble(textField.getText());
				Double cash = Double.parseDouble(textField_1.getText());
				Double result = cash - bill;
				lblNewLabel_4.setText("" + String.format("%.2f", result));// Label lblNewLabel_4 will show the cents to
																			// return back

				// here Implement_Coin.java class is called to calculate the result and to
				// display the result to its proper place
				try {
					resultarr = c.exchange(result);

					for (int i = 0; i < resultLable.length; i++) {
						resultLable[i].setText("" + resultarr[i]);
					}
					resultarr2 = c.exchange2(resultarr);
					for (int i = 0; i < Lablename.length; i++) {
						// resultLable[i].setText("" +resultarr2[i]);
						if(resultarr2[i]>-1)
						{
							Lablename[i].setText("" + resultarr2[i]);
						}
						else
						{
							System.out.println("Not enough money to return back!!");
						}
					}

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCalculate.setBounds(49, 202, 89, 23);
		frame.getContentPane().add(btnCalculate);

		JButton btnClear = new JButton("Clear");

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// clear function
				textField.setText("");
				textField_1.setText("");
				lblNewLabel_4.setText("");
				for (int i = 0; i < resultLable.length; i++) {
					resultLable[i].setText("");
				}
			}
		});
		btnClear.setBounds(231, 202, 89, 23);
		frame.getContentPane().add(btnClear);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0.9f, 0.9f, 0.9f, 0.2f));
		panel_1.setBounds(414, 130, 225, 190);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Add to Stock");
		lblNewLabel_3.setBounds(76, 11, 85, 14);
		panel_1.add(lblNewLabel_3);

		JLabel lblNoOf_6 = new JLabel("No. of 10 cents");
		lblNoOf_6.setBounds(10, 68, 109, 14);
		panel_1.add(lblNoOf_6);

		JLabel lblNoOf_7 = new JLabel("No. of 5 cents");
		lblNoOf_7.setBounds(10, 102, 109, 14);
		panel_1.add(lblNoOf_7);

		JLabel label_10 = new JLabel("No. of 25 cents");
		label_10.setBounds(10, 36, 109, 14);
		panel_1.add(label_10);

		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setBounds(129, 36, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setBounds(129, 65, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setBounds(129, 99, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setBounds(129, 124, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JButton btnAdd = new JButton("Add");
		// btnAdd.setBackground(new Color(0.9f,0.9f,0.9f,0.2f));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// accepting the values from text fields through array
				JTextField[] textFieldname = { textField_2, textField_3, textField_4, textField_5 };
				int[] veri_value = new int[4];

				for (int i = 0; i < textFieldname.length; i++) {
					int virtualDirectories = Integer.parseInt(textFieldname[i].getText());
					veri_value[i] = virtualDirectories;

				}
				// here Implement_Coin.java class is called to pass the array and add coins in
				// the stock
				try {
					arr = c.addValue(veri_value);
					for (int i = 0; i < Lablename.length; i++) {
						Lablename[i].setText("" + arr[i]);

					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAdd.setBounds(72, 152, 89, 23);
		panel_1.add(btnAdd);

		JLabel label_7 = new JLabel("No. of 1 cents");
		label_7.setBounds(10, 127, 77, 14);
		panel_1.add(label_7);

		JLabel lblCashToBe = new JLabel("Cash to be return");
		lblCashToBe.setBounds(39, 160, 100, 14);
		frame.getContentPane().add(lblCashToBe);

	}

}
