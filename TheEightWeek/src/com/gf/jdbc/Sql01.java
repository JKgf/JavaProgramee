package com.gf.jdbc;


import java.sql.*;

public  class Sql01 {
    public void test01() throws SQLException, ClassNotFoundException {
        String driverName="com.mysql.jdbc.Driver";//��������  mysql-connector-java 5����cj.
        String url="jdbc:mysql://localhost:3306/teaching?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
        String userName="root";
        String password="123456";
        Class.forName(driverName);//��Java�������ݿ������ķ����ǵ���Class��ľ�̬����forName
        Connection connection= DriverManager.getConnection(url,userName,password);
        //DriverManagerע������ getConnection��DriverManager����ķ���
        //�����ݿ���д���������
        String sql1="create table student2(sno int primary key,sname char(10))";//����student2������sno,sname
        String sql2="insert into student2 values(01,'hello')";//����student2������sno,sname
        Statement statement=connection.createStatement();//��ȡStatement����
        statement.execute(sql1);
        statement.execute(sql2);
        System.out.println("������ϣ�");
        statement.close();
    }
}
