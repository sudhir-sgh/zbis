package com.zopper.bsi.utils;

import java.time.Clock;

public class AppConstants {

	public static final class API{

		public static enum STATUS{

			SUCCESS(1), ERROR(0);
			public int value;

			private STATUS(int key){
				this.value = key;
			}
		}
	}

	public static final String HOST_URL = "http://45.56.118.248";
	
	public static Long getUTCInMillis() {
		return Clock.systemUTC().millis();
	}

}
