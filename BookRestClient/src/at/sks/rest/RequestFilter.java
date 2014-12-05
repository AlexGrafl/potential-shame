package at.sks.rest;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.xml.bind.DatatypeConverter;

public class RequestFilter implements ClientRequestFilter {
	private String username;
	private String password;
	
	public RequestFilter(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void filter(ClientRequestContext request) throws IOException {
		String token = username + ":" + password;
		String basicAuthentication = "Basic " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));

		request.getHeaders().add("Authorization", basicAuthentication);
	}
}