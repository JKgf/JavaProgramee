package com.gf.structure.bridge;
public class OracleDriver implements JdbcInterface {

    @Override
    public void connect() {
        System.out.println("Oracle驱动连接Oracle数据库...");
    }
}