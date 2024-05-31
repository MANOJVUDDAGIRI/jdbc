package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
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
			String sql = "insert into emp(id,name,email) value(?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter employee id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("enter employee name");
			pmst.setString(2, sc.next());
			System.out.println("enter employee email");
			pmst.setString(3, sc.next());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Inserted");
			}
			else {
				System.out.println("error");
			}
			sc.close();
			conn.close();
			pmst.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
}
