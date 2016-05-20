package com.zopper.bsi.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.zopper.bsi.response.OrderData;
import com.zopper.bsi.service.core.ServiceOnboardSummaryService;
import com.zopper.bsi.utils.AppConstants;

@Controller
@RequestMapping("/api/service")
public class ServiceRequestController {
	
	Logger logger  = Logger.getLogger(ServiceRequestController.class);
	
	private @Autowired ServiceOnboardSummaryService serviceOnboardSummaryService;
	
	@RequestMapping(value = "/onboard", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody ResponseEntity<String> onboardOrderData(@RequestParam(value="orderId") Long orderId) {
		logger.debug("Order being processed: " + orderId);
		try {
			if(serviceOnboardSummaryService.getByOrderId(orderId) != null) {
				return new ResponseEntity<String>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			logger.error("An error occurred while checking orderId presence in DB, order ID: " + orderId, e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		String orderFetchURL = AppConstants.HOST_URL + "/sales/orders/" + orderId + "/";
		
		RestTemplate restTemplate = new RestTemplate();
		OrderData orderData = restTemplate.getForObject(orderFetchURL, OrderData.class);
		if(orderData == null) {
			logger.error("No order data found with this order ID: " + orderId);
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			serviceOnboardSummaryService.save(orderData);
		} catch (Exception e) {
			logger.error("An error occurred while onboarding data this order ID: " + orderId, e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/onboard/exists", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody ResponseEntity<String> isAlreadyOnboard(@RequestParam(value="orderId") Long orderId) {
		try {
			if(serviceOnboardSummaryService.getByOrderId(orderId) != null) {
				return new ResponseEntity<String>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			logger.error("An error occurred while checking orderId presence in DB, order ID: " + orderId, e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
