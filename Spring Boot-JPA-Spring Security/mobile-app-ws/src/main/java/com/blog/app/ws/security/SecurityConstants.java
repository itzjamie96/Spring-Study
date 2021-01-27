package com.blog.app.ws.security;

public class SecurityConstants {
	
	// used to generate token, valid for 10 days (unit = milliseconds)
	public static final long EXPIRATION_TIME = 864000000;
	
	// prefix will be passed on with the header string in the http request
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	
	// public url
	public static final String SIGN_UP_URL = "/users";
	
	// used for encryption of value of the access tokens
	public static final String TOKEN_SECRET = "jf9i4jgu83nfl0 ";
	
}
