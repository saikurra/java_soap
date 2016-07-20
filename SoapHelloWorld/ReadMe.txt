Step 1: Run HelloWorldServicePublisher
Step 2: Verify the URL for wsdl
Step 3: Run HelloWorldClient

When Client is run, request and responses will be similar to this

1. Request a WSDL file
First, client send a wsdl request to service endpoint, see HTTP traffic below :

Client send request :

Bash
GET /ws/hello?wsdl HTTP/1.1
User-Agent: Java/1.6.0_13
Host: localhost:9999
Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
Connection: keep-alive

Server send response :

Markup
HTTP/1.1 200 OK
Transfer-encoding: chunked
Content-type: text/xml;charset=utf-8

<?xml version="1.0" encoding="UTF-8"?>

<definitions 
	xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" 
	xmlns:tns="http://ws.mkyong.com/" 
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
	xmlns="http://schemas.xmlsoap.org/wsdl/" 
	targetNamespace="http://ws.mkyong.com/" 
	name="HelloWorldImplService">

	<types></types>

<message name="getHelloWorldAsString">
	<part name="arg0" type="xsd:string"></part>
</message>
<message name="getHelloWorldAsStringResponse">
	<part name="return" type="xsd:string"></part>
</message>

<portType name="HelloWorld">
	<operation name="getHelloWorldAsString" parameterOrder="arg0">
		<input message="tns:getHelloWorldAsString"></input>
		<output message="tns:getHelloWorldAsStringResponse"></output>
	</operation>
</portType>

<binding name="HelloWorldImplPortBinding" type="tns:HelloWorld">

	<soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="rpc"></soap:binding>
	<operation name="getHelloWorldAsString">
		<soap:operation soapAction=""></soap:operation>
		<input>
			<soap:body use="literal" namespace="http://ws.mkyong.com/"></soap:body>
		</input>
		<output>
			<soap:body use="literal" namespace="http://ws.mkyong.com/"></soap:body>
		</output>
	</operation>

</binding>

<service name="HelloWorldImplService">
<port name="HelloWorldImplPort" binding="tns:HelloWorldImplPortBinding">
<soap:address location="http://localhost:9999/ws/hello"></soap:address>
</port>
</service>
</definitions>



2. hello.getHelloWorldAsString()
A second call, client put method invoke request in SOAP envelope and send it to service endpoint. At the service endpoint, call the requested method and put the result in a SOAP envelope and send it back to client.

Client send request :

Markup
POST /ws/hello HTTP/1.1
SOAPAction: ""
Accept: text/xml, multipart/related, text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
Content-Type: text/xml; charset=utf-8
User-Agent: Java/1.6.0_13
Host: localhost:9999
Connection: keep-alive
Content-Length: 224

<?xml version="1.0" ?>
	<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
		<S:Body>
			<ns2:getHelloWorldAsString xmlns:ns2="http://ws.mkyong.com/">
				<arg0>mkyong</arg0>
			</ns2:getHelloWorldAsString>
		</S:Body>
	</S:Envelope>
	
	
Server send response :

Markup
HTTP/1.1 200 OK
Transfer-encoding: chunked
Content-type: text/xml; charset=utf-8

<?xml version="1.0" ?>
	<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
		<S:Body>
			<ns2:getHelloWorldAsStringResponse xmlns:ns2="http://ws.mkyong.com/">
				<return>Hello World JAX-WS mkyong</return>
			</ns2:getHelloWorldAsStringResponse>
		</S:Body>
	</S:Envelope>