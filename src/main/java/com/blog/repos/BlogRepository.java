package com.blog.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.model.BlogItem;


public interface BlogRepository extends MongoRepository<BlogItem, String> {
	public BlogItem findFirstByTitle(String title);
	 

}
