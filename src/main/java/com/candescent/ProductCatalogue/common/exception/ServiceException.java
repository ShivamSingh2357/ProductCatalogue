package com.candescent.ProductCatalogue.common.exception;

import com.candescent.ProductCatalogue.common.constants.AppConstants;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a service operation fails.
 */
public class ServiceException extends BaseException {

    public ServiceException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, AppConstants.ErrorCode.SERVICE_ERROR);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, AppConstants.ErrorCode.SERVICE_ERROR, cause);
    }
}
