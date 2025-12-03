package com.candescent.ProductCatalogue.common.exception;

import com.candescent.ProductCatalogue.common.constants.AppConstants;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a bad request is made.
 */
public class BadRequestException extends BaseException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST, AppConstants.ErrorCode.BAD_REQUEST);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, HttpStatus.BAD_REQUEST, AppConstants.ErrorCode.BAD_REQUEST, cause);
    }
}
