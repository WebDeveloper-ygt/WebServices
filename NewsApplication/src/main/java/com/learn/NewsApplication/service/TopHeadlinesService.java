package com.learn.NewsApplication.service;

import org.apache.log4j.Logger;

import com.learn.NewsApplication.client.NewsClient;
import com.learn.NewsApplication.model.ResponseBean;

public class TopHeadlinesService {

	Logger log= Logger.getLogger(TopHeadlinesService.class);
	public ResponseBean getTHByCountry(String country) {
		// TODO Auto-generated method stub
		
		NewsClient client = new NewsClient();
		ResponseBean result =client.getTHByCountry(country);
		return result;
	}

}
