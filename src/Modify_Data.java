import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Modify_Data {
	
	String url = "jdbc:mysql://localhost/FinalF";
	Connection conn = null;
	Statement stmt = null;
	java.sql.Statement st = null;
	ResultSet rs = null;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify_Data window = new Modify_Data();
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
	public Modify_Data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Modify Data");
		frame.setBounds(100, 100, 738, 494);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.setBounds(0, 0, 732, 462);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHouseNumber = new JLabel("Enter House Number");
		lblHouseNumber.setForeground(new Color(255, 255, 255));
		lblHouseNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblHouseNumber.setBounds(88, 20, 114, 20);
		panel.add(lblHouseNumber);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE){
					e.consume();
				}
			}
		});
		textField.setBounds(299, 20, 174, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterStreetNumber = new JLabel("Enter Street Number");
		lblEnterStreetNumber.setForeground(new Color(255, 255, 255));
		lblEnterStreetNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblEnterStreetNumber.setBounds(88, 69, 114, 14);
		panel.add(lblEnterStreetNumber);
		
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
		textField_1.setBounds(299, 66, 174, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Show Data");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(169, 169, 169));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String H_num = textField.getText();
				textField.setText("");
				String Street_Number = textField_1.getText();
				textField_1.setText("");
				table.setVisible(true);
				scrollPane.setVisible(true);
				try{
					  conn = DriverManager.getConnection(url, "root", null);
					  String sql = "select * from h_r where houseid = '"+H_num+"' and StreetNumber = '"+Street_Number+"'";
					  java.sql.PreparedStatement prep = conn.prepareStatement(sql);
					  rs = prep.executeQuery();
					  table.setModel(DbUtils.resultSetToTableModel(rs));
					  table.setVisible(true);
					  scrollPane.setVisible(true);
				   }catch(SQLException se){
				      se.printStackTrace();
				   }catch(Exception ee){
				      ee.printStackTrace();
				   }finally{
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      }
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }
				   }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(30, 108, 114, 23);
		panel.add(btnNewButton);
		
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 142, 734, 320);
		panel.add(scrollPane);
		
		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//			}
//		));
		final RowPopUp pop = new RowPopUp(table);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(SwingUtilities.isRightMouseButton(e)){
					pop.show(e.getComponent(), 	e.getX(), e.getY());
				}
			}
		});
		scrollPane.setViewportView(table);
		frame.setVisible(true);
	}
}