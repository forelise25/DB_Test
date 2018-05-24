import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConnectDB {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void connectTest() {
		Connection con = null;
		try {
			con=dataSource.getConnection();
			System.out.println("제대로대로연결");
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
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("dbConfig.xml");
		ConnectDB db = (ConnectDB)ctx.getBean("connectDB");
		db.connectTest();
	}
}
