package com.sai.ws;

import javax.jws.WebService;

@WebService(endpointInterface= "com.sai.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World Jax-WS: "+name;
	}

}
