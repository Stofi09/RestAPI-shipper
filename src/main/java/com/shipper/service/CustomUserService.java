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
import com.shipper.repository.AuthorityRepository;
import com.shipper.repository.UserDetailsRepository;
import com.shipper.responses.UserInfo;
import com.shipper.responses.UserRegister;



@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	AuthorityRepository autRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private User user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDetailsRepository.findByUserName(username);
		
		if(null==user) {
			throw new UsernameNotFoundException("User Not Found with userName "+username);
		}
		return user;
	}
	
	public List<User> getAllUser(){
		return userDetailsRepository.findAll();
	}
	
	public Boolean createUser(UserRegister userToRegister) {
		Long i = (long) 1;
		boolean result = false; 
		List<Authority> authorityList = new ArrayList<>();
		// Set the role at the beginning as a user.
		authorityList.add(autRepository.findByRole("USER"));
		System.out.println();
		if (userDetailsRepository.findByUserName(userToRegister.getUserName())== null) {
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
		
		List<Authority> authorityList = new ArrayList<>();
		
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

	public void updateUser(UserInfo message) {
		List<Authority> authorityList = new ArrayList<>();
		if (message.getRoles().toString().contains("USER")) {
			authorityList.add(autRepository.findByRole("USER"));
		}
		if (message.getRoles().toString().contains("ADMIN")) {
			authorityList.add(autRepository.findByRole("ADMIN"));
		}
		user = userDetailsRepository.findFirstById(message.getId());
		if (authorityList.isEmpty()) {
			System.out.println("This is empty");
		}else {
			user.setAuthorities(authorityList);
		}
		userDetailsRepository.save(user);
	}

	public void deleteEquipment(Long id) {
		userDetailsRepository.deleteById(id);
		
	}

}
