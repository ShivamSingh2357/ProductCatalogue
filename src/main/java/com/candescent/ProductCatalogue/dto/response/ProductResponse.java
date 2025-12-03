package com.candescent.ProductCatalogue.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Response DTO for Product.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("referenceId")
    private String referenceId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("allowBeneficiary")
    private Boolean allowBeneficiary;

    @JsonProperty("allowJointApplicant")
    private Boolean allowJointApplicant;

    @JsonProperty("businessLoanProcessingMethod")
    private String businessLoanProcessingMethod;

    @JsonProperty("cardTextColorType")
    private String cardTextColorType;

    @JsonProperty("category")
    private String category;

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    private String description;

    @JsonProperty("disabled")
    private Boolean disabled;

    @JsonProperty("enableAutomaticRepayment")
    private Boolean enableAutomaticRepayment;

    @JsonProperty("enableSettlementInstruction")
    private Boolean enableSettlementInstruction;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    @JsonProperty("externalId")
    private String externalId;

    @JsonProperty("external")
    private Boolean external;

    @JsonProperty("fullDescription")
    private String fullDescription;

    @JsonProperty("iconClass")
    private String iconClass;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("infoUrl")
    private String infoUrl;

    @JsonProperty("internal")
    private Boolean internal;

    @JsonProperty("isBalloonRepaymentSupported")
    private Boolean isBalloonRepaymentSupported;

    @JsonProperty("isCloningSupported")
    private Boolean isCloningSupported;

    @JsonProperty("isEmployee")
    private Boolean isEmployee;

    @JsonProperty("isInterestOnlyRepaymentSupported")
    private Boolean isInterestOnlyRepaymentSupported;

    @JsonProperty("isLadderSupported")
    private Boolean isLadderSupported;

    @JsonProperty("maximumQuantity")
    private Integer maximumQuantity;

    @JsonProperty("popular")
    private Boolean popular;

    @JsonProperty("revolving")
    private Boolean revolving;

    @JsonProperty("secured")
    private Boolean secured;

    @JsonProperty("sortOrder")
    private Integer sortOrder;

    @JsonProperty("termUnit")
    private String termUnit;

    @JsonProperty("type")
    private String type;

    @JsonProperty("features")
    private List<FeatureResponse> features;

    @JsonProperty("terms")
    private List<TermResponse> terms;
}
