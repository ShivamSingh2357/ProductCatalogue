package com.candescent.ProductCatalogue.dto.common;

import com.candescent.ProductCatalogue.common.constants.AppConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Generic wrapper for API response payloads.
 *
 * @param <T> the type of the response payload
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse<T> {

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("errorDescription")
    private String errorDescription;

    @JsonProperty("payload")
    private T payload;

    @JsonProperty("pagination")
    private Pagination pagination;

    public static <T> ServiceResponse<T> success(T payload) {
        return ServiceResponse.<T>builder()
                .status(AppConstants.Status.SUCCESS)
                .payload(payload)
                .build();
    }

    public static <T> ServiceResponse<T> success(T payload, String message) {
        return ServiceResponse.<T>builder()
                .status(AppConstants.Status.SUCCESS)
                .message(message)
                .payload(payload)
                .build();
    }

    public static <T> ServiceResponse<T> success(T payload, Pagination pagination) {
        return ServiceResponse.<T>builder()
                .status(AppConstants.Status.SUCCESS)
                .payload(payload)
                .pagination(pagination)
                .build();
    }

    public static <T> ServiceResponse<T> fail(String errorDescription) {
        return ServiceResponse.<T>builder()
                .status(AppConstants.Status.FAIL)
                .errorDescription(truncate(errorDescription))
                .build();
    }

    private static String truncate(String message) {
        if (message == null) {
            return AppConstants.ErrorMessage.DEFAULT_ERROR;
        }
        String trimmed = message.trim();
        if (trimmed.length() <= AppConstants.Validation.MAX_ERROR_LENGTH) {
            return trimmed;
        }
        return trimmed.substring(0, AppConstants.Validation.MAX_ERROR_LENGTH - 3) + "...";
    }
}
