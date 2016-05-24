package com.zopper.bsi.controllers;

import com.zopper.bsi.request.CCWorkLogRequest;
import com.zopper.bsi.response.APIResponse;
import com.zopper.bsi.service.core.CCWorkLogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/cc-work-log")
public class CCWorkLogController {
	
	Logger logger  = Logger.getLogger(CCWorkLogController.class);

	@Autowired
	CCWorkLogService ccWorkLogService;

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody APIResponse requestService(
			@RequestBody @Valid CCWorkLogRequest ccWorkLogRequest) throws Exception {

		return new APIResponse(ccWorkLogService.save(ccWorkLogRequest));
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody APIResponse listAllServiceRequests(@RequestParam Long serviceRequestId) throws Exception {

		return new APIResponse(ccWorkLogService.getByServiceRequestId(serviceRequestId));
	}


}
