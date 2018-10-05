package com.learn.NewsApplication.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestExcept> {

	@Override
	public Response toResponse(BadRequestExcept exception) {
		// TODO Auto-generated method stub
		ExceptionBean exBean= new ExceptionBean("BAD_REQUEST", exception.getMessage(), 400);
		return Response.status(Status.BAD_REQUEST).entity(exBean).build();
	}

}
