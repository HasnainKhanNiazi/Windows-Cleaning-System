import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RowPopUp extends JPopupMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Houseidv=null;
	String Namev=null;
	JPanel Dialog_Add;
	String street_Numberv=null;
	String No_Of_Windowsv=null;
	String paidv=null;
	String Weekv=null;
	String Payment_Methodv=null;
	String Amountv=null;
	String HouseDel=null;
	String Date=null;
	String NameDel=null;
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	private static final String SQL_INSERT = "INSERT INTO h_r"
		    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String connectionString="jdbc:mysql://localhost/FinalF";
	private Connection conn = null;
	private Statement st = null;
	
	public RowPopUp(JTable table) {
		JMenuItem Edit = new JMenuItem("Edit");
		JMenuItem delete = new JMenuItem("Delete");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField HouseID = new JTextField();
				JTextField Name = new JTextField();
				JTextField Street_Number = new JTextField();
				JTextField No_Of_Windows = new JTextField();
				JTextField Week = new JTextField();
				JTextField Payment_Method = new JTextField();
				JTextField Amount = new JTextField();
				JTextField Paid = new JTextField();
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
				Date = sdf.format(cal.getTime());
				Object[] sms = {
						"House No.",HouseID,
						"Name", Name,
						"Street Number",Street_Number,
						"Number Of Windows",No_Of_Windows,
						"Week",Week,
						"Payment Method",Payment_Method,
						"Paid", Paid,
						"Amount",Amount
				};
				int n = JOptionPane.showConfirmDialog(Dialog_Add,sms,"Enter Data",JOptionPane.OK_CANCEL_OPTION);
				if(n == JOptionPane.OK_OPTION){
					Houseidv = HouseID.getText();
					Namev = Name.getText();
					street_Numberv = Street_Number.getText();
					No_Of_Windowsv = No_Of_Windows.getText();
					Weekv = Week.getText();
					Payment_Methodv = Payment_Method.getText();
					paidv = Paid.getText();
					Amountv = Amount.getText();
					if(paidv == null){
						Amountv = null;
					}
					try {
						conn = DriverManager.getConnection(connectionString,"root",null);
						st = conn.createStatement();
						String sql = "delete from h_r where houseid = '"+Houseidv+"' and Name = '"+Namev+"'";
						st.executeUpdate(sql);
						Add();
						DefaultTableModel df = (DefaultTableModel) table.getModel();
						int i = table.getSelectedRow();
						df.removeRow(i);
						df.addRow(new Object[]{Houseidv,Namev,street_Numberv,No_Of_Windowsv,Weekv,Payment_Methodv,paidv,Amountv,Date});
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField HouseID_D = new JTextField();
				JTextField NameD = new JTextField();
				Object[] sms = {
					"House No.",HouseID_D,
					"Name ",NameD
				};
				try {
					int i = table.getSelectedRow();
					String Table_Click = (table.getModel().getValueAt(i, 0).toString());
					String Table_Click1 = (table.getModel().getValueAt(i, 1).toString());
					conn = DriverManager.getConnection(connectionString,"root",null);
					st = conn.createStatement();
					int n = JOptionPane.showConfirmDialog(null, "Are you Sure?");
					if(n==JOptionPane.YES_OPTION){
					String sql = "delete from h_r where houseid = '"+Table_Click+"' and Name = '"+Table_Click1+"'";
					st.executeUpdate(sql);
					DefaultTableModel df = (DefaultTableModel) table.getModel();
					df.removeRow(i);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(Edit);
		add(new JSeparator());
		add(delete);
	}
	public void Add(){
		try {
			conn = DriverManager.getConnection(connectionString,"root",null);
			st = conn.createStatement();
			PreparedStatement prep = conn.prepareStatement(SQL_INSERT);
		      prep.setString(1, Houseidv);
		      prep.setString(2, Namev);
		      prep.setString(3, street_Numberv);
		      prep.setString(4, No_Of_Windowsv);
		      prep.setString(5, Weekv);
		      prep.setString(6, Payment_Methodv);
		      prep.setString(7, paidv);
		      prep.setString(8, Amountv);
		      prep.setString(9, Date);
		      prep.executeUpdate();
		}
		catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(st!=null)
		            st.close();
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
	
	
}
