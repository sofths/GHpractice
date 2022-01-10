package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.HumanDto;
import com.human.util.DBConn;

public class HumanDao {
	public int delete(String name) {
		int returnValue=0;
		String sql=String.format(
				"delete human where name ='%s'",
				 name
				);
		System.out.println(sql);
		DBConn.getInstance();
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();

		return returnValue;
	}
	public int update(String name,String age) {
		int returnValue=0;
		String sql=String.format(
				"update human set age=%s where name ='%s'",
				 age,name
				);
		System.out.println(sql);
		DBConn.getInstance();
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();

		return returnValue;
	}
	public ArrayList<HumanDto> select(String name) {
		ResultSet rs=null;
		ArrayList<HumanDto> dtos=new ArrayList<HumanDto>();
		String sql=String.format("select * from human "
				+ "where name like '%%%s%%'",
				name);
		System.out.println(sql);
		DBConn.getInstance();
		rs=DBConn.statementQuery(sql);
		
		if(rs!=null) {
			try {
					while(rs.next()) {
						dtos.add(
							new HumanDto(
								rs.getString("name"),
								rs.getInt("age"),
								rs.getDouble("height"),
								rs.getDate("birthday")
							)
						);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		DBConn.dbClose();
		return dtos;
	}
	public int insert(HumanDto h) {
		int returnValue=0;
		String sql=String.format(
		"insert into human "+
		"values ('%s',%d,%f,to_date('%s',"+
		"'YYYY-MM-DD HH24:MI:SS'))"
		, h.getName(),h.getAge(),h.getTall()
		,h.getBirthString());
		DBConn.getInstance();
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();
		
		return returnValue;
	}

}
