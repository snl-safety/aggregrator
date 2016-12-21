package com.aggregator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aggregator.entity.Blog;
import com.aggregator.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByUser(User user);

}
