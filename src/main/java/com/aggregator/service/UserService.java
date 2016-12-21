package com.aggregator.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aggregator.entity.Blog;
import com.aggregator.entity.Item;
import com.aggregator.entity.User;
import com.aggregator.repository.BlogRepository;
import com.aggregator.repository.ItemRepository;
import com.aggregator.repository.UserRespository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRespository userRespository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;

	public List<User> findAll() {
		return userRespository.findAll();
	}

	public User findOne(Integer id) {
		return userRespository.findOne(id);
	}

	@Transactional
	public User findUserWithBlogs(Integer id) {
		User user = this.findOne(id);

		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		userRespository.save(user);
	}
}
