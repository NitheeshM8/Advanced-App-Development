package com.example.dreamproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dreamproject.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByName(String username);
	Optional<User> findByEmail(String email);
	Boolean existsByName(String username);
	Boolean existsByEmail(String email);
}