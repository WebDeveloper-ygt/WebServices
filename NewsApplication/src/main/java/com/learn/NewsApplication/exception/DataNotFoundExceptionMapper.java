package com.learn.NewsApplication.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ExceptionBean exBean = new ExceptionBean("NOT_FOUND", ex.getMessage() , 404);
		return Response.status(Status.NOT_FOUND).entity(exBean).build();
	}

}
