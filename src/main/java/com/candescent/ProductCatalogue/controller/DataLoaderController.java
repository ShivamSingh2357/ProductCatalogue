package com.candescent.ProductCatalogue.controller;

import com.candescent.ProductCatalogue.api.DataLoaderApi;
import com.candescent.ProductCatalogue.dto.common.ServiceRequest;
import com.candescent.ProductCatalogue.dto.common.ServiceResponse;
import com.candescent.ProductCatalogue.dto.request.ProductLoadRequest;
import com.candescent.ProductCatalogue.service.DataLoaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Temporary controller for loading test data.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class DataLoaderController implements DataLoaderApi {

    private final DataLoaderService dataLoaderService;

    @Override
    public ServiceResponse<Map<String, Object>> loadProducts(ServiceRequest<List<ProductLoadRequest>> request) {
        List<ProductLoadRequest> products = request.getPayload();
        
        if (products == null || products.isEmpty()) {
            return ServiceResponse.fail("No products provided in request");
        }
        
        log.info("Loading {} products", products.size());
        int loaded = dataLoaderService.loadProducts(products);
        
        return ServiceResponse.success(Map.of("productsLoaded", loaded));
    }
}
