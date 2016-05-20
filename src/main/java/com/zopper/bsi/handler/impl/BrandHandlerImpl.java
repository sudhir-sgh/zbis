package com.zopper.bsi.handler.impl;

import com.zopper.bsi.handler.BrandHandler;
import org.springframework.stereotype.Component;

/**
 * Created by sudhir on 20/5/16.
 */
@Component
public class BrandHandlerImpl implements BrandHandler {

    @Override
    public void onboardItemForBrand(String orderId) {

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
