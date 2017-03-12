import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ForgotPassword {

	protected static final Component arg0 = null;
	private JFrame frame;
	public static String password = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String singer = null;
	String Place_Of_Birth = null;
	String Email = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword window = new ForgotPassword();
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
	public ForgotPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Reset Password");
		frame.setBounds(100, 100, 738, 494);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.setBounds(0, 0, 722, 455);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setForeground(new Color(255, 255, 255));
		lblChangePassword.setFont(new Font("Yu Mincho Demibold", Font.BOLD | Font.ITALIC, 42));
		lblChangePassword.setBounds(203, -11, 348, 85);
		panel.add(lblChangePassword);
		
		JLabel lblWhoIsYour = new JLabel("Who is your faviourate Singer:");
		lblWhoIsYour.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblWhoIsYour.setForeground(new Color(255, 255, 255));
		lblWhoIsYour.setBackground(new Color(240, 240, 240));
		lblWhoIsYour.setBounds(65, 144, 205, 22);
		panel.add(lblWhoIsYour);
		
		textField = new JTextField();
		textField.setBounds(331, 147, 233, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New Password:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(65, 309, 205, 14);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(331, 196, 233, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPlaceOfBirth = new JLabel("Place of Birth:");
		lblPlaceOfBirth.setForeground(new Color(255, 255, 255));
		lblPlaceOfBirth.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblPlaceOfBirth.setBounds(65, 197, 205, 14);
		panel.add(lblPlaceOfBirth);
		
		textField_2 = new JTextField();
		textField_2.setBounds(331, 247, 233, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email ID:");
		lblEmailId.setForeground(new Color(255, 255, 255));
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblEmailId.setBounds(65, 248, 205, 19);
		panel.add(lblEmailId);
		
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
		textField_3.setBounds(331, 303, 233, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnChangePasswrod = new JButton("Change Passwrod");
		btnChangePasswrod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singer = textField.getText();
				Place_Of_Birth = textField_1.getText();
				Email = textField_2.getText();
				password = textField_3.getText();
				if(singer.equals("Nusrat Fateh Ali Khan") && Place_Of_Birth.equals("Mianwali") && Email.equals("Client11@gmail.com")){
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Password.txt")));
						bw.write(password);
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(arg0, "Password has been changed");
					frame.setVisible(false);
					new MainWindow();
				}
				else{
					JOptionPane.showMessageDialog(arg0, "Your Data is Wrong Please Enter Again");
				}
			}
		});
		btnChangePasswrod.setForeground(new Color(255, 255, 255));
		btnChangePasswrod.setBackground(new Color(169, 169, 169));
		btnChangePasswrod.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnChangePasswrod.setBounds(65, 385, 139, 23);
		panel.add(btnChangePasswrod);
		frame.setVisible(true);
	}
}
