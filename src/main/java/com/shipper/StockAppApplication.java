package com.shipper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shipper.domain.Authority;
import com.shipper.domain.User;
import com.shipper.repository.UserDetailsRepository;


@SpringBootApplication
public class StockAppApplication {
	
	
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(StockAppApplication.class, args);
		
	}
	
	
	
}
