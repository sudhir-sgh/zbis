package com.zopper.bsi.dao;

import com.zopper.bsi.models.CCWorkLog;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sudhir on 24/5/16.
 */
public interface CCWorkLogDao extends CrudRepository<CCWorkLog, Long> {

    Iterable<CCWorkLog> findByServiceRequestId(Long serviceRequestId);

}
