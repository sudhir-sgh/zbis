package com.zopper.bsi.controllers;

import javax.validation.Valid;

import com.zopper.bsi.request.Criteria;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zopper.bsi.handler.BrandHandler;
import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.request.BrandServiceRequest;
import com.zopper.bsi.response.BrandServiceResponse;
import com.zopper.bsi.service.core.ServiceOnboardSummaryService;
import com.zopper.bsi.service.core.ServiceRequestService;

@Controller
@RequestMapping("/api/service-requests")
public class ServiceRequestController {
	
	Logger logger  = Logger.getLogger(ServiceRequestController.class);
	
	private @Autowired ServiceRequestService serviceRequestService;
 	@Autowired
 	private ServiceOnboardSummaryService serviceOnboardSummaryService;
	@Autowired
	private BrandHandler brandHandler;

	@RequestMapping(value = "/onboard-data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<java.lang.Object> onboardOrderData(@RequestParam(value="orderId") Long orderId) throws Exception {
		try {
			Long id = brandHandler.onboardItemForBrand(orderId);
			return new ResponseEntity<java.lang.Object>(id, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("An error occurred while checking orderId presence in DB, order ID: " + orderId, e);
			return new ResponseEntity<java.lang.Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@RequestMapping(value = "/onboard/exists", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
//	public @ResponseBody ResponseEntity<String> isAlreadyOnboard(@RequestParam(value="orderId") Long orderId) {
//		try {
//			if(serviceOnboardSummaryService.getByOrderId(orderId) != null) {
//				return new ResponseEntity<String>(HttpStatus.CONFLICT);
//			}
//		} catch (Exception e) {
//			logger.error("An error occurred while checking orderId presence in DB, order ID: " + orderId, e);
//			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<String>(HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BrandServiceResponse> requestService(
			@RequestBody @Valid BrandServiceRequest brandServiceRequest, BindingResult bindingResult) 
	{
		logger.debug("Raise request with data: " + brandServiceRequest);
		BrandServiceResponse brandServiceResponse = null;
		try {
			brandServiceResponse = brandHandler.raiseRequestForBrand(brandServiceRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Raise request response: " + brandServiceResponse);
		return new ResponseEntity<BrandServiceResponse>(brandServiceResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Iterable<ServiceRequest>> listAllServiceRequests(@RequestBody Criteria criteria) {
		try {
			return new ResponseEntity<Iterable<ServiceRequest>>(serviceRequestService.getAllServiceRequests(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Iterable<ServiceRequest>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{refnum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ServiceRequest> getByReferenceNumber(@PathVariable(value="refnum") String referenceNumber) {
		try {
			return new ResponseEntity<ServiceRequest>(serviceRequestService.getByReferenceNumber(referenceNumber), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ServiceRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
