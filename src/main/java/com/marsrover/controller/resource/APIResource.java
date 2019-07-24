package com.marsrover.controller.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/")
public class APIResource {

	

		@POST
		@Path("move")
		@Consumes(MediaType.TEXT_PLAIN)
		@Produces(MediaType.APPLICATION_JSON)
		public Response receiveCommands(String commands) {

			if (commands == null && commands.isEmpty()) {
				return null;
			}
			return Response.ok().entity("Response").build();
		}

		
}
