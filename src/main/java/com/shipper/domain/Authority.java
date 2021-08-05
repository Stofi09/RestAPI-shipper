package com.shipper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Table(name = "AUTH_AUTHORITY")
@Entity
public class Authority implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ROLE_CODE")
	private String role;
	
	@Column(name = "ROLE_DESCRIPTION")
	private String roleDescription;
	
	

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String roleCode) {
		this.role = roleCode;
	}



	public String getRoleDescription() {
		return roleDescription;
	}



	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}



	@Override
	public String toString() {
		return role;
	}

	
	
}
