import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	String Password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Log In");
		frame.setBounds(100, 100, 738, 494);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFocusable(true);
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.setBounds(0, 0, 732, 462);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserName.setBounds(335, 44, 79, 14);
		panel.add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(335, 83, 79, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(484, 43, 155, 17);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE){
					e.consume();
				}
			}
		});
		passwordField.setBounds(484, 82, 155, 17);
		panel.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Users\\11029356\\workspace\\NewDPS\\new.png"));
		label.setBounds(-44, 11, 283, 211);
		panel.add(label);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addKeyListener(new KeyAdapter() {
			private BufferedReader br;

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						br = new BufferedReader(new FileReader(new File("Password.txt")));
						Password = br.readLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(passwordField.getText().equals(Password)){
						frame.setVisible(false);
						new Home();
					}
					else{
						JOptionPane.showMessageDialog(null, "Sorry Wrong Password");
					}
				}
			}
		});
		
		btnLogIn.addActionListener(new ActionListener() {
			private BufferedReader br;

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLogIn){
					try {
						br = new BufferedReader(new FileReader(new File("Password.txt")));
						Password = br.readLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(passwordField.getText().equals(Password)){
						frame.setVisible(false);
						new Home();
					}
					else{
						JOptionPane.showMessageDialog(null, "Sorry Wrong Password");
					}
				}
				
			}
		});
		
		btnLogIn.setBackground(new Color(169, 169, 169));
		btnLogIn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnLogIn.setBounds(335, 137, 89, 23);
		panel.add(btnLogIn);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Users\\11029356\\workspace\\NewDPS\\Logo1.png"));
		label_1.setBounds(0, 233, 673, 229);
		panel.add(label_1);
		
		JButton btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new ForgotPassword();
			}
		});
		btnForgetPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnForgetPassword.setBackground(new Color(169, 169, 169));
		btnForgetPassword.setBounds(453, 137, 135, 23);
		panel.add(btnForgetPassword);
		frame.setVisible(true);
}
}