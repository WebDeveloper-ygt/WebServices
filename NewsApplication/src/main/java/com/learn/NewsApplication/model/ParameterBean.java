package com.learn.NewsApplication.model;

import javax.ws.rs.QueryParam;

public class ParameterBean {

	private @QueryParam("country") String country;
	private @QueryParam("q") String query;
	
	public ParameterBean() {

	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
