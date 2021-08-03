package com.shipper.repository;

import org.springframework.data.repository.CrudRepository;

import com.shipper.domain.Authority;


public interface AuthorityRepository extends CrudRepository<Authority, Long> {

	Authority findByRole(String role);
}
