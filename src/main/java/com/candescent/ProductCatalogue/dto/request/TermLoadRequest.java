package com.candescent.ProductCatalogue.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for loading term data.
 */
@Data
@NoArgsConstructor
public class TermLoadRequest {

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
}
