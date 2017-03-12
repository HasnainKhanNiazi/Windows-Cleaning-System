import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Add_User {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton rdbtnthWeek_1 = new JRadioButton("8 week");
	JRadioButton rdbtnOnline;
	private JTextField textField_4;
	JLabel lblPaidAmount;
	JLabel lblRecepitNumber;
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	JRadioButton radioButton;
	JRadioButton rdbtnByHand;
	JCheckBox chckbxYes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_User window = new Add_User();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_User() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Customer");
		frame.setBounds(100, 100, 738, 494);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.setBounds(0, 0, 732, 463);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setForeground(new Color(255, 255, 255));
		lblEnterName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterName.setBounds(115, 98, 110, 22);
		panel.add(lblEnterName);
		
		JLabel lblStreetNumber = new JLabel("Street Number");
		lblStreetNumber.setForeground(new Color(255, 255, 255));
		lblStreetNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStreetNumber.setBounds(115, 147, 110, 22);
		panel.add(lblStreetNumber);
		
		JLabel lblHouseNumber = new JLabel("House Number");
		lblHouseNumber.setForeground(new Color(255, 255, 255));
		lblHouseNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHouseNumber.setBounds(115, 196, 110, 14);
		panel.add(lblHouseNumber);
		
		JLabel lblNoOfWindows = new JLabel("No. of Windows");
		lblNoOfWindows.setForeground(new Color(255, 255, 255));
		lblNoOfWindows.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNoOfWindows.setBounds(115, 234, 110, 22);
		panel.add(lblNoOfWindows);
		
		JLabel lblAfterHowMany = new JLabel("After how many weeks");
		lblAfterHowMany.setForeground(new Color(255, 255, 255));
		lblAfterHowMany.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAfterHowMany.setBounds(76, 282, 149, 20);
		panel.add(lblAfterHowMany);
		
		textField = new JTextField();
		textField.setBounds(282, 100, 268, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE){
					e.consume();
				}
			}
		});
		textField_1.setBounds(282, 149, 268, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE){
					e.consume();
				}
			}
		});
		textField_2.setBounds(282, 194, 268, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE){
					e.consume();
				}
			}
		});
		textField_3.setBounds(282, 236, 268, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JRadioButton rdbtnthWeek = new JRadioButton("4 week");
		rdbtnthWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnthWeek_1.setSelected(false);
			}
		});
		rdbtnthWeek.setBackground(new Color(169, 169, 169));
		rdbtnthWeek.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		rdbtnthWeek.setBounds(303, 282, 109, 23);
		panel.add(rdbtnthWeek);
		rdbtnthWeek_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnthWeek.setSelected(false);
			}
		});
		
		
		rdbtnthWeek_1.setBackground(new Color(169, 169, 169));
		rdbtnthWeek_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		rdbtnthWeek_1.setBounds(441, 282, 109, 23);
		panel.add(rdbtnthWeek_1);
		
		JButton btnAddUser = new JButton("Add Customer");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = textField.getText();
				textField.setText("");
				String Street_Number = textField_1.getText();
				textField_1.setText("");
				String House_Num = textField_2.getText();
				textField_2.setText("");
				String No_Windows = textField_3.getText();
				textField_3.setText("");
				String weeks = null;
				String paid = null;
				String Payment_Method = null;
				String Amount = textField_4.getText();
				textField_4.setText("");
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
				String Date = sdf.format(cal.getTime());
				if(chckbxYes.isSelected()){
					paid = "P";
				}
				else if(!chckbxYes.isSelected()){
					paid = "NP";
					Amount = "Not Available";
				}
				if(rdbtnthWeek.isSelected()){
					weeks = rdbtnthWeek.getText();
				}
				else if(rdbtnthWeek_1.isSelected()){
					weeks = rdbtnthWeek_1.getText();
				}
				if(rdbtnByHand.isSelected()){
					Payment_Method = rdbtnByHand.getText();
				}
				else if(rdbtnOnline.isSelected()){
					Payment_Method = rdbtnOnline.getText();
				}
				new Add_User_DBS(House_Num,Name,Street_Number,No_Windows,weeks,Payment_Method,paid,Amount,Date);
			}
		});
		btnAddUser.setBackground(new Color(128, 128, 128));
		btnAddUser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnAddUser.setBounds(76, 400, 120, 32);
		panel.add(btnAddUser);
		
		JButton button = new JButton("");
		button.setToolTipText("Way To Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Home();
			}
		});
		button.setIcon(new ImageIcon("D:\\Users\\11029356\\workspace\\NewDPS\\Home.png"));
		button.setBounds(674, 11, 48, 40);
		panel.add(button);
		
		JLabel lblMoney = new JLabel("Money Paid");
		lblMoney.setForeground(new Color(255, 255, 255));
		lblMoney.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMoney.setBounds(115, 324, 110, 23);
		panel.add(lblMoney);
		
		JLabel lblAddCustomer = new JLabel("ADD CUSTOMER");
		lblAddCustomer.setForeground(new Color(255, 255, 255));
		lblAddCustomer.setFont(new Font("Yu Mincho Demibold", Font.BOLD | Font.ITALIC, 42));
		lblAddCustomer.setBounds(152, 0, 543, 74);
		panel.add(lblAddCustomer);
		
		rdbtnByHand = new JRadioButton("Cash");
		rdbtnByHand.setVisible(false);
		rdbtnByHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnOnline.setVisible(false);
				textField_4.setVisible(true);
				lblPaidAmount.setVisible(true);
			}
		});
		rdbtnByHand.setBackground(new Color(169, 169, 169));
		rdbtnByHand.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		rdbtnByHand.setBounds(303, 325, 109, 23);
		panel.add(rdbtnByHand);
		
		rdbtnOnline = new JRadioButton("Online");
		rdbtnOnline.setVisible(false);
		rdbtnOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnByHand.setVisible(false);
				rdbtnOnline.setVisible(false);
				textField_4.setVisible(true);
				radioButton.setVisible(true);
				lblRecepitNumber.setVisible(true);
				radioButton.setSelected(true);
			}
		});;
		rdbtnOnline.setBackground(new Color(169, 169, 169));
		rdbtnOnline.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		rdbtnOnline.setBounds(441, 325, 109, 23);
		panel.add(rdbtnOnline);
		
		textField_4 = new JTextField();
		textField_4.setVisible(false);
		textField_4.setBounds(564, 326, 131, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		lblPaidAmount = new JLabel("Paid Amount");
		lblPaidAmount.setVisible(false);
		lblPaidAmount.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPaidAmount.setForeground(new Color(255, 255, 255));
		lblPaidAmount.setBounds(474, 327, 76, 18);
		panel.add(lblPaidAmount);
		
		radioButton = new JRadioButton("Online");
		radioButton.setVisible(false);
		radioButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		radioButton.setBackground(new Color(169, 169, 169));
		radioButton.setBounds(303, 325, 109, 23);
		panel.add(radioButton);
		
		lblRecepitNumber = new JLabel("Recepit Number:");
		lblRecepitNumber.setVisible(false);
		lblRecepitNumber.setForeground(new Color(255, 255, 255));
		lblRecepitNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRecepitNumber.setBounds(451,327, 99, 18);
		panel.add(lblRecepitNumber);
		
		JButton btnResetData = new JButton("Reset Data");
		btnResetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Add_User();
			}
		});
		btnResetData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnResetData.setBackground(Color.GRAY);
		btnResetData.setBounds(221, 400, 120, 32);
		panel.add(btnResetData);
		
		chckbxYes = new JCheckBox("Yes");
		chckbxYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxYes.setVisible(false);
				rdbtnByHand.setVisible(true);
				rdbtnOnline.setVisible(true);
			}
		});
		chckbxYes.setBackground(new Color(169, 169, 169));
		chckbxYes.setFont(new Font("Times New Roman", Font.BOLD, 12));
		chckbxYes.setBounds(303, 325, 109, 23);
		panel.add(chckbxYes);
		frame.setVisible(true);
	}
}
