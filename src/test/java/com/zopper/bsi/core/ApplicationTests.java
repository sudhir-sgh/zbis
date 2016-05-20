package com.zopper.bsi.core;

import com.sun.org.apache.xpath.internal.operations.String;
import com.zopper.bsi.Application;
import com.zopper.bsi.dao.BrandDao;
import com.zopper.bsi.models.Brand;
import com.zopper.bsi.service.core.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudhir on 20/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ApplicationTests {

	@Autowired
	BrandDao brandDao;

	@Test
	public void getBrands() {
		//Brand brand = new Brand("test", "Test display");
		//System.out.print(brandDao.save(brand));
	}

}
