package com.shipper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import com.shipper.domain.Authority;
import com.shipper.domain.DeliveryList;
import com.shipper.domain.Equipment;
import com.shipper.domain.User;
import com.shipper.repository.UserDetailsRepository;
import com.shipper.responses.Message;
import com.shipper.service.MessageValidator;


@SpringBootApplication
public class StockAppApplication {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(StockAppApplication.class, args);
		
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
