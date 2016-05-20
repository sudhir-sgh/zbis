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

    @Column(name = "form_display_label")
    String displyLabel;

    @Column(name = "form_param_key")
    String paramKey;

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
    @Column(name = "brand_category")
    String brandCategory;



    public String getDisplyLabel() {
        return displyLabel;
    }

    public void setDisplyLabel(String displyLabel) {
        this.displyLabel = displyLabel;
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

    public String getBrandCategory() {
        return brandCategory;
    }

    public void setBrandCategory(String brandCategory) {
        this.brandCategory = brandCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("displyLabel", displyLabel)
                .append("paramKey", paramKey)
                .append("datatype", datatype)
                .append("required", required)
                .append("options", options)
                .append("defaultValue", defaultValue)
                .append("brandId", brandId)
                .append("brandCategory", brandCategory)
                .toString();
    }
}
