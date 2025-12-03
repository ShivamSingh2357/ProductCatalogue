package com.candescent.ProductCatalogue.dto.mock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Product data from the mock API response.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductData {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Code__c")
    private String code;

    @JsonProperty("Type__c")
    private String type;

    @JsonProperty("Category__c")
    private String category;

    @JsonProperty("Description__c")
    private String description;

    @JsonProperty("FullDescription__c")
    private String fullDescription;

    @JsonProperty("Active__c")
    private Boolean active;

    @JsonProperty("Disabled__c")
    private Boolean disabled;

    @JsonProperty("Popular__c")
    private Boolean popular;

    @JsonProperty("Internal__c")
    private Boolean internal;

    @JsonProperty("External__c")
    private Boolean external;

    @JsonProperty("Secured__c")
    private Boolean secured;

    @JsonProperty("Revolving__c")
    private Boolean revolving;

    @JsonProperty("IsLending__c")
    private Boolean isLending;

    @JsonProperty("IsBusiness__c")
    private Boolean isBusiness;

    @JsonProperty("IsEmployee__c")
    private Boolean isEmployee;

    @JsonProperty("IsDeleted")
    private Boolean isDeleted;

    @JsonProperty("IsDeleted__c")
    private Boolean isDeletedCustom;

    @JsonProperty("SortOrder__c")
    private Integer sortOrder;

    @JsonProperty("MaximumQuantity__c")
    private Integer maximumQuantity;

    @JsonProperty("MaxLadderSize__c")
    private Integer maxLadderSize;

    @JsonProperty("CeilingRate__c")
    private BigDecimal ceilingRate;

    @JsonProperty("ImageUrl__c")
    private String imageUrl;

    @JsonProperty("InfoUrl__c")
    private String infoUrl;

    @JsonProperty("IconClass__c")
    private String iconClass;

    @JsonProperty("CardTextColorType__c")
    private String cardTextColorType;

    @JsonProperty("TermUnit__c")
    private String termUnit;

    @JsonProperty("RecordTypeId")
    private String recordTypeId;

    @JsonProperty("ExternalId__c")
    private String externalId;

    @JsonProperty("OwnerId")
    private String ownerId;

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

    @JsonProperty("AllowBeneficiary__c")
    private Boolean allowBeneficiary;

    @JsonProperty("AllowJointApplicant__c")
    private Boolean allowJointApplicant;

    @JsonProperty("IsLadderSupported__c")
    private Boolean isLadderSupported;

    @JsonProperty("IsCloningSupported__c")
    private Boolean isCloningSupported;

    @JsonProperty("EnableSettlementInstruction__c")
    private Boolean enableSettlementInstruction;

    @JsonProperty("EnableAutomaticRepayment__c")
    private Boolean enableAutomaticRepayment;

    @JsonProperty("IsInterestOnlyRepaymentSupported__c")
    private Boolean isInterestOnlyRepaymentSupported;

    @JsonProperty("IsBalloonRepaymentSupported__c")
    private Boolean isBalloonRepaymentSupported;

    @JsonProperty("CaptureCardProgramHierarchy__c")
    private Boolean captureCardProgramHierarchy;

    @JsonProperty("AllowedInvestmentAccountType__c")
    private String allowedInvestmentAccountType;

    @JsonProperty("AllowedInvestmentPlanType__c")
    private String allowedInvestmentPlanType;

    @JsonProperty("AllowedInvestmentContributionType__c")
    private String allowedInvestmentContributionType;

    @JsonProperty("Features__r")
    private List<FeatureData> features;

    @JsonProperty("Terms__r")
    private List<TermData> terms;
}

