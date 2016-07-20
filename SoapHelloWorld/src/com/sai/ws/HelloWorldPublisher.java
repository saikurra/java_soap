package com.sai.ws;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldServiceImpl());
		System.out.println("WSDL published successfully using Jax-WS");
	}

}
