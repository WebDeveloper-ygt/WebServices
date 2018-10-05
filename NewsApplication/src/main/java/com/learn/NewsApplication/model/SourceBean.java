package com.learn.NewsApplication.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SourceBean {

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
