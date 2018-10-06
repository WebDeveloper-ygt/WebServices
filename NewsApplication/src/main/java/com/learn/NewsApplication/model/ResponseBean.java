package com.learn.NewsApplication.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "newsDeatils")
public class ResponseBean {

	private String status;
	private int totalResult;
	private List<ArticlesBean> articles = new ArrayList<>();
	private List<Links> links;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public List<ArticlesBean> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlesBean> articles) {
		this.articles = articles;
	}

	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}

	public void addLink(String url, String rel) {
		Links link =new Links(rel, url);
		links.add(link);
	}
}
