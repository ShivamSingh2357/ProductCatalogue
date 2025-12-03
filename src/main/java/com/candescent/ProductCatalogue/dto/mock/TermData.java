package com.candescent.ProductCatalogue.dto.mock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Term data from the mock API response.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TermData {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Code__c")
    private String code;

    @JsonProperty("Label__c")
    private String label;

    @JsonProperty("SortOrder__c")
    private Integer sortOrder;

    @JsonProperty("MinTerm__c")
    private Integer minTerm;

    @JsonProperty("MaxTerm__c")
    private Integer maxTerm;

    @JsonProperty("MinAmount__c")
    private BigDecimal minAmount;

    @JsonProperty("MaxAmount__c")
    private BigDecimal maxAmount;

    @JsonProperty("Rate__c")
    private BigDecimal rate;

    @JsonProperty("APY__c")
    private BigDecimal apy;

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

