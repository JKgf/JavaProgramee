package com.gf.jdbc;


import java.sql.*;

public  class Sql01 {
    public void test01() throws SQLException, ClassNotFoundException {
        String driverName="com.mysql.jdbc.Driver";//驱动名称  mysql-connector-java 5不用cj.
        String url="jdbc:mysql://localhost:3306/teaching?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
        String userName="root";
        String password="123456";
        Class.forName(driverName);//　Java加载数据库驱动的方法是调用Class类的静态方法forName
        Connection connection= DriverManager.getConnection(url,userName,password);
        //DriverManager注册驱动 getConnection是DriverManager里面的方法
        //对数据库进行创建，插入
        String sql1="create table student2(sno int primary key,sname char(10))";//建表student2，设置sno,sname
        String sql2="insert into student2 values(01,'hello')";//建表student2，设置sno,sname
        Statement statement=connection.createStatement();//获取Statement对象
        statement.execute(sql1);
        statement.execute(sql2);
        System.out.println("处理完毕！");
        statement.close();
    }
}
