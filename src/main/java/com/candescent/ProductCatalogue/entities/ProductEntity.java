package com.candescent.ProductCatalogue.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Database entity for Product.
 */
@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity extends BaseEntity {

    @Column(name = "reference_id", unique = true)
    private String referenceId;

    @Column(name = "name")
    private String name;

    @Column(name = "allow_beneficiary")
    private Boolean allowBeneficiary;

    @Column(name = "allow_joint_applicant")
    private Boolean allowJointApplicant;

    @Column(name = "business_loan_processing_method")
    private String businessLoanProcessingMethod;

    @Column(name = "card_text_color_type")
    private String cardTextColorType;

    @Column(name = "category")
    private String category;

    @Column(name = "code")
    private String code;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "enable_automatic_repayment")
    private Boolean enableAutomaticRepayment;

    @Column(name = "enable_settlement_instruction")
    private Boolean enableSettlementInstruction;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "external")
    private Boolean external;

    @Column(name = "full_description", columnDefinition = "TEXT")
    private String fullDescription;

    @Column(name = "icon_class")
    private String iconClass;

    @Column(name = "image_url", length = 2048)
    private String imageUrl;

    @Column(name = "info_url", length = 2048)
    private String infoUrl;

    @Column(name = "internal")
    private Boolean internal;

    @Column(name = "is_balloon_repayment_supported")
    private Boolean isBalloonRepaymentSupported;

    @Column(name = "is_cloning_supported")
    private Boolean isCloningSupported;

    @Column(name = "is_employee")
    private Boolean isEmployee;

    @Column(name = "is_interest_only_repayment_supported")
    private Boolean isInterestOnlyRepaymentSupported;

    @Column(name = "is_ladder_supported")
    private Boolean isLadderSupported;

    @Column(name = "maximum_quantity")
    private Integer maximumQuantity;

    @Column(name = "popular")
    private Boolean popular;

    @Column(name = "revolving")
    private Boolean revolving;

    @Column(name = "secured")
    private Boolean secured;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "term_unit")
    private String termUnit;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderBy("sortOrder ASC")
    @Builder.Default
    private List<FeatureEntity> features = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderBy("sortOrder ASC")
    @Builder.Default
    private List<TermEntity> terms = new ArrayList<>();

    public void addFeature(FeatureEntity feature) {
        features.add(feature);
        feature.setProduct(this);
    }

    public void removeFeature(FeatureEntity feature) {
        features.remove(feature);
        feature.setProduct(null);
    }

    public void addTerm(TermEntity term) {
        terms.add(term);
        term.setProduct(this);
    }

    public void removeTerm(TermEntity term) {
        terms.remove(term);
        term.setProduct(null);
    }
}
