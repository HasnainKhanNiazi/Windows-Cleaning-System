import java.sql.*;

public class Add_User_DBS {
	   static final String DB_URL = "jdbc:mysql://localhost/FinalF";
	   Connection conn = null;
	   Statement stmt = null;
	   private static final String SQL_INSERT = "INSERT INTO h_r"
			    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	   
	public Add_User_DBS(String H_number,String name,String Street_Num,String No_of_Windows,String weeks,String payment_Method,String paid,String Amount,String Date) {
		try{
		      conn = DriverManager.getConnection(DB_URL, "root", null);
		      stmt = conn.createStatement();
		      PreparedStatement prep = conn.prepareStatement(SQL_INSERT);
		      prep.setString(1, H_number);
		      prep.setString(2, name);
		      prep.setString(3, Street_Num);
		      prep.setString(4, No_of_Windows);
		      prep.setString(5, weeks);
		      prep.setString(6, payment_Method);
		      prep.setString(7, paid);
		      prep.setString(8, Amount);
		      prep.setString(9, Date);
		      prep.executeUpdate();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
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
	}