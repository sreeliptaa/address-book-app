package com.bridgelabz.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Purpose : To invoke data from client
 *
 * @author SREELIPTA
 * @since 06-12-2021
 */
@Data
public class AddressBookDto {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = " Firstname is invalid")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = " Lastname is invalid")
    private String lastName;

    @NotNull(message = "Address should not be empty")
    private String address;

    @NotNull(message = "City name should not be empty")
    private String city;

    @NotNull(message = "State name should not be empty")
    private String state;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number is invalid")
    private String phoneNumber;

    @Pattern(regexp = "^[0-9]{6}$",
            message = "Pin code should be 6 digit")
    private String pinCode;
}


