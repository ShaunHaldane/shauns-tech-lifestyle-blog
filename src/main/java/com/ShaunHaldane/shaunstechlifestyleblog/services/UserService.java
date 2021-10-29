package com.ShaunHaldane.shaunstechlifestyleblog.services;

import com.ShaunHaldane.shaunstechlifestyleblog.models.User;

public interface UserService {

	public void createNewAccount(User user);
	
	public boolean loginExists(String login);
	
}
