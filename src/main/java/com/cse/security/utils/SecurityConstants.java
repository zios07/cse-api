package com.cse.security.utils;

public class SecurityConstants {

	private SecurityConstants() {

	}

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 4 * 60 * 60 * 1000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_ENDPOINT = "/users/sign-up";
	public static final String LOGIN_ENDPOINT = "/api/authentication/authenticate";
	public static final String REGISTRATION_ENDPOINT = "/api/users/register";
	public static final String PROPERTY_ENDPOINT = "/api/properties";
	public static final String PROPERTY_SEARCH_ENDPOINT = "/api/properties/*";
	public static final String DEVELOPMENT_ENDPOINT = "/api/properties/developments/all";
	public static final String TYPE_ENDPOINT = "/api/types";
	public static final String LOCATION_ENDPOINT = "/api/locations";
	public static final String SUBAREA_ENDPOINT = "/api/subareas";

}
