package com.zopper.bsi.dao;

import com.zopper.bsi.models.CCWorkLog;
import com.zopper.bsi.models.GeneralAuditLog;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sudhir on 24/5/16.
 */
public interface GeneralAuditLogDao extends CrudRepository<GeneralAuditLog, Long> {
    
}
