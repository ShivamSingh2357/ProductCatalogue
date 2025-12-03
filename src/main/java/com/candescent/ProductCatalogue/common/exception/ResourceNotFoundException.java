package com.candescent.ProductCatalogue.common.exception;

import com.candescent.ProductCatalogue.common.constants.AppConstants;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a requested resource is not found.
 */
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, AppConstants.ErrorCode.RESOURCE_NOT_FOUND);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, HttpStatus.NOT_FOUND, AppConstants.ErrorCode.RESOURCE_NOT_FOUND, cause);
    }
}
