package com.zopper.bsi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zopper.bsi.enums.FormDataType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sudhir on 19/5/16.
 */
@Entity
@Table(name = "brand_form_feilds")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandFormFeilds extends BaseModel{

    @Column(name = "form_label")
    String label;

    @Column(name = "form_key")
    String key;

    @Column(name = "data_type")
    FormDataType datatype;

    @Column(name = "is_required")
    Boolean required;

    @Column(name = "allowed_options")
    String options;

    @Column(name = "default_value")
    String defaultValue;

    @Column(name = "brand_id")
    Long brandId;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public FormDataType getDatatype() {
        return datatype;
    }

    public void setDatatype(FormDataType datatype) {
        this.datatype = datatype;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("label", label)
                .append("key", key)
                .append("datatype", datatype)
                .append("required", required)
                .append("options", options)
                .append("defaultValue", defaultValue)
                .append("brandId", brandId)
                .toString();
    }
}
