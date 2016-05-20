package com.zopper.bsi.handler.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.zopper.bsi.controllers.ServiceRequestController;
import com.zopper.bsi.exceptions.APIException;
import com.zopper.bsi.handler.BrandHandler;
import com.zopper.bsi.models.ServiceOnboardSummary;
import com.zopper.bsi.response.OrderData;
import com.zopper.bsi.response.USDSeviceApiResponse;
import com.zopper.bsi.service.core.ServiceOnboardSummaryService;
import com.zopper.bsi.utils.AppConstants;
import com.zopper.bsi.utils.AppUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudhir on 20/5/16.
 */
@Component
public class BrandHandlerImpl implements BrandHandler {

    Logger logger  = Logger.getLogger(BrandHandlerImpl.class);
    RestTemplate restTemplate;

    public BrandHandlerImpl() {
    }

    public BrandHandlerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

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
    public String raiseDemoRequestForBrand(String orderId, String itemId) {
        return null;
    }

    @Override
    public String raiseInstallationRequestForBrand(String orderId, String itemId) {
        return null;
    }
}
