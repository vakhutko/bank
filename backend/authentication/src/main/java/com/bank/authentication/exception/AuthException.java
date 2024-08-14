package com.bank.authentication.exception;

public class AuthException extends ApiException {
    public AuthException(String message, String errorCode) {
        super(message, errorCode);
    }
}
