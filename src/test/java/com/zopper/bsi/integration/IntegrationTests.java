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
public class IntegrationTests {

	RestTemplate template = new TestRestTemplate();

	@Test
	public void contextLoads() {

	}

	@Test
	public void getBrands() {
		Map<java.lang.String, java.lang.String> paramMap = new HashMap<>();
		paramMap.put("key","1");
		System.out.print(template.getForObject("http://localhost:8999/brand", Brand.class, paramMap));
	}



}
