package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class update {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String Username = "root";
	private static final String Password = "Manoj@123";
	private static final String Url = "jdbc:mysql://localhost:3306/demo";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			String sql = "select * from emp where id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter employee id");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
			System.out.println("id"+ rs.getInt("id")+
					"name"+rs.getString("name")+
					"email"+rs.getString("email"));
		}
			pmst.close();
			sc.close();
			conn.close();
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
		}
}
