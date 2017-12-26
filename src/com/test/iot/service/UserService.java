package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {

	public ArrayList<HashMap<String,Object>> getUserList();

	public ArrayList<HashMap<String, Object>> getUser(Object o);

	public int insertUser();

	public int deleteUser();

	public int updateUser();




}
