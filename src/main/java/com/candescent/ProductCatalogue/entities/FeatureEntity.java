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

import java.time.LocalDate;

/**
 * Database entity for Product Feature.
 */
@Entity
@Table(name = "product_feature")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeatureEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "field_type")
    private String fieldType;

    @Column(name = "label")
    private String label;

    @Column(name = "value", columnDefinition = "TEXT")
    private String value;

    @Column(name = "value_name", length = 1000)
    private String valueName;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_comparable")
    private Boolean isComparable;

    @Column(name = "internal")
    private Boolean internal;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;
}
