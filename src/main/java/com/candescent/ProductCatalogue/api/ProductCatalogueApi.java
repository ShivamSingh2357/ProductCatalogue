package com.candescent.ProductCatalogue.api;

import com.candescent.ProductCatalogue.dto.common.ServiceResponse;
import com.candescent.ProductCatalogue.dto.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * API interface for Product Catalogue operations.
 */
@Tag(name = "Products", description = "Product listing and details")
@RequestMapping("/v1/products")
public interface ProductCatalogueApi {

    @Operation(
            summary = "Get list of products",
            description = "Retrieve a list of products with optional filtering by category, type, and search query. Supports pagination for large result sets."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful response with product list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ServiceResponse<List<ProductResponse>> getAllProducts(
            @Parameter(description = "Filter by product category", example = "CONSUMER")
            @RequestParam(required = false) String category,

            @Parameter(description = "Filter by product type", example = "savings")
            @RequestParam(required = false) String type,

            @Parameter(description = "Search query to filter products by title, tagline, or description", example = "savings account")
            @RequestParam(required = false) String search,

            @Parameter(description = "Page number for pagination (1-indexed)", example = "1")
            @RequestParam(defaultValue = "1") int page,

            @Parameter(description = "Number of items per page", example = "20")
            @RequestParam(defaultValue = "20") int limit
    );
}
