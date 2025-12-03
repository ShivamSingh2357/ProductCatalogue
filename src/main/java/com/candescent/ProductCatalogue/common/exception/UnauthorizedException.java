package com.candescent.ProductCatalogue.common.exception;

import com.candescent.ProductCatalogue.common.constants.AppConstants;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when authentication fails or is missing.
 */
public class UnauthorizedException extends BaseException {

    public UnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, AppConstants.ErrorCode.UNAUTHORIZED);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, HttpStatus.UNAUTHORIZED, AppConstants.ErrorCode.UNAUTHORIZED, cause);
    }
}
