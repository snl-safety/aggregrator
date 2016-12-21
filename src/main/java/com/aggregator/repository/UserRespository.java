package com.aggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aggregator.entity.User;

public interface UserRespository extends JpaRepository<User, Integer>{

}
