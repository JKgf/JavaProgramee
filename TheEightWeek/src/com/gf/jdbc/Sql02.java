package com.gf.jdbc;

import java.sql.*;

public class Sql02 {
    public void test02() throws ClassNotFoundException, SQLException {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL Server��������
        String url="jdbc:sqlserver://192.168.0.104:1433;DatabaseName=teaching";
        //JDKΪ1.6���µ�jdbc���ӵ�jarʹ��sqljdbc.jar,����ʹ��sqljdbc4.jar
        String userName="sa";
        String password="123456";
        Class.forName(driverName);//��Java�������ݿ������ķ����ǵ���Class��ľ�̬����forName
        Connection connection= DriverManager.getConnection(url,userName,password);
        //DriverManagerע������ getConnection��DriverManager����ķ���
        //�����ݿ���д���������
        String sql1="CREATE TABLE student2(sno INT PRIMARY KEY ,sname char(10) NOT NULL)";//����student2������sno,sname
        String sql2="INSERT INTO student2 VALUES(02,'world')";//����student2������sno,sname
        Statement statement=connection.createStatement();//��ȡStatement����
        statement.execute(sql1);
        statement.execute(sql2);

        System.out.println("������ϣ�");

        statement.close();
    }
}