package com.learn.NewsApplication.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.learn.NewsApplication.model.Links;

@XmlRootElement(name = "exception")
public class ExceptionBean {

	private String name;
	private String description;
	private int statusCode;
	private List<Links> links;

	public ExceptionBean(String name, String description, int statusCode) {
		this.name = name;
		this.description = description;
		this.statusCode = statusCode;
	}
	
	public ExceptionBean() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}

	
}
