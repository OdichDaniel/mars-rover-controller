package com.marsrover.controller.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;



public class ServiceException extends WebApplicationException{

	public ServiceException(String errorMsg, int statusCode) {
		
		super(Response.status(Status.BAD_REQUEST).entity(errorMsg).type(MediaType.APPLICATION_JSON).build());
	}
}
