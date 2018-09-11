package com.cse.security.utils;

import static com.cse.security.utils.SecurityConstants.*;

public class SecurityUtils {
	
	private SecurityUtils() {}
	
	public static String[] getPublicEndpoints() {
		return new String[] {
			PROPERTY_ENDPOINT,
			DEVELOPMENT_ENDPOINT,
			TYPE_ENDPOINT,
			LOCATION_ENDPOINT,
			SUBAREA_ENDPOINT
		};
	}

}
