package com.candescent.ProductCatalogue.api;

import com.candescent.ProductCatalogue.dto.common.ServiceRequest;
import com.candescent.ProductCatalogue.dto.common.ServiceResponse;
import com.candescent.ProductCatalogue.dto.request.ProductLoadRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * API interface for Data Loader operations.
 */
@Tag(name = "Data Loader", description = "Temporary APIs for loading test data")
@RequestMapping("/v1/data-loader")
public interface DataLoaderApi {

    @Operation(
            summary = "Load products",
            description = "Loads products with features and terms from JSON payload"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Products loaded successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class)
                    )
            )
    })
    @PostMapping("/products")
    ServiceResponse<Map<String, Object>> loadProducts(
            @RequestBody ServiceRequest<List<ProductLoadRequest>> request
    );
}
