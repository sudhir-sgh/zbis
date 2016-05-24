package com.zopper.bsi.service.core;

import com.zopper.bsi.models.CCWorkLog;
import com.zopper.bsi.models.ServiceOnboardSummary;
import com.zopper.bsi.request.CCWorkLogRequest;
import com.zopper.bsi.response.OrderData;
/**
 * Created by sudhir on 24/5/16.
 */
public interface CCWorkLogService {
	
	Long save(CCWorkLogRequest ccWorkLogRequest) throws Exception;
	
	Iterable<CCWorkLog> getByServiceRequestId(Long serviceRequestId) throws Exception;

}
