package com.shipper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shipper.domain.User;
import com.shipper.repository.UserDetailsRepository;
import com.shipper.responses.UserRegister;



@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDetailsRepository.findByUserName(username);
		
		if(null==user) {
			throw new UsernameNotFoundException("User Not Found with userName "+username);
		}
		return user;
	}
	
	public String createUser(UserRegister userToRegister) {
		
		if (userDetailsRepository.findByUserName(userToRegister.getUserName())== null) {
			User user = new User();
			user.setFirstName(userToRegister.getUserName());
			user.setEmail(userToRegister.getEmail());
			user.setPassword(userToRegister.getPassword());
			userDetailsRepository.save(user);
		}
		
		return "sikerult";
	}

}
