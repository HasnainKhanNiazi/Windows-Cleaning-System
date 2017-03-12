import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class User_Info {

	private JFrame frame;
	private JTable table;
	String url = "jdbc:mysql://localhost/FinalF";
	Connection conn = null;
	Statement stmt = null;
	java.sql.Statement st = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Info window = new User_Info();
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
	public User_Info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Customer Information");
		frame.setBounds(100, 100, 738, 494);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.setBounds(0, 85, 732, 378);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			    table.setSelectionBackground(Color.gray);
			}
		});
		scrollPane.setBounds(0, 0, 732, 327);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
				
				try{
					  conn = DriverManager.getConnection(url, "root", null);
					  String sql = "select * from h_r";
					  java.sql.PreparedStatement prep = conn.prepareStatement(sql);
					  rs = prep.executeQuery();
					  table.setModel(DbUtils.resultSetToTableModel(rs));
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#1a1a1a"));
		panel_1.setBounds(0, 0, 732, 85);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserInformation = new JLabel("Customer Information");
		lblUserInformation.setForeground(new Color(255, 255, 255));
		lblUserInformation.setFont(new Font("Yu Mincho Demibold", Font.BOLD | Font.ITALIC, 42));
		lblUserInformation.setBounds(191, 22, 447, 40);
		panel_1.add(lblUserInformation);
		
		
		
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
		panel_1.add(button);
		frame.setVisible(true);
	}
}
