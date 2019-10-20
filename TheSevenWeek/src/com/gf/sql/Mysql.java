package com.gf.sql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
 
@SuppressWarnings("unused")
public class Mysql {//���ģʽ֮���ݿ�����
	private Connection conn = null;
	private Statement statement = null;
	
	public void open(String driver,String jdbcUrl,String userName,String userPwd) {	
		//�������ݿ⣬��һ������Ϊ�������ͣ��ڶ�������Ϊ�������ӣ�����������Ϊ���ݿ��¼�������ĸ�Ϊ��¼����
		try {
			Class.forName(driver);			
			conn = (Connection) DriverManager.getConnection(jdbcUrl, userName, userPwd);
			statement = (Statement) conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql) {		
		//ִ�и�����䣨insert,delete,update)
		try {
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return - 1;
		}
	}
	
	public ResultSet executeQuery(String sql) {
		//ִ�в�ѯ���
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void close() {		
		//�ر�����
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
				+ "useUnicode=true&characterEncoding=UTF-8";		//ָ������Դ
		String userName = "root";						//���ݿ��¼��
		String userPwd = "123456";						//��¼����
 		
 		jfd.open(driver, jdbcUrl, userName, userPwd);
		System.out.println("���ӳɹ�");
		
		//ִ�в�ѯ
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
		
		jfd.close();				//�ر�����
	}
}
