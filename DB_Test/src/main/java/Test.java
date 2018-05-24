import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		Connection con = null;
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String psw = "tiger";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//이곳에 오라클 드라이버 명이 들어가야함
			con = DriverManager.getConnection(url, user, psw);
			System.out.println("제대로 연결되었다.");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
