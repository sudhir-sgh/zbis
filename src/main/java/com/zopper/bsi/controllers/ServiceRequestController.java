package com.zopper.bsi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import javax.validation.Valid;

import com.zopper.bsi.request.ServiceUpdateRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.zopper.bsi.request.Criteria;
import com.zopper.bsi.response.APIResponse;
import com.zopper.bsi.response.BrandServiceResponse;
import com.zopper.bsi.response.ErrorReponse;
import com.zopper.bsi.service.core.ServiceOnboardSummaryService;
import com.zopper.bsi.service.core.ServiceRequestService;
import com.zopper.bsi.utils.AppConstants;
import com.zopper.bsi.utils.AppUtils;

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
	public @ResponseBody APIResponse onboardOrderData(@RequestParam(value="orderId") Long orderId) throws Exception {
		try {
			Future<Long> summaryId = brandHandler.onboardItemForBrand(orderId);
			return new APIResponse("Ok", AppConstants.API.STATUS.SUCCESS, "Success");
		} catch (Exception e) {
			logger.error("An error occurred while onboarding order ID: " + orderId, e);
			return new APIResponse(new ErrorReponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody APIResponse requestService(
			@RequestBody @Valid BrandServiceRequest brandServiceRequest, BindingResult bindingResult) 
	{
		String referenceNumber = AppUtils.generateReferenceNumber();
		brandServiceRequest.setReferenceNumber(referenceNumber);
		try {
			Future<BrandServiceResponse> brandServiceResponse = brandHandler.raiseRequestForBrand(brandServiceRequest);
		} catch (Exception e) {
			logger.error("An error occurred while demo/installation service request. " + brandServiceRequest, e);
			return new APIResponse(new ErrorReponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage()));
		}
		Map<String, String> response = new HashMap<>();
		response.put("referenceNumber", referenceNumber);
		return new APIResponse(response, AppConstants.API.STATUS.SUCCESS, "Success");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody APIResponse listAllServiceRequests(@RequestBody Criteria criteria) { 
		List<ServiceRequest> serviceRequests = null;
		try {
			serviceRequests = serviceRequestService.getAllServiceRequests(criteria);
		} catch (Exception e) {
			logger.error("An error occurred while getting listing service requests.", e);
			return new APIResponse(new ErrorReponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage()));
		}
		return new APIResponse(serviceRequests, AppConstants.API.STATUS.SUCCESS, "Success");
	}
	
	@RequestMapping(value = "/{refnum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody APIResponse getByReferenceNumber(@PathVariable(value="refnum") String referenceNumber) {
		ServiceRequest serviceRequest = null;
		try {
			serviceRequest = serviceRequestService.getByReferenceNumber(referenceNumber);
		} catch (Exception e) {
			logger.error("An error occurred while getting ServiceRequest info, referenceNumber= " + referenceNumber, e);
			return new APIResponse(new ErrorReponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage()));
		}
		return new APIResponse(serviceRequest, AppConstants.API.STATUS.SUCCESS, "Success");
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody APIResponse updateServiceRequest(@RequestBody ServiceUpdateRequest serviceUpdateRequest) {
		ServiceRequest serviceRequest = null;
		return new APIResponse(serviceRequest, AppConstants.API.STATUS.SUCCESS, "Success");
	}

}
