package com.candescent.ProductCatalogue.service;

import com.candescent.ProductCatalogue.dto.common.Pagination;
import com.candescent.ProductCatalogue.dto.mock.ProductData;
import com.candescent.ProductCatalogue.dto.mock.RpcResponse;
import com.candescent.ProductCatalogue.dto.response.ProductResponse;
import com.candescent.ProductCatalogue.entities.ProductEntity;
import com.candescent.ProductCatalogue.mapper.ProductResponseMapper;
import com.candescent.ProductCatalogue.repository.ProductRepository;
import com.candescent.ProductCatalogue.specification.ProductSpecification;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * Service for product-related business operations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private static final String MOCK_DATA_FILE = "mock-data/products.json";

    private final ObjectMapper objectMapper;
    private final ProductRepository productRepository;
    private final ProductResponseMapper productResponseMapper;

    @Value("${app.product.use-mock-data:false}")
    private boolean useMockData;

    private List<ProductData> cachedProducts;

    @PostConstruct
    public void loadMockData() {
        log.info("Mock data flag is set to: {}", useMockData);

        if (!useMockData) {
            log.info("Skipping mock data loading - using database");
            cachedProducts = Collections.emptyList();
            return;
        }

        log.info("Loading mock product data from {}", MOCK_DATA_FILE);
        try {
            ClassPathResource resource = new ClassPathResource(MOCK_DATA_FILE);
            try (InputStream inputStream = resource.getInputStream()) {
                List<RpcResponse> responses = objectMapper.readValue(
                        inputStream,
                        new TypeReference<List<RpcResponse>>() {}
                );

                if (responses != null && !responses.isEmpty()
                        && responses.get(0).getResult() != null
                        && responses.get(0).getResult().getData() != null) {
                    cachedProducts = responses.get(0).getResult().getData();
                    log.info("Successfully loaded {} products from mock data", cachedProducts.size());
                } else {
                    log.warn("Mock data file is empty or has invalid structure");
                    cachedProducts = Collections.emptyList();
                }
            }
        } catch (IOException e) {
            log.error("Failed to load mock data from {}: {}", MOCK_DATA_FILE, e.getMessage(), e);
            cachedProducts = Collections.emptyList();
        }
    }

    /**
     * Retrieves products with pagination and optional filters.
     * Only parameters with values are included in the query.
     */
    @Transactional(readOnly = true)
    public ProductPageResult getAllProducts(String category, String type, String search, int page, int limit) {

        log.info(">>> Fetching products - category: {}, type: {}, search: {}, page: {}, limit: {}",
                category, type, search, page, limit);

        // Build specification dynamically - only add conditions for provided params
        Specification<ProductEntity> spec = buildSpecification(category, type, search);

        Pageable pageable = PageRequest.of(Math.max(0, page - 1), limit);
        Page<ProductEntity> productPage = (spec != null)
                ? productRepository.findAll(spec, pageable)
                : productRepository.findAll(pageable);

        // Initialize lazy-loaded collections
        productPage.getContent().forEach(entity -> {
            entity.getFeatures().size();
            entity.getTerms().size();
        });


        List<ProductResponse> products = productResponseMapper.toResponseList(productPage.getContent());
        Pagination pagination = Pagination.of(page, limit, productPage.getTotalElements());

        log.info("<<< Returning {} products (total: {})", products.size(), productPage.getTotalElements());
        return new ProductPageResult(products, pagination);
    }

    /**
     * Builds JPA Specification dynamically based on provided parameters.
     * Only adds conditions for non-null, non-empty parameters.
     */
    private Specification<ProductEntity> buildSpecification(String category, String type, String search) {
        Specification<ProductEntity> spec = null;

        if (StringUtils.hasText(category)) {
            spec = ProductSpecification.hasCategory(category.trim());
        }

        if (StringUtils.hasText(type)) {
            Specification<ProductEntity> typeSpec = ProductSpecification.hasType(type.trim());
            spec = (spec == null) ? typeSpec : spec.and(typeSpec);
        }

        if (StringUtils.hasText(search)) {
            Specification<ProductEntity> searchSpec = ProductSpecification.searchByNameOrDescription(search.trim());
            spec = (spec == null) ? searchSpec : spec.and(searchSpec);
        }

        return spec;
    }

    /**
     * Result holder for paginated products.
     */
    @Getter
    @RequiredArgsConstructor
    public static class ProductPageResult {
        private final List<ProductResponse> products;
        private final Pagination pagination;
    }
}
