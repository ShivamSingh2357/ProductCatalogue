package com.candescent.ProductCatalogue.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * Response DTO for Product Feature.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeatureResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    private String description;

    @JsonProperty("fieldType")
    private String fieldType;

    @JsonProperty("label")
    private String label;

    @JsonProperty("value")
    private String value;

    @JsonProperty("valueName")
    private String valueName;

    @JsonProperty("disabled")
    private Boolean disabled;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    @JsonProperty("isComparable")
    private Boolean isComparable;

    @JsonProperty("internal")
    private Boolean internal;

    @JsonProperty("externalId")
    private String externalId;

    @JsonProperty("sortOrder")
    private Integer sortOrder;

    @JsonProperty("productId")
    private Long productId;
}
