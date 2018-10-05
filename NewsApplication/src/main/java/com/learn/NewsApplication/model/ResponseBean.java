package com.learn.NewsApplication.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "newsDeatils")
public class ResponseBean {

	private String status;
	private int totalResult;
	private List<ArticlesBean> articles;
	
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

}
