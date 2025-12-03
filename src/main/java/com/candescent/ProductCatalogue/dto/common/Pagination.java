package com.candescent.ProductCatalogue.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pagination information for paginated responses.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pagination {

    @JsonProperty("page")
    private int page;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("total")
    private long total;

    @JsonProperty("totalPages")
    private int totalPages;

    public static Pagination of(int page, int limit, long total) {
        int totalPages = (int) Math.ceil((double) total / limit);
        return Pagination.builder()
                .page(page)
                .limit(limit)
                .total(total)
                .totalPages(totalPages)
                .build();
    }
}




