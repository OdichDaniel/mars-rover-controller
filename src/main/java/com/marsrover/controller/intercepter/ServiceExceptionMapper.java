package com.marsrover.controller.intercepter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.marsrover.controller.models.*;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable throwable) {
		ErrorMessage response = new ErrorMessage();
		int status = getStatusType(throwable);
		response.setCode(status);
		response.setErrorMessage(throwable.getMessage());
		
		return Response.status(status).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	private int getStatusType(Throwable ex) {
        if (ex instanceof WebApplicationException) {
        	
            return((WebApplicationException)ex).getResponse().getStatus();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        }
    }
}
