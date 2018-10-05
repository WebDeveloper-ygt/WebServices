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
	
	Logger log =Logger.getLogger(NewsClient.class);
	
	public NewsClient() {
		client = ClientBuilder.newClient();
		URI = "https://newsapi.org/v2/";
		apiKey= "6aafa4add3164809a43e57c53a09f8bf";
	}

	public ResponseBean getTHByCountry(String country) {
		// TODO Auto-generated method stub
		WebTarget target = client.target(URI);
		Response result =target.path("/top-headlines").queryParam("country", country).queryParam("apiKey",apiKey).request(MediaType.APPLICATION_JSON).get(Response.class);
		log.info(result);
		return result.readEntity(ResponseBean.class);
	}

}
