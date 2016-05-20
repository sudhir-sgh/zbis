package com.zopper.bsi.handler;

public interface BrandHandler {
	
	Long onboardItemForBrand(Long orderId) throws Exception;

	String raiseDemoRequestForBrand(String orderId, String itemId);
	
	String raiseInstallationRequestForBrand(String orderId, String itemId);

}
