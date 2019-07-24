package com.marsrover.controller.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.marsrover.controller.exception.ServiceException;
import com.marsrover.controller.models.ErrorMessage;
import com.marsrover.controller.utils.Coordinates;



/**
 * @author macosx
 * Web API resource class
 *
 */

@Path("/")
public class APIResource {

	
	@Inject
	private Coordinates coordinates;
	
	private List<Boolean> mCommands;

	
	/**
	 * 
	 * @param commands the rover command sent by the rover
	 * @return
	 */
	@POST
	@Path("move")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response receiveCommands(String commands) {

		if (commands == null && commands.isEmpty()) {
			
			ErrorMessage message = new ErrorMessage();
			message.setCode(Status.BAD_REQUEST.getStatusCode());
			message.setErrorMessage("Command request cannot be empty or null");
			throw new ServiceException(new Gson().toJson(message), Status.BAD_REQUEST.getStatusCode());
		}

		mCommands = new ArrayList<>();

		for (char command : commands.toCharArray()) {
			mCommands.add(receiveSingleCommand(command));
		}
		
		return Response.ok().entity(mCommands).build();
	}
	
	public boolean receiveSingleCommand(char command) {
		switch (Character.toUpperCase(command)) {
		case 'F':
			
			return coordinates.moveForward();
			
		case 'B':
			return coordinates.moveBackward();
		
		case 'L':
			// Implementation
			return false;
		case 'R':
			// Implementation
			return false;
		default:
			
			ErrorMessage message = new ErrorMessage();
			message.setCode(Status.BAD_REQUEST.getStatusCode());
			message.setErrorMessage("Invalid command");
			throw new ServiceException(new Gson().toJson(message), Status.BAD_REQUEST.getStatusCode());
			
		}
	}

}
