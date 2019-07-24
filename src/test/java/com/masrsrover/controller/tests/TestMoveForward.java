package com.masrsrover.controller.tests;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class TestMoveForward extends JerseyTest {

	@Test
	public void shouldReceiveErrorWithInvalidPayload() {

		//entity is null
		Response output = target("/command/move").request().post(Entity.entity(null, MediaType.TEXT_PLAIN));
		System.out.println(output.getStatus());
		assertEquals(404, output.getStatus());
	}
	
	@Test
	public void shouldMoveForward() {

		//command F
		Response output = target("/command/move").request().post(Entity.entity("F", MediaType.TEXT_PLAIN));
		System.out.println(output.getStatus());
		assertEquals(200, output.getStatus());
	}
	
	@Test
	public void shouldMoveForwardAndBack() {

		//command FB
		Response output = target("/command/move").request().post(Entity.entity("FB", MediaType.TEXT_PLAIN));
		System.out.println(output.getStatus());
		assertEquals(200, output.getStatus());
	}

}
