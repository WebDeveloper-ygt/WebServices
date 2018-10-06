package com.learn.NewsApplication.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.learn.NewsApplication.model.ResponseBean;

public class NewsClient {

	private Client client;
	private String URI;
	private String apiKey;
	private WebTarget target;
	Logger log =Logger.getLogger(NewsClient.class);
	
	public NewsClient() {
		client = ClientBuilder.newClient();
		URI = "https://newsapi.org/v2/";
		apiKey= "6aafa4add3164809a43e57c53a09f8bf";
		target = client.target(URI);
	}

	public ResponseBean getTHByCountry(String country) {
		// TODO Auto-generated method stub
		Response result =target.path("/top-headlines").queryParam("country", country).queryParam("apiKey",apiKey).request(MediaType.APPLICATION_JSON).get(Response.class);
		log.info(result);
		return result.readEntity(ResponseBean.class);
	}

	public ResponseBean getTHByQuery(String query) {
		// TODO Auto-generated method stub
		Response result =target.path("/top-headlines").queryParam("q", query).queryParam("apiKey",apiKey).request(MediaType.APPLICATION_JSON).get(Response.class);
		log.info(result);
		return result.readEntity(ResponseBean.class);
	}

}
