package com.learn.NewsApplication.service;

import org.apache.log4j.Logger;

import com.learn.NewsApplication.client.NewsClient;
import com.learn.NewsApplication.model.ResponseBean;

public class TopHeadlinesService {

	private NewsClient client;
	private ResponseBean result;
	public TopHeadlinesService() {
		client = new NewsClient();
	}

	Logger log = Logger.getLogger(TopHeadlinesService.class);

	public ResponseBean getTHByCountry(String country) {

		result = client.getTHByCountry(country);
		return result;
	}

	public ResponseBean getTHByQuery(String query) {
		
		 result = client.getTHByQuery(query);
		return result;
	}

}
