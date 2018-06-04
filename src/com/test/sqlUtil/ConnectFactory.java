package com.test.sqlUtil;

import java.sql.*;

public class ConnectFactory {

	String driver = "com.mysql.jdbc.Driver";
	//String url = "jdbc:mysql://localhost:3306/ic?user=root&password=twl12345&useUnicode=true&characterEncoding=UTF8&useSSL=false";
	//String url = "jdbc:mysql://testazsuredatabase.mysqldb.chinacloudapi.cn:3306/ic?user=twl@testazsuredatabase&password=Shenxiaoji12138&useUnicode=true&characterEncoding=UTF8&useSSL=false";
	String url = "jdbc:mysql://intelligentbarber.mysqldb.chinacloudapi.cn:3306/ic?user=WillinTan@intelligentbarber&password=twl12345@&useUnicode=true&characterEncoding=UTF8&useSSL=false";


	private Connection conn;
	private Statement stat;
	private ResultSet rs;
	public static ConnectFactory factory = new ConnectFactory();
	
	public static ConnectFactory getInstance(){
		return factory;
	}
	
	public Connection makeConnect() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
		return conn;
	}

	public Statement getStat() throws SQLException {
		stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		return stat;
	}

	public int getUpdateRsNum(String sql) throws SQLException, ClassNotFoundException {
		conn = makeConnect();
		stat = getStat();
		int num = stat.executeUpdate(sql);
		return num;
	}

	public void UseUpdate(String sql) throws SQLException, ClassNotFoundException {
		conn = makeConnect();
		stat = getStat();
		stat.executeUpdate(sql);
	}

	public ResultSet getQueryRs(String sql) throws SQLException, ClassNotFoundException {
		conn = makeConnect();
		stat = getStat();
		rs = stat.executeQuery(sql);
		return rs;
	}

	public void closeConn() throws SQLException {
		stat.close();
		rs.close();
		conn.close();
	}
}
