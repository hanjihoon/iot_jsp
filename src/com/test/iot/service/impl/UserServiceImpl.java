package com.test.iot.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;
import com.test.iot.dao.impl.UserDAOImpl;
import com.test.iot.service.UserService;
import com.test.iot.user.User;
import com.test.iot.user.impl.UserImpl;

public class UserServiceImpl implements UserService{
	private UserDAO ud = new UserDAOImpl();
	private User u = new UserImpl();
	
	@Override
	public ArrayList<HashMap<String, Object>> getUserList() {
		Connection con = null;
		try {
			con = DBCon.getCon();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ArrayList<HashMap<String, Object>> userList = ud.selectUserList(con);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return userList;
	}

	
	@Override
	public int insertUser() {

		Connection con = null;
		try {
			con = DBCon.getCon();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		int result = 0;
		result = ud.insertUser(con, u.getUserI());
		if(result > 0) {
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else {
			try {
				con.rollback();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
		return result;
	}
	
	@Override
	public int deleteUser() {

		Connection con = null;
		try {
			con = DBCon.getCon();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		int result = 0;
		result = ud.deleteUser(con, u.getUserD());
		if(result > 0) {
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else {
			try {
				con.rollback();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
		return result;
	}
	@Override
	public int updateUser() {

		Connection con = null;
		try {
			con = DBCon.getCon();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		int result = 0;
		result = ud.updateUser(con, u.updateUser());
		if(result > 0) {
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else {
			try {
				con.rollback();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
		return result;
	}

	@Override
	public ArrayList<HashMap<String, Object>> getUser(Object o) {
		Connection con = null;
		try {
			con = DBCon.getCon();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ArrayList<HashMap<String, Object>> userList = ud.selectUser(con, o);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return userList;
		
	}





}