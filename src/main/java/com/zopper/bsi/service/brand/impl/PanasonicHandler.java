package com.zopper.bsi.service.brand.impl;

import com.zopper.bsi.service.brand.BrandHandler;
import org.springframework.stereotype.Component;

/**
 * Created by sudhir on 19/5/16.
 */
@Component(value = "panasonicHandler")
public class PanasonicHandler implements BrandHandler {

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
