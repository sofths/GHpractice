package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	private DBConn() {}
	private static Connection dbConn=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	public static Connection getInstance() {
		if(dbConn==null) {
			try {
//			      <Context docBase="jsp09JDBC" path="/jsp09JDBC" reloadable="true" source="org.eclipse.jst.jee.server:jsp09JDBC">
//		      		<Resource name="jdbc/myoracle" auth="Container"
//		              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
//		              url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
//		              username="human" password="human" maxTotal="20" maxIdle="10"
//		              maxWaitMillis="-1"/>
//		      </Context></Host>
				//과거
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String id="c##human";
				String pw="human";
				dbConn=DriverManager.getConnection(url,id,pw);
				//컨넥션풀 사용
//				Context initContext=new InitialContext();
//				Context envContext=(Context)initContext.lookup("java:/comp/env");
//				DataSource ds=(DataSource)envContext.lookup("jdbc/myoracle");
//				dbConn=ds.getConnection ();
//				System.out.println("DBConnection....");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(dbConn!=null)dbConn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs=null;st=null;dbConn=null;
		}
		
	}
	public static int statementUpdate(String sql) {
		int rValue=-1;
		if(dbConn!=null) {
			try {
				if(st==null) {
					st=dbConn.createStatement();
				}
				//insert,delete,update
				rValue=st.executeUpdate(sql);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("not connected...");
		}
		return rValue;
	}
	public static ResultSet statementQuery(String sql) {
		if(dbConn!=null) {
			try {
				if(st==null) {
					st=dbConn.createStatement();
				}
				//select
				rs=st.executeQuery(sql);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("not connected...");
		}
		return rs;
	}
}







