package com.hb.guest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class GuestDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GuestDao() throws Exception {
		Class.forName("org.h2.Driver");
		conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test"
				, "sa", "");
	}
	
	public void insertOne(GuestDto dto) throws IllegalArgumentException,SQLException{
		String sql ="insert into guest values (?,?,sysdate,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getSabun());
		pstmt.setString(2, dto.getName());
		pstmt.setInt(3, dto.getPay());
		int result= pstmt.executeUpdate();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		if(result<1){
			throw new IllegalArgumentException();   
		}
		
	}
	
	public GuestDto selectOne(int sabun) throws SQLException{
		String sql="SELECT * FROM GUEST WHERE SABUN=?";

		GuestDto dto=null;
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, sabun);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
			dto = new GuestDto();
			dto.setSabun(rs.getInt("sabun"));
			dto.setName(rs.getString("name"));
			dto.setNalja(rs.getDate("nalja"));
			dto.setPay(rs.getInt("pay"));
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
		return dto;
	}
	public ArrayList selectAll() throws SQLException{
		String sql="SELECT * FROM GUEST";
		
		ArrayList list = new ArrayList();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			GuestDto dto = new GuestDto();
			dto.setSabun(rs.getInt("sabun"));
			dto.setName(rs.getString("name"));
			dto.setNalja(rs.getDate("nalja"));
			dto.setPay(rs.getInt("pay"));
			list.add(dto);
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
		return list;
	}
}
