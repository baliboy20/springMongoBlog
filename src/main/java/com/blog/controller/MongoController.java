package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.BlogItem;
import com.blog.repos.BlogRepository;

@RestController()
public class MongoController {

	@Autowired
	BlogRepository repos;

	@GetMapping("/blogs")
	@CrossOrigin()
	List<BlogItem> BlogList() {
		return repos.findAll();

	}

	@GetMapping("/blog/{id}")
	@CrossOrigin()

	String getBlog(@PathVariable("id") String id) {
		return "[{\"title\":\"Mr Williams id\"}]";

	}

	@PostMapping("/blog")

	@CrossOrigin()
	List<BlogItem> addBlog(@RequestBody BlogItem blogitem) {
		BlogItem bl = repos.insert(blogitem);
		return repos.findAll();

	}

	@DeleteMapping("/blog/{id}")
	@CrossOrigin()
	String deleteBlog(@PathVariable("id") String id) {
		System.out.println(id);

		repos.delete(id);
		return "delete done";

	}

	@PutMapping("/blog")
	@CrossOrigin()
	List<BlogItem> replaceBlog(@RequestBody BlogItem blog) {
		BlogItem a = repos.save(blog);
		if (a != null) {
			return repos.findAll();
		} else {
			return null;
		}

	}

}
