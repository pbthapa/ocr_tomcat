package com.lisnepal.ocr;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/OCR")
public class Starter extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		resources.add(com.lisnepal.rs.HelloWorld.class);
		return resources;
	}

}
