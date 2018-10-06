package com.learn.NewsApplication.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Links {

	private String rel;
	private String url;

	public Links(String rel, String url) {
		this.rel = rel;
		this.url = url;
	}

	public Links() {

	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
