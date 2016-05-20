package com.zopper.bsi.integration;

import com.zopper.bsi.Application;
import com.zopper.bsi.models.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudhir on 20/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
@IntegrationTest("server.port:8999")   // 4
public class BrandIntegrationTests {

	RestTemplate template = new TestRestTemplate();

	@Test
	public void getBrands() {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("orderId","1");
		System.out.print(template.getForEntity("http://localhost:8999/api/service/onboard-data?orderId=1", String.class).getBody());
	}


}
