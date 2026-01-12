package com.imdad.utils;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Encoder;

public class PasswordUtils {
	
	
	public static String encryptPassword(String password) throws Exception {
			
		//Adding salt in it 
		String saltedPassword = password + "im";
		
		//first encrypt the password then encode it 
		
		//encrypting password
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		
		messageDigest.reset();
		
		messageDigest.update(saltedPassword.getBytes());
	
		byte[] encryptedPassword = messageDigest.digest();
		
		//encoding password
		Encoder encoder = Base64.getEncoder();
		String encodeToString = encoder.encodeToString(encryptedPassword);
		
		
		return encodeToString;
		
	}

}
