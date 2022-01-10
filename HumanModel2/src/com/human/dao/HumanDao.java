package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.HumanDto;
import com.human.utill.DBConn;
import com.human.utill.UserInput;

public class HumanDao {
	public int insert(HumanDto dto) { //DB insert 
		int rValue=0;
		DBConn.getInstance();
		String sql = String.format("insert into human values"+"('%s',%d,%f,"+"to_date('%s','yyyy/MM/dd')",
				dto.getName(),dto.getAge(),dto.getHeight(),UserInput.dateToString(dto.getBirthday()));
		System.out.println(sql);
		rValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return rValue;
	}
	public int update(String name,String reName) {//DB update
		int retrunValue=0;
		DBConn.getInstance();
		System.out.println(name+":"+reName);
		String sql="update human set name='%s' where name='%s' ";
		sql = String.format(sql,reName,name);
		retrunValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return retrunValue;
	}
	public int delete(String name) {//DB delete
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "delete human where name='%s'";
		sql = String.format(sql, name);
		System.out.println(sql);
		DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}
	public ArrayList<HumanDto> select() { //DB 에서 받은 값 
		ArrayList<HumanDto> arr = new ArrayList<HumanDto> ();
		DBConn.getInstance();
		String sql = "select * from human";
		System.out.println(sql);
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				arr.add(new HumanDto (rs.getString(1),
						rs.getInt(2),
						rs.getDouble(3),
						rs.getTimestamp(4)
						));
			}
		}catch (SQLException e) { 
			e.printStackTrace();
			
		}
		DBConn.dbClose();
		return arr;
	}
}
