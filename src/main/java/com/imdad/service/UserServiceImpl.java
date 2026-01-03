package com.imdad.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdad.binding.LoginForm;
import com.imdad.binding.SignUpForm;
import com.imdad.entity.UserEntity;
import com.imdad.repository.UserRepo;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public boolean signup(SignUpForm form) {
		// TODO Auto-generated method stub
		
		UserEntity user = userRepo.findByEmail(form.getEmail());
		
		if(user != null) {
			return false;
		}
		
		UserEntity entity = new UserEntity();
		
		BeanUtils.copyProperties(form, entity);
		
		userRepo.save(entity);
		
		return true;
	}

	@Override
	public String login(LoginForm form) {
		// TODO Auto-generated method stub
		String email = form.getEmail();
		
		UserEntity userEntity = userRepo.findByEmail(email);
		
		if(userEntity == null) {
			return "You are not register please login";
		}
		
		if(!userEntity.getPwd().equals(form.getPwd())) {
			return "Incorrect Password";
		}
		
		
		return "success";
	}

}
