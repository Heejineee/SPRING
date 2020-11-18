package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {
	private Connection conn;
	private PreparedStatement ps;
	private String driver, url, username, password;
	public DBConnection(String driver, String url, String username, String password)	// 값을 넣어야하기 때문에 메모리할당 따로 해야함(application-context.xml 에 bean에서)
	{
		this.driver=driver;
		this.url=url;
		this.username=username;
		this.password=password;
		
		try
		{
			Class.forName(driver);
		}catch(Exception ex){}
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(url, username, password);
		}catch(Exception ex){}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex){}
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public PreparedStatement getPs() {
		return ps;
	}
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}
	
}
