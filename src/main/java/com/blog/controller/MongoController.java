package com.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController()
public class MongoController {

	@Autowired
	BlogRepository repos;

	@Autowired
	MongoTemplate mongoTemplate;

	@GetMapping("/blogs")
	@CrossOrigin()
	List<BlogItem> BlogList() {
		return repos.findAll();

	}

	@GetMapping("/blog/{id}")
	@CrossOrigin()

	List<BlogItem> getBlog(@PathVariable("id") String id) {
		System.out.println(id);
		return repos.findAll();
	}

	@PostMapping("/blogs/search")
	@CrossOrigin()
	List<BlogItem>  getBlogSearch( @RequestBody String srch) throws JsonParseException, JsonMappingException, IOException  {

		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> parms = new HashMap(); 
		try {
		parms = mapper.readValue(srch, new TypeReference<Map<String, String>>() {} );
		} catch(JsonGenerationException e) {
			return null;
		}
		Query qry = new Query();
		qry.addCriteria( Criteria.where("title").is(parms.get("title") ) );
		List<BlogItem> itms = mongoTemplate.find(qry, BlogItem.class);
		System.out.println(itms);
		return itms;
	}

	@PostMapping("/blog")
	@CrossOrigin()

	List<BlogItem> addBlog(@RequestBody BlogItem blogitem) {
		BlogItem bl = repos.insert(blogitem);
		return repos.findAll();

	}

	@DeleteMapping("/blog/{id}")
	@CrossOrigin()

	List<BlogItem> deleteBlog(@PathVariable("id") String id) {
		System.out.println(id);

		repos.delete(id);
		return repos.findAll();
	}

	@PutMapping("/blog")
	@CrossOrigin()
	List<BlogItem> replaceBlog(@RequestBody BlogItem blog) {
		System.out.println("update:" + blog);
		BlogItem a = repos.save(blog);
		if (a != null) {
			return repos.findAll();
		} else {
			return null;
		}
	}

}
