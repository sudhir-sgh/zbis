package com.zopper.bsi.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zopper.bsi.enums.FormDataType;
import com.zopper.bsi.models.BaseModel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by sudhir on 19/5/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandFormFeildsRequest{

    @NotEmpty
    String label;
    @NotEmpty
    String key;

    @NotNull
    FormDataType datatype;
    @NotNull
    Boolean required;

    @NotNull
    Long brandId;

    String options;
    String defaultValue;

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
                .append("brandId", brandId)
                .append("options", options)
                .append("defaultValue", defaultValue)
                .toString();
    }
}
