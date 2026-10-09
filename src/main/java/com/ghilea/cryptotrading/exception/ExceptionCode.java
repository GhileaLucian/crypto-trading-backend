package com.ghilea.cryptotrading.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Standardized application error codes and localized error message templates.
 *
 * @author Dan Lucian Ghilea
 */
@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    ERR001_WALLET_NOT_FOUND("Wallet not found for ID: %s"),
    ERR001_USER_NOT_FOUND("User not found for ID: %s"),
    ERR002_CRYPTO_NOT_FOUND("Cryptocurrency not found for ID: %s"),
    ERR003_SOURCE_WALLET_NOT_FOUND("Source wallet not found for ID: %s"),
    ERR004_DESTINATION_WALLET_NOT_FOUND("Destination wallet not found for ID: %s"),
    ERR005_INSUFFICIENT_FUNDS("Insufficient funds for transaction");

    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
