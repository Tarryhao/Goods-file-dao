package goodsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecttion {
Connection conn=null;
public Connection getConnection() throws ClassNotFoundException, SQLException{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2.得到连接
	// DriverManager.getConnection("连接协议", "用户名", "密码");
	Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "Study_user", "123456");
	return conn;
	
}
public void closeConnection() throws SQLException{
	if(conn!=null){
		conn.close();
	}
}
}
