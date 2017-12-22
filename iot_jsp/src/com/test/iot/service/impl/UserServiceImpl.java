package com.test.iot.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;
import com.test.iot.dao.impl.UserDAOImpl;
import com.test.iot.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO ud = new UserDAOImpl();
	@Override
	public ArrayList<HashMap<String, Object>> getUserList() {
		try {
			Connection con = DBCon.getCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<HashMap<String,Object>> userList = ud.selectUserList();
		try {
			DBCon.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public HashMap<String, Object> getUser() {
		return null;
	}

}
