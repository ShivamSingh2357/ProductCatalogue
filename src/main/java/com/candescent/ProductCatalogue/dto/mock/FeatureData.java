package com.candescent.ProductCatalogue.dto.mock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Feature data from the mock API response.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureData {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Code__c")
    private String code;

    @JsonProperty("Label__c")
    private String label;

    @JsonProperty("Value__c")
    private String value;

    @JsonProperty("ValueName__c")
    private String valueName;

    @JsonProperty("Description__c")
    private String description;

    @JsonProperty("FieldType__c")
    private String fieldType;

    @JsonProperty("SortOrder__c")
    private Integer sortOrder;

    @JsonProperty("Internal__c")
    private Boolean internal;

    @JsonProperty("Disabled__c")
    private Boolean disabled;

    @JsonProperty("IsComparable__c")
    private Boolean isComparable;

    @JsonProperty("IsDeleted")
    private Boolean isDeleted;

    @JsonProperty("IsDeleted__c")
    private Boolean isDeletedCustom;

    @JsonProperty("Product__c")
    private String productId;

    @JsonProperty("ExternalId__c")
    private String externalId;

    @JsonProperty("CreatedById")
    private String createdById;

    @JsonProperty("LastModifiedById")
    private String lastModifiedById;

    @JsonProperty("CreatedDate")
    private String createdDate;

    @JsonProperty("LastModifiedDate")
    private String lastModifiedDate;

    @JsonProperty("SystemModstamp")
    private String systemModstamp;

    @JsonProperty("StartDate__c")
    private String startDate;

    @JsonProperty("EndDate__c")
    private String endDate;
}

