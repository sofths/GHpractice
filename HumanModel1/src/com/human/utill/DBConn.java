package com.human.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {

	private DBConn() {}
	private static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	public static Connection getInstance() {
		if (dbConn == null) {
			try {//접속 dbConn이 null 일경우
				Class.forName ("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String id = "c##human",pw ="human";
				dbConn = DriverManager.getConnection(url,id,pw);
				System.out.println("DriverManagerConnection...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static int statementUpdate(String sql) {
		int resultValue= 0; // 업데이트
		try {
			if(st ==null) { 
				st = dbConn.createStatement();
			}
			resultValue = st.executeUpdate(sql);
			System.out.println("statementExecuteUpdate...");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultValue;
	}
	public static ResultSet statementQuery(String sql) {
		try { //추가
			if (st==null) {
				st = dbConn.createStatement();
				System.out.println("statementQuery...");
			}
			rs=st.executeQuery(sql);
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return rs;
	}
	public static void dbClose() {
		try {// 끝나면 닫는거
			if ( rs != null) rs.close();
			if ( st != null) st.close();
			if(dbConn != null) dbConn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			st = null;
			dbConn = null;
		}
	}
}
