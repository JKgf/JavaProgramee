package com.gf.structure.bridge;
public class MysqlDriver implements JdbcInterface {

    @Override
    public void connect() {
        System.out.println("mysql驱动连接mysql数据库...");
    }
}