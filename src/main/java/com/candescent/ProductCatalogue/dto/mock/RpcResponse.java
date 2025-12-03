package com.candescent.ProductCatalogue.dto.mock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RPC response wrapper from the mock API.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RpcResponse {

    private Integer statusCode;
    private String type;
    private Integer tid;
    private Boolean ref;
    private String action;
    private String method;
    private ProductResult result;
}

