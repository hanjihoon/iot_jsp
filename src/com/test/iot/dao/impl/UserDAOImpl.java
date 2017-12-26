package com.test.iot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	public ArrayList<HashMap<String, Object>> selectUserList(Connection con) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("uino", rs.getString("uino"));
				hm.put("uiname", rs.getString("uiname"));
				hm.put("uiage", rs.getString("uiage"));
				hm.put("uiid", rs.getString("uiid"));
				hm.put("uipwd", rs.getString("uipwd"));				
				hm.put("cino", rs.getString("cino"));		
				hm.put("uiregdate", rs.getString("uiregdate"));	
				hm.put("address", rs.getString("address"));	
				userList.add(hm);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		return userList;
	}

	public int insertUser(Connection con,HashMap<String, Object> user) {
		String sql = "insert into user_info(uiid, uiname, uiage, uipwd, cino, uiregdate, address)";
		sql += " values(?,?,?,?,1,now(),?)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, user.get("uiid"));
			ps.setObject(2, user.get("uiname"));
			ps.setObject(3, user.get("uiage"));
			ps.setObject(4, user.get("uipwd"));
			ps.setObject(5, user.get("address"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteUser(Connection con,HashMap<String, Object> user) {
		String sql = "delete from user_info where uino = ? or uiid = ?";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, user.get("uino"));
			ps.setObject(2, user.get("uiid"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateUser(Connection con,HashMap<String, Object> user) {
		String sql = "update user_info set ? = ? where uino = ?";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, user.get("set"));
			ps.setObject(2, user.get("v1"));
			ps.setObject(4, user.get("v2"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public ArrayList<HashMap<String, Object>> selectUser(Connection con,Object o) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from user_info where uino = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, o);
			rs = ps.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("uino", rs.getString("uino"));
				hm.put("uiname", rs.getString("uiname"));
				hm.put("uiage", rs.getString("uiage"));
				hm.put("uiid", rs.getString("uiid"));
				hm.put("uipwd", rs.getString("uipwd"));				
				hm.put("cino", rs.getString("cino"));		
				hm.put("uiregdate", rs.getString("uiregdate"));	
				hm.put("address", rs.getString("address"));	
				userList.add(hm);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		return userList;
	}

	
	
	
	
	
	
	
	

}
