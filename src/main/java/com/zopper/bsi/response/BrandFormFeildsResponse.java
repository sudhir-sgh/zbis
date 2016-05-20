package com.zopper.bsi.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zopper.bsi.enums.FormDataType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by sudhir on 19/5/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandFormFeildsResponse {

    String displayLabel;
    String paramKey;
    FormDataType datatype;
    Boolean required;
    Long brandId;
    String brandCategory;
    String[] options;
    String defaultValue;

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
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

//    public Object getOptions() {
//        if (this.options != null && options instanceof String)
//            return ((String) options).split(",");
//        return options;
//    }
//
//    public void setOptions(Object options) {
//        this.options = options;
//    }
    public String[] getOptions() {
        return options;
    }

    public void setOptions(String options) {
        if (StringUtils.isNotEmpty(options))
            this.options = StringUtils.split(options,",");
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getBrandCategory() {
        return brandCategory;
    }

    public void setBrandCategory(String brandCategory) {
        this.brandCategory = brandCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("displayLabel", displayLabel)
                .append("paramKey", paramKey)
                .append("datatype", datatype)
                .append("required", required)
                .append("brandId", brandId)
                .append("brandCategory", brandCategory)
                .append("options", options)
                .append("defaultValue", defaultValue)
                .toString();
    }
}
