package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	try {
		// step 1: register the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2: creating connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ritz", "root", "Ritesh@754");
		
		// step 3: creating statements
		Statement stmt = con.createStatement();
		
		// step 4: executing queries
		ResultSet rs = stmt.executeQuery("select * from emp");
		//ResultSet rs1 = stmt.executeQuery("select * from emp");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
		
		// step 5: closing connection
		rs.close();
		stmt.close();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	//Welcome Ritessh
}
