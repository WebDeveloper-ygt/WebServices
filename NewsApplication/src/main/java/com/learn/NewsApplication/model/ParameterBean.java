package com.learn.NewsApplication.model;

import javax.ws.rs.QueryParam;

public class ParameterBean {

	private @QueryParam("country") String country;

	public ParameterBean() {

	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
