package com.test.iot.user;

import java.util.HashMap;

public interface User {

	HashMap<String, Object> getUserI();

	HashMap<String, Object> getUserD();

	HashMap<String, Object> updateUser();

}
