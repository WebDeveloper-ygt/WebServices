package com.learn.NewsApplication.resource;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.BeanParam;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.learn.NewsApplication.exception.BadRequestExcept;
import com.learn.NewsApplication.exception.DataNotFoundException;
import com.learn.NewsApplication.exception.ExceptionBean;
import com.learn.NewsApplication.model.ParameterBean;
import com.learn.NewsApplication.model.ResponseBean;
import com.learn.NewsApplication.service.TopHeadlinesService;

@Path("/TopHeadlines")
public class TopHeadlinesResource {
	private TopHeadlinesService service = new TopHeadlinesService();
	private ResponseBean result;
	private int numArticle;

	Logger log = Logger.getLogger(TopHeadlinesResource.class);

	@GET
	@Path("/country")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getTHByCountry(@BeanParam ParameterBean paramBean, @Context UriInfo uriInfo) {
		
		log.info("Country - " + paramBean.getCountry());

		if ((paramBean.getCountry().equals("")) || (paramBean.getCountry().length() != 2)) {
			log.error(new BadRequestExcept(
					"Your Request is not valid- country name must be two letters ex:IN for india"));
			throw new BadRequestExcept("Your Request is not valid- country name must be two letters ex:IN for india");
		} else {
			result = service.getTHByCountry(paramBean.getCountry());
			//result.addLink(uriInfo.getAbsolutePathBuilder().path(TopHeadlinesResource.class).toString(), "self");
			numArticle = result.getArticles().size();
			log.info("num of articles - " + numArticle);
			if (numArticle > 0) {
				
				return Response.status(Status.OK).entity(result).build();
			} else {
				log.error(new DataNotFoundException("We dont find data for your country - " + paramBean.getCountry()));
				throw new DataNotFoundException("We dont find data for your country - " + paramBean.getCountry());
			}

		}

	}

	@GET
	@Path("query")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getTHByQuery(@BeanParam ParameterBean paramBean) {
		log.info("Query - " + paramBean.getQuery());
		if ((paramBean.getQuery().equals(""))) {
			ExceptionBean exBean = new ExceptionBean("BAD_REQUEST", "Query Should not be an empty", 400);
			log.error("Query Should not be an empty");
			throw new BadRequestException(Response.status(Status.BAD_REQUEST).entity(exBean).build());
		} else {
			result =service.getTHByQuery(paramBean.getQuery());
			numArticle = result.getArticles().size();
			if(numArticle > 0) {
				return Response.status(Status.OK).entity(result).build();
			}else {
				ExceptionBean exBean = new ExceptionBean("NOT_FOUND", "Couldnot find results for your query", 404);
				log.error("Couldnot find results for your query - "+paramBean.getQuery());
				throw new ClientErrorException(Response.status(Status.NOT_FOUND).entity(exBean).build());
			}
		}
	}
	
	
}
