package com.sai.ws;

import javax.jws.WebService;

@WebService(endpointInterface= "com.sai.ws.HelloWorld")
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World Jax-WS: "+name;
	}

}
