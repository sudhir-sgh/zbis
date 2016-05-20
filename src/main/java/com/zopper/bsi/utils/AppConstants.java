package com.zopper.bsi.utils;

import java.time.Clock;

public class AppConstants {
	
	public static final String HOST_URL = "http://45.56.118.248";
	
	public static Long getUTCInMillis() {
		return Clock.systemUTC().millis();
	}

}
