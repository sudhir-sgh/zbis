package com.zopper.bsi.models;

import javax.persistence.*;

/**
 * Created by sudhir on 19/5/16.
 */
@Entity
@Table(name = "brand_brands")
public class Brand  extends BaseModel{

    public Brand() {
    }

    public Brand(String name, String brandKey) {
        this.name = name;
        this.brandKey = brandKey;
    }

    @Column(name = "name")
    String name;

    @Column(name = "brand_key")
    String brandKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandKey() {
        return brandKey;
    }

    public void setBrandKey(String brandKey) {
        this.brandKey = brandKey;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("name", name)
                .append("brandKey", brandKey)
                .toString();
    }
}
