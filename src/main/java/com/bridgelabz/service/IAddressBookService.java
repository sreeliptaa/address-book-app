package com.bridgelabz.service;

import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.entity.AddressBook;

import java.util.List;

/**
 * Purpose : To occure all the process of adress book class
 *
 * @author SREELIPTA
 * @since 06-12-2021
 */
public interface IAddressBookService {
    List<AddressBook> getAllAddressBook();

    AddressBook addAddressBook(AddressBookDto addressBookDto);

    AddressBook findAddressBookById(int id);

    String updateAddressBook(int id, AddressBookDto addressBookDto);

    String deleteAddressBook(int id);
}
