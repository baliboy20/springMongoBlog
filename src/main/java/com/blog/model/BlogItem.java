package com.blog.model;

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

	public BlogItem() {
	}
}
