package com.test.iot.user.impl;

import java.util.HashMap;
import java.util.Scanner;

import com.test.iot.user.User;

public class UserImpl implements User {
	
	
	
	@Override
	public HashMap<String, Object> getUserI() {
		Scanner s = new Scanner(System.in);
		HashMap<String, Object> hm = new HashMap<String,Object>();
		System.out.println("아이디를 입력하고 엔터를 누르세요");
		hm.put("uiid",s.nextLine());
		System.out.println("이름을 입력하고 엔터를 누르세요");
		hm.put("uiname",s.nextLine());
		System.out.println("나이를 입력하고 엔터를 누르세요");
		hm.put("uiage",s.nextLine());
		System.out.println("패스워드를 입력하고 엔터를 누르세요");
		hm.put("uipwd",s.nextLine());
		System.out.println("주소를 입력하고 엔터를 누르세요");
		hm.put("uiaddress",s.nextLine());
		return hm;
	}
	
	@Override
	public HashMap<String, Object> getUserD() {
		Scanner s = new Scanner(System.in);
		HashMap<String, Object> hm = new HashMap<String,Object>();
		System.out.println("번호를 입력하고 엔터를 누르세요");
		hm.put("uino",s.nextLine());
		System.out.println("아이디를 입력하고 엔터를 누르세요");
		hm.put("uiid",s.nextLine());
		return hm;
	}
	
	
	@Override
	public HashMap<String, Object> updateUser() {
		Scanner s = new Scanner(System.in);
		HashMap<String, Object> hm = new HashMap<String,Object>();
		System.out.println("무엇을 변경 하시겠습니까?");
		hm.put("set",s.nextLine());
		System.out.println("변경할 값을 입력해주세요");
		hm.put("v1",s.nextLine());
		System.out.println("변경할 인덱스를 입력해주세요.");
		hm.put("v2",s.nextLine());
		return hm;
	}
	
	
	

}
