package com.candescent.ProductCatalogue.service;

import com.candescent.ProductCatalogue.dto.request.FeatureLoadRequest;
import com.candescent.ProductCatalogue.dto.request.ProductLoadRequest;
import com.candescent.ProductCatalogue.dto.request.TermLoadRequest;
import com.candescent.ProductCatalogue.entities.FeatureEntity;
import com.candescent.ProductCatalogue.entities.ProductEntity;
import com.candescent.ProductCatalogue.entities.TermEntity;
import com.candescent.ProductCatalogue.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for loading product data from JSON payload.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DataLoaderService {

    private final ProductRepository productRepository;

    /**
     * Loads products with their features and terms from the request payload.
     */
    @Transactional
    public int loadProducts(List<ProductLoadRequest> requests) {
        log.info(">>> Loading {} products", requests.size());
        int count = 0;

        List<ProductEntity> productEntities = new ArrayList<>();
        for (ProductLoadRequest request : requests) {
            try {
                ProductEntity product = mapToProductEntity(request);

                if (request.getFeatures() != null) {
                    for (FeatureLoadRequest featureRequest : request.getFeatures()) {
                        FeatureEntity feature = mapToFeatureEntity(featureRequest);
                        product.addFeature(feature);
                    }
                }

                if (request.getTerms() != null) {
                    for (TermLoadRequest termRequest : request.getTerms()) {
                        TermEntity term = mapToTermEntity(termRequest);
                        product.addTerm(term);
                    }
                }

                productEntities.add(product);
                count++;
                log.debug("Loaded product: {} ({})", product.getName(), product.getCode());
            } catch (Exception e) {
                log.error("Failed to load product: {}", request.getCode(), e);
            }
        }

        productRepository.saveAll(productEntities);
        log.info("<<< Successfully loaded {} products", count);
        return count;
    }

    private ProductEntity mapToProductEntity(ProductLoadRequest req) {
        return ProductEntity.builder()
                .referenceId(req.getReferenceId())
                .name(req.getName())
                .allowBeneficiary(req.getAllowBeneficiary())
                .allowJointApplicant(req.getAllowJointApplicant())
                .businessLoanProcessingMethod(req.getBusinessLoanProcessingMethod())
                .cardTextColorType(req.getCardTextColorType())
                .category(req.getCategory())
                .code(req.getCode())
                .description(req.getDescription())
                .disabled(req.getDisabled())
                .enableAutomaticRepayment(req.getEnableAutomaticRepayment())
                .enableSettlementInstruction(req.getEnableSettlementInstruction())
                .startDate(req.getStartDate())
                .endDate(req.getEndDate())
                .externalId(req.getExternalId())
                .external(req.getExternal())
                .fullDescription(req.getFullDescription())
                .iconClass(req.getIconClass())
                .imageUrl(req.getImageUrl())
                .infoUrl(req.getInfoUrl())
                .internal(req.getInternal())
                .isBalloonRepaymentSupported(req.getIsBalloonRepaymentSupported())
                .isCloningSupported(req.getIsCloningSupported())
                .isEmployee(req.getIsEmployee())
                .isInterestOnlyRepaymentSupported(req.getIsInterestOnlyRepaymentSupported())
                .isLadderSupported(req.getIsLadderSupported())
                .maximumQuantity(req.getMaximumQuantity())
                .popular(req.getPopular())
                .revolving(req.getRevolving())
                .secured(req.getSecured())
                .sortOrder(req.getSortOrder())
                .termUnit(req.getTermUnit())
                .type(req.getType())
                .build();
    }

    private FeatureEntity mapToFeatureEntity(FeatureLoadRequest req) {
        return FeatureEntity.builder()
                .name(req.getName())
                .code(req.getCode())
                .description(req.getDescription())
                .fieldType(req.getFieldType())
                .label(req.getLabel())
                .value(req.getValue())
                .valueName(req.getValueName())
                .disabled(req.getDisabled())
                .startDate(req.getStartDate())
                .endDate(req.getEndDate())
                .isComparable(req.getIsComparable())
                .internal(req.getInternal())
                .externalId(req.getExternalId())
                .sortOrder(req.getSortOrder())
                .build();
    }

    private TermEntity mapToTermEntity(TermLoadRequest req) {
        return TermEntity.builder()
                .code(req.getCode())
                .label(req.getLabel())
                .minTerm(req.getMinTerm())
                .minAmount(req.getMinAmount())
                .maxAmount(req.getMaxAmount())
                .rate(req.getRate())
                .disabled(req.getDisabled())
                .startDate(req.getStartDate())
                .endDate(req.getEndDate())
                .externalId(req.getExternalId())
                .sortOrder(req.getSortOrder())
                .build();
    }
}
