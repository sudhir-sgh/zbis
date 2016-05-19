package com.zopper.bsi.service.brand;

public interface BrandHandler {
	
	public void onboardItemForBrand(String orderId);
	
	public String raiseDemoRequestForBrand(String orderId, String itemId);
	
	public String raiseInstallationRequestForBrand(String orderId, String itemId);

}
