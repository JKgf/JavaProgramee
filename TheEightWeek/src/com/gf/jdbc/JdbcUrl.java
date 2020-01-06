package com.gf.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class JdbcUrl {
    public static void  main(String[] args) throws SQLException, ClassNotFoundException {
        Sql01 dbt=new Sql01();
        Sql02 dbt2=new Sql02();
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择要执行的数据库：1.MySQL 2.SQL Server");
        int db=sc.nextInt();
        if(db==1) {
        	 dbt.test01();
        }
        else
            dbt2.test02();
    }
}