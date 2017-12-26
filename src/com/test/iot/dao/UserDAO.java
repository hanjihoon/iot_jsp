package com.test.iot.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public interface UserDAO {
	
	public ArrayList<HashMap<String,Object>> selectUserList(Connection con);
	public ArrayList<HashMap<String, Object>> selectUser(Connection con, Object o);
	public int insertUser(Connection con, HashMap<String, Object> user);
	public int deleteUser(Connection con, HashMap<String, Object> userD);
	public int updateUser(Connection con, HashMap<String, Object> updateUser);
	
}
