package com.candescent.ProductCatalogue.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Response DTO for Product Term.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TermResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("label")
    private String label;

    @JsonProperty("minTerm")
    private Integer minTerm;

    @JsonProperty("minAmount")
    private BigDecimal minAmount;

    @JsonProperty("maxAmount")
    private BigDecimal maxAmount;

    @JsonProperty("rate")
    private BigDecimal rate;

    @JsonProperty("disabled")
    private Boolean disabled;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    @JsonProperty("externalId")
    private String externalId;

    @JsonProperty("sortOrder")
    private Integer sortOrder;

    @JsonProperty("productId")
    private Long productId;
}
