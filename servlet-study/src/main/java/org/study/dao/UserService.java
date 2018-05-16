package org.study.dao;

public class UserService {
	
	public boolean isValidUser(User user) {
		if(user.getUserPw().equals("servlet")) {
			user.setName("이명박");
			return true;
		}
		return false;
	}
	
	public Profile getProfile(String id) {
		Profile pro = new Profile(id);
		
		pro.setName("이명박");
		pro.setDesc("다스는 누구의 것인가??");
		
		return pro;
	}
	
}
