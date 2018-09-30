package com.cse.security.utils;

import static com.cse.security.utils.SecurityConstants.*;

public class SecurityUtils {
	
	private SecurityUtils() {}
	
	public static String[] publicEndpoints() {
		return new String[] {
			PROPERTY_ENDPOINT,
			DEVELOPMENT_ENDPOINT,
			TYPE_ENDPOINT,
			LOCATION_ENDPOINT,
			SUBAREA_ENDPOINT
		};
	}
	
	public static String[] mainEndpoints() {
		return new String[] {
				PROPERTY_ENDPOINT,
				TYPE_ENDPOINT,
				LOCATION_ENDPOINT,
				SUBAREA_ENDPOINT,
				USER_ENDPOINT
			};
	}
	
	public static String[] protectedEndpoints() {
		return new String[] {
				PROPERTY_ENDPOINT,
				TYPE_ENDPOINT,
				LOCATION_ENDPOINT,
				SUBAREA_ENDPOINT,
				USER_ENDPOINT,
				LOCATION_PHOTO_UPLOAD_ENDPOINT,
				PROPERTY_PHOTO_UPLOAD_ENDPOINT
		};
	}
	
	public static String[] httpGetProtectedEndpoints() {
		return new String[] {
				PROEPRTY_ENDPOINT_WITH_PHOTOS
		};
	}
	
}
