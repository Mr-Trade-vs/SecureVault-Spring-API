package com.secure_vault.exceptions;

public class SecretValidationException extends RuntimeException {

    public SecretValidationException(String message) {
        super(message);
    }

}
