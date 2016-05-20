package com.zopper.bsi.models;

import javax.persistence.*;

/**
 * Created by sudhir on 19/5/16.
 */
@Entity
@Table(name = "brand_ifb")
public class BrandIfb  extends BaseModel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2593967564974966299L;
	
	@Column(name = "ALTERNATE_PHONE_NUMBER")
    private String alternatePhoneNumber;

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

}
