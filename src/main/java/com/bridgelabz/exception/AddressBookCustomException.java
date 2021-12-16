package com.bridgelabz.exception;

/**
 * Purpose: To define message in custom exception
 *
 * @author SREELIPTA
 * @since : 10-12-2021
 */
public class AddressBookCustomException extends RuntimeException {
    public AddressBookCustomException(String message) {
        super(message);
    }
}

