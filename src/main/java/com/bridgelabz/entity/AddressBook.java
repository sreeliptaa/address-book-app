package com.bridgelabz.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Purpose : To contain the entities in the database
 *
 * @author SREELIPTA
 * @since 10-12-2021
 */
@Entity
@Table(name = "address_book_app")
@Data
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "PHONE_NO")
    private  String phoneNumber;

    @Column(name = "PIN")
    private String pinCode;



}
