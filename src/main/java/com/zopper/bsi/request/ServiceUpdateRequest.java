package com.zopper.bsi.request;

import com.zopper.bsi.enums.OrderBy;
import com.zopper.bsi.enums.RequestSource;
import com.zopper.bsi.enums.RequestStatus;
import com.zopper.bsi.enums.RequestType;

import java.util.List;

/**
 * Created by sudhir on 24/5/16.
 */
public class ServiceUpdateRequest {

	private List<Long> ids;  // can be provide requests at a time
    private RequestStatus requestStatus;
    private RequestSource requestSource;

	private Long customerId;
	private String USDUserName;
	private Long USDUserId;
}
