package com.lisnepal.rs;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response sayHello() {
		String str = "<H1>Hi!!! welcome to @ApplicationPath Annotation Example in Restful webservices  </H1> ";
		return Response.status(200).entity(str).build();
	}

	@GET
	@Path("/ping")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServerTime() {
			
//		System.out.println("RESTful Service 'MessageService' is running ==> ping");
//		String pingMsg = "received ping on " + new java.util.Date().toString();
//		
//		JsonReader reader = Json.createReader(new StringReader(pingMsg));
//		JsonObject object = reader.readObject();
//		return Response.status(200).entity(object.toString()).build();

		String str = "{'friends': ['Michael', 'Tom', 'Daniel', 'John', 'Nick']}";
		return Response.status(200).entity(str).build();

	}

}
