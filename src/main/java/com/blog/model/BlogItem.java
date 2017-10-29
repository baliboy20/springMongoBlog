package com.blog.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="blogs")
public class BlogItem {
	@Override
	public String toString() {
		return "BlogItem [title=" + title + ", id=" + id + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String title;

	@Id()
	public String id;

	public BlogItem(String title) {
		super();
		this.title = title;
	}
	
	public String content;
	public List<String> tags;
	public Date postedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public BlogItem(String title, String id, String content, List<String> tags, Date postedOn) {
		super();
		this.title = title;
		this.id = id;
		this.content = content;
		this.tags = tags;
		this.postedOn = postedOn;
	}

	public BlogItem() {
	}
}
