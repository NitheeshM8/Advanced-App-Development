package com.example.dreamproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dreamproject.entity.Boat;

@Repository
public interface BoatRepo extends JpaRepository<Boat, String>{

}
