package com.marsrover.controller.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.marsrover.controller.utils.Coordinates;


@Path("/")
public class APIResource {

	//this should be done through dependency injection
	private Coordinates coordinates;
	
	private List<Boolean> mCommands;

	
	@POST
	@Path("move")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response receiveCommands(String commands) {

		if (commands == null && commands.isEmpty()) {
		
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity("Request command cannot be empty or null").build());
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
			// Implementation
			return false;
		case 'B':
			// Implementation
			return false;
		case 'L':
			// Implementation
			return false;
		case 'R':
			// Implementation
			return false;
		default:
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity("Unknown request").build());
			
		}
	}

}
