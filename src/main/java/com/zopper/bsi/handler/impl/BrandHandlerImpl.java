package com.zopper.bsi.handler.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zopper.bsi.enums.RequestType;
import com.zopper.bsi.config.exceptions.APIException;
import com.zopper.bsi.handler.BrandHandler;
import com.zopper.bsi.models.ServiceOnboardSummary;
import com.zopper.bsi.request.BrandServiceRequest;
import com.zopper.bsi.response.BrandServiceResponse;
import com.zopper.bsi.response.OrderData;
import com.zopper.bsi.service.brand.BrandRequestService;
import com.zopper.bsi.service.core.ServiceOnboardSummaryService;
import com.zopper.bsi.utils.AppConstants;

/**
 * Created by sudhir on 20/5/16.
 */
@Component
public class BrandHandlerImpl implements BrandHandler {
	private @Autowired ApplicationContext applicationContext;
	private @Autowired Environment environment;
    Logger logger  = Logger.getLogger(BrandHandlerImpl.class);

    @Autowired
    private ServiceOnboardSummaryService serviceOnboardSummaryService;

    @Override
    public Long onboardItemForBrand(Long orderId) throws Exception {
        logger.debug("Order being processed: " + orderId);
        ServiceOnboardSummary serviceOnboardSummary = serviceOnboardSummaryService.getByOrderId(orderId);
        if (serviceOnboardSummary != null){
            logger.error("An error occurred while checking orderId presence in DB, order ID: " + orderId);
            throw new APIException(HttpStatus.ALREADY_REPORTED+"", "Order data have been already processed.");
        }
        String orderFetchURL = AppConstants.HOST_URL + "/sales/orders/" + orderId + "/";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("orderId","1");
        try {
            ResponseEntity<String> responseData = new RestTemplate().getForEntity(orderFetchURL, String.class, paramMap);
            ObjectMapper objectMapper = new ObjectMapper();
            OrderData orderData = objectMapper.readValue(responseData.getBody().toString(), OrderData.class);
            if(orderData == null || StringUtils.isNotEmpty(orderData.getException())) {
                logger.error("No order data found with this order ID: " + orderId);
                throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR+"", orderData.getMessage(), orderData.getException());
            }
            return serviceOnboardSummaryService.save(orderData);

        } catch (Exception e) {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR+"", e.getMessage());
        }
    }

	@Override
	public BrandServiceResponse raiseRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception {
		BrandServiceResponse brandServiceResponse = null;
		if(RequestType.DEMO.equals(brandServiceRequest.getRequestType())) {
			brandServiceResponse = raiseDemoRequestForBrand(brandServiceRequest);
		} else if(RequestType.INSTALLATION.equals(brandServiceRequest.getRequestType())) {
			brandServiceResponse = raiseInstallationRequestForBrand(brandServiceRequest);
		} else if(RequestType.REPAIR.equals(brandServiceRequest.getRequestType())) {
			// TODO - implement later
		} else if(RequestType.REPLACE.equals(brandServiceRequest.getRequestType())) {
			// TODO - implement later
		}
		return brandServiceResponse;
	}

	@Override
	public BrandServiceResponse raiseDemoRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception {
		String beanName = environment.getProperty("brand_" + brandServiceRequest.getBrandId());
		System.out.println("beanName: " + beanName);
		BrandRequestService brandRequestService = (BrandRequestService) applicationContext.getBean(beanName);
		return brandRequestService.raiseDemoRequest(brandServiceRequest);
	}

	@Override
	public BrandServiceResponse raiseInstallationRequestForBrand(BrandServiceRequest brandServiceRequest) throws Exception {
		String beanName = environment.getProperty("brand_" + brandServiceRequest.getBrandId());
		System.out.println("beanName: " + beanName);
		BrandRequestService brandRequestService = (BrandRequestService) applicationContext.getBean(beanName);
		return brandRequestService.raiseInstallationRequest(brandServiceRequest);
	}

}
