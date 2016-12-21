package com.aggregator.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aggregator.entity.Blog;
import com.aggregator.entity.Item;
import com.aggregator.entity.Role;
import com.aggregator.entity.User;
import com.aggregator.repository.BlogRepository;
import com.aggregator.repository.ItemRepository;
import com.aggregator.repository.RoleRepository;
import com.aggregator.repository.UserRespository;

@Service
@Transactional
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRespository.save(userAdmin);
		
		Blog blogJava = new Blog();
		blogJava.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJava.setName("First");
		blogJava.setUser(userAdmin);
		blogRepository.save(blogJava);
		
		Item item1 = new Item();
		item1.setBlog(blogJava);
		item1.setDescription("This is a Java Blog");
		item1.setLink("http://www.google.com");
		item1.setTitle("First");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJava);
		item2.setDescription("This is a Java Blog");
		item2.setLink("http://www.google.com");
		item2.setTitle("Second");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
	}
}
