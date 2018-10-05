package com.learn.NewsApplication.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.learn.NewsApplication.exception.BadRequestExcept;
import com.learn.NewsApplication.exception.DataNotFoundException;
import com.learn.NewsApplication.model.ParameterBean;
import com.learn.NewsApplication.model.ResponseBean;
import com.learn.NewsApplication.service.TopHeadlinesService;

@Path("/TopHeadlines")
public class TopHeadlinesResource {

	Logger log = Logger.getLogger(TopHeadlinesResource.class);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getTHByCountry(@BeanParam ParameterBean paramBean) {

		log.info("Country - " + paramBean.getCountry());

		if ((paramBean.getCountry().equals("")) || (paramBean.getCountry().length() != 2)) {
			log.error(new BadRequestExcept(
					"Your Request is not valid- country name must be two letters ex:IN for india"));
			throw new BadRequestExcept("Your Request is not valid- country name must be two letters ex:IN for india");
		} else {
			TopHeadlinesService service = new TopHeadlinesService();
			ResponseBean result = service.getTHByCountry(paramBean.getCountry());
			int numArticle = result.getArticles().size();
			log.info("num of articles - " + numArticle);
			if (numArticle > 0) {
				return Response.status(Status.OK).entity(result).build();
			} else {
				log.error(
						new DataNotFoundException("We dont find data for your country - " + paramBean.getCountry()));
				throw new DataNotFoundException("We dont find data for your country - " + paramBean.getCountry());
			}

		}

	}
}
