package com.bridgelabz.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    @Size(min = 10, message = "Address can not be empty")
    private String address;

    @Size(min = 10, message = "City can not be empty")
    private String city;

    @Size(min = 10, message = "State can not be empty")
    private String state;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number is invalid")
    private String phoneNumber;

    @Pattern(regexp = "^[0-9]{6}$",
            message = "Pin code should be 6 digit")
    private String pinCode;
}
