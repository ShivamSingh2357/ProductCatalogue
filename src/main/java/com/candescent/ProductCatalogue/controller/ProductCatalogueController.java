package com.candescent.ProductCatalogue.controller;

import com.candescent.ProductCatalogue.api.ProductCatalogueApi;
import com.candescent.ProductCatalogue.common.exception.ServiceException;
import com.candescent.ProductCatalogue.dto.common.ServiceResponse;
import com.candescent.ProductCatalogue.dto.response.ProductResponse;
import com.candescent.ProductCatalogue.service.ProductService;
import com.candescent.ProductCatalogue.service.ProductService.ProductPageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for Product Catalogue operations.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductCatalogueController implements ProductCatalogueApi {

    private final ProductService productService;

    @Override
    public ServiceResponse<List<ProductResponse>> getAllProducts(
            String category, String type, String search, int page, int limit
    ) {

        log.info(">>> GET /v1/products - category: {}, type: {}, search: {}, page: {}, limit: {}",
                category, type, search, page, limit);

        try {
            ProductPageResult result = productService.getAllProducts(category, type, search, page, limit);
            log.info("<<< Returning {} products", result.getProducts().size());
            return ServiceResponse.success(result.getProducts(), result.getPagination());
        } catch (Exception e) {
            log.error("Failed to fetch products: {}", e.getMessage(), e);
            throw new ServiceException("Unable to retrieve products");
        }
    }
}
