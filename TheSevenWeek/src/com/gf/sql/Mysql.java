package com.gf.sql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
 
@SuppressWarnings("unused")
public class Mysql {//外观模式之数据库连接
	private Connection conn = null;
	private Statement statement = null;
	
	public void open(String driver,String jdbcUrl,String userName,String userPwd) {	
		//连接数据库，第一个参数为驱动类型，第二个参数为连接链接，第三个参数为数据库登录名，第四个为登录密码
		try {
			Class.forName(driver);			
			conn = (Connection) DriverManager.getConnection(jdbcUrl, userName, userPwd);
			statement = (Statement) conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql) {		
		//执行更新语句（insert,delete,update)
		try {
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return - 1;
		}
	}
	
	public ResultSet executeQuery(String sql) {
		//执行查询语句
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void close() {		
		//关闭连接
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
 	public static void main(String[] args) {
 		Mysql jfd = new Mysql();
 		String driver = "com.mysql.jdbc.Driver";
 		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/mydb1?"
				+ "useUnicode=true&characterEncoding=UTF-8";		//指定数据源
		String userName = "root";						//数据库登录名
		String userPwd = "123456";						//登录密码
 		
 		jfd.open(driver, jdbcUrl, userName, userPwd);
		System.out.println("连接成功");
		
		//执行查询
		ResultSet set = jfd.executeQuery("select * from employee");
		try {
			while(set.next()){
				String string = set.getString("username");
				System.out.println(string);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jfd.close();				//关闭连接
	}
}
