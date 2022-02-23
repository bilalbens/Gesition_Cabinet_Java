import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conn=null;
	public static Connection dbConnector(){
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqLite2\\cabinet.db");
			

			return conn;
			
		}catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
			JOptionPane.showMessageDialog(null, "Failed to Connect");
			return null;
		}
	}

}
