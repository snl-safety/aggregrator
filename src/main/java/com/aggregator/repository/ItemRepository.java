package com.aggregator.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aggregator.entity.Blog;
import com.aggregator.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog, Pageable pageable);

}
