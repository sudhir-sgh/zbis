package com.zopper.bsi.service.core.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.zopper.bsi.dao.CCWorkLogDao;
import com.zopper.bsi.models.CCWorkLog;
import com.zopper.bsi.request.CCWorkLogRequest;
import com.zopper.bsi.service.core.CCWorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sudhir on 24/5/16.
 */
@Component
public class CCWorkLogServiceImpl implements CCWorkLogService {

    @Autowired
    CCWorkLogDao ccWorkLogDao;

    @Override
    public Long save(CCWorkLogRequest ccWorkLogRequest) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CCWorkLog ccWorkLog = objectMapper.readValue(new Gson().toJson(ccWorkLogRequest), CCWorkLog.class);
        ccWorkLogDao.save(ccWorkLog);
        return ccWorkLog.getId();
    }

    @Override
    public Iterable<CCWorkLog> getByServiceRequestId(Long serviceRequestId) throws Exception {
        return ccWorkLogDao.findByServiceRequestId(serviceRequestId);
    }
}
