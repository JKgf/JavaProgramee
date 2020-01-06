package com.gf.sql;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
@SuppressWarnings("unused")
public class SqlServer {//外观模式之数据库连接
	private Connection conn = null;
	private java.sql.Statement statement = null;
	
	public void open(String jdbcUrl,String userName,String userPwd) {	
		//连接数据库，第一个参数为驱动类型，第二个参数为连接链接，第三个参数为数据库登录名，第四个为登录密码
		try {
			//Class.forName("com.mysql.jdbc.Driver");	//连接SQLserver时去掉这一句		
			conn = (Connection) DriverManager.getConnection(jdbcUrl, userName, userPwd);
			statement = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql) {		
		//执行更新语句（insert,delete,update)
		try {
			return ((java.sql.Statement) statement).executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return - 1;
		}
	}
	
	public ResultSet executeQuery(String sql) {
		//执行查询语句
		try {
			return ((java.sql.Statement) statement).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void close() {		
		//关闭连接
		try {
			((Connection) statement).close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
 	public static void main(String[] args) {
 		SqlServer jfd = new SqlServer();
 		//String driver = "com.mysql.jdbc.Driver";
 		//String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/db_lr?"
		//		+ "useUnicode=true&characterEncoding=UTF-8";
 		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mydb2;";
		String userName = "sa";
		String userPwd = "123456";
 		
 		jfd.open(url, userName, userPwd);
		System.out.println("连接成功");
		
		//执行查询
		ResultSet set = jfd.executeQuery("select * from demo");
		try {
			while(set.next()){
				String string = set.getString("hello");
				System.out.println(string);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jfd.close();
	}
}