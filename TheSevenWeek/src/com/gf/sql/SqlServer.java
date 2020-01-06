package com.gf.sql;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
@SuppressWarnings("unused")
public class SqlServer {//���ģʽ֮���ݿ�����
	private Connection conn = null;
	private java.sql.Statement statement = null;
	
	public void open(String jdbcUrl,String userName,String userPwd) {	
		//�������ݿ⣬��һ������Ϊ�������ͣ��ڶ�������Ϊ�������ӣ�����������Ϊ���ݿ��¼�������ĸ�Ϊ��¼����
		try {
			//Class.forName("com.mysql.jdbc.Driver");	//����SQLserverʱȥ����һ��		
			conn = (Connection) DriverManager.getConnection(jdbcUrl, userName, userPwd);
			statement = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql) {		
		//ִ�и�����䣨insert,delete,update)
		try {
			return ((java.sql.Statement) statement).executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return - 1;
		}
	}
	
	public ResultSet executeQuery(String sql) {
		//ִ�в�ѯ���
		try {
			return ((java.sql.Statement) statement).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void close() {		
		//�ر�����
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
		System.out.println("���ӳɹ�");
		
		//ִ�в�ѯ
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