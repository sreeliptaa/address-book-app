package com.bridgelabz.service;

import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.entity.AddressBook;

import java.util.List;

/**
 * Purpose : This is the interface of address book by which all the process of service class will occur
 *
 * @author SREELIPTA
 * @since 2021-12-11
 */
public interface IAddressBookService {

    List<AddressBookDto> getListOfAllAddress();

    AddressBook findAddressById(int id);

    String addAddress(AddressBookDto addressBookDto);

    String updateAddress(int id, AddressBookDto addressBookDto);

    String deleteAddress(int id);
}
