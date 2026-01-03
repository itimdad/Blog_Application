package com.imdad.service;

import com.imdad.binding.LoginForm;
import com.imdad.binding.SignUpForm;

public interface UserService {
	
	public boolean signup(SignUpForm form);
	
	public String login(LoginForm form);

}
