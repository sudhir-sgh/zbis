package com.zopper.bsi.controllers;

import com.zopper.bsi.handler.BrandHandler;
import org.apache.log4j.Logger;
import org.omg.CORBA.Object;
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

 	@Autowired
 	private ServiceOnboardSummaryService serviceOnboardSummaryService;
	@Autowired
	private BrandHandler brandHandler;

	@RequestMapping(value = "/onboard-data", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody ResponseEntity<java.lang.Object> onboardOrderData(@RequestParam(value="orderId") Long orderId) throws Exception {

		try {
			Long id = brandHandler.onboardItemForBrand(orderId);
			return new ResponseEntity<java.lang.Object>(id, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("An error occurred while checking orderId presence in DB, order ID: " + orderId, e);
			return new ResponseEntity<java.lang.Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

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
