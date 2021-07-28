package com.shipper.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shipper.domain.Authority;
import com.shipper.domain.User;
import com.shipper.repository.UserDetailsRepository;
import com.shipper.responses.UserRegister;



@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	List<Authority> authorityList;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDetailsRepository.findByUserName(username);
		
		if(null==user) {
			throw new UsernameNotFoundException("User Not Found with userName "+username);
		}
		return user;
	}
	
	private Authority setAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRole(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
	public Boolean createUser(UserRegister userToRegister) {
		boolean result = false; 
		String role = "USER";
		String role2 = "user role";
		if (userDetailsRepository.findByUserName(userToRegister.getUserName())== null) {
			authorityList=new ArrayList<>();
			authorityList.add(setAuthority(role,role2));
			User user = new User();
			user.setFirstName(userToRegister.getUserName());
			user.setEmail(userToRegister.getEmail());
			user.setUserName(userToRegister.getUserName());
			user.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
			user.setEnabled(true);
			user.setAuthorities(authorityList);
			userDetailsRepository.save(user);
			result = true;
		}
		
		return result;
	}
	
	@PostConstruct
	protected void init() {
		createUser("admin", "ADMIN", "Admin role", "admin");
		createUser("user", "USER", "user role", "user");
	}
	
	private void createUser(String userName, String role, String role2, String password) {
		List<Authority> authorityList=new ArrayList<>();
		authorityList.add(createAuthority(role,role2));
		User user=new User();
		user.setUserName(userName);
		user.setFirstName(userName);
		user.setPassword(passwordEncoder.encode(password));
		user.setEnabled(true);
		user.setAuthorities(authorityList);
		userDetailsRepository.save(user);
		
	}
	
	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRole(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}
