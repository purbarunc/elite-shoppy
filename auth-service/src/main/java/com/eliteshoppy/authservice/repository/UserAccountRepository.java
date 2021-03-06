package com.eliteshoppy.authservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.eliteshoppy.authservice.model.UserAccount;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

	@Query("{ 'username' : ?0 }")
	Optional<List<UserAccount>> findByUsername(String username);
}
