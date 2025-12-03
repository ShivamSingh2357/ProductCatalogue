package com.candescent.ProductCatalogue.mapper;

import com.candescent.ProductCatalogue.dto.response.FeatureResponse;
import com.candescent.ProductCatalogue.dto.response.ProductResponse;
import com.candescent.ProductCatalogue.dto.response.TermResponse;
import com.candescent.ProductCatalogue.entities.FeatureEntity;
import com.candescent.ProductCatalogue.entities.ProductEntity;
import com.candescent.ProductCatalogue.entities.TermEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper for converting entities to response DTOs.
 */
@Component
public class ProductResponseMapper {

    public ProductResponse toResponse(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        List<FeatureResponse> features = null;
        if (entity.getFeatures() != null && !entity.getFeatures().isEmpty()) {
            features = entity.getFeatures().stream()
                    .map(f -> toFeatureResponse(f, entity.getId()))
                    .toList();
        }

        List<TermResponse> terms = null;
        if (entity.getTerms() != null && !entity.getTerms().isEmpty()) {
            terms = entity.getTerms().stream()
                    .map(t -> toTermResponse(t, entity.getId()))
                    .toList();
        }

        return ProductResponse.builder()
                .id(entity.getId())
                .referenceId(entity.getReferenceId())
                .name(entity.getName())
                .allowBeneficiary(entity.getAllowBeneficiary())
                .allowJointApplicant(entity.getAllowJointApplicant())
                .businessLoanProcessingMethod(entity.getBusinessLoanProcessingMethod())
                .cardTextColorType(entity.getCardTextColorType())
                .category(entity.getCategory())
                .code(entity.getCode())
                .description(entity.getDescription())
                .disabled(entity.getDisabled())
                .enableAutomaticRepayment(entity.getEnableAutomaticRepayment())
                .enableSettlementInstruction(entity.getEnableSettlementInstruction())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .externalId(entity.getExternalId())
                .external(entity.getExternal())
                .fullDescription(entity.getFullDescription())
                .iconClass(entity.getIconClass())
                .imageUrl(entity.getImageUrl())
                .infoUrl(entity.getInfoUrl())
                .internal(entity.getInternal())
                .isBalloonRepaymentSupported(entity.getIsBalloonRepaymentSupported())
                .isCloningSupported(entity.getIsCloningSupported())
                .isEmployee(entity.getIsEmployee())
                .isInterestOnlyRepaymentSupported(entity.getIsInterestOnlyRepaymentSupported())
                .isLadderSupported(entity.getIsLadderSupported())
                .maximumQuantity(entity.getMaximumQuantity())
                .popular(entity.getPopular())
                .revolving(entity.getRevolving())
                .secured(entity.getSecured())
                .sortOrder(entity.getSortOrder())
                .termUnit(entity.getTermUnit())
                .type(entity.getType())
                .features(features)
                .terms(terms)
                .build();
    }

    private FeatureResponse toFeatureResponse(FeatureEntity entity, Long productId) {
        return FeatureResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .description(entity.getDescription())
                .fieldType(entity.getFieldType())
                .label(entity.getLabel())
                .value(entity.getValue())
                .valueName(entity.getValueName())
                .disabled(entity.getDisabled())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .isComparable(entity.getIsComparable())
                .internal(entity.getInternal())
                .externalId(entity.getExternalId())
                .sortOrder(entity.getSortOrder())
                .productId(productId)
                .build();
    }

    private TermResponse toTermResponse(TermEntity entity, Long productId) {
        return TermResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .label(entity.getLabel())
                .minTerm(entity.getMinTerm())
                .minAmount(entity.getMinAmount())
                .maxAmount(entity.getMaxAmount())
                .rate(entity.getRate())
                .disabled(entity.getDisabled())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .externalId(entity.getExternalId())
                .sortOrder(entity.getSortOrder())
                .productId(productId)
                .build();
    }

    public List<ProductResponse> toResponseList(List<ProductEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(this::toResponse)
                .toList();
    }
}
