package com.candescent.ProductCatalogue.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Database entity for Product Term.
 */
@Entity
@Table(name = "product_term")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TermEntity extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @Column(name = "min_term")
    private Integer minTerm;

    @Column(name = "min_amount")
    private BigDecimal minAmount;

    @Column(name = "max_amount")
    private BigDecimal maxAmount;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;
}
