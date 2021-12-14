package com.bridgelabz.service;

import com.bridgelabz.builder.AddressBookBuilder;
import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.entity.AddressBook;
import com.bridgelabz.exception.CustomException;
import com.bridgelabz.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Purpose : To implement all the methods in controller class
 *
 * @author : SREELIPTA
 * @since : 10-12-2021
 */

@Service
public class AddressBookService implements IAddressBookService {
    private static final String ADDRESS_BOOK_DETAIL_UPDATED_SUCCESSFULLY = "Address Book data Updated Successfully";
    private static final String ADDRESS_BOOK_DETAIL_DELETED_SUCCESSFULLY = "Address Book data Deleted Successfully";


    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressBookBuilder addressBookBuilder;

    /**
     * Purpose : To add the address detail to the database
     *
     * @param addressBookDto :is used to add data from client
     * @return address book records are created
     */
    @Override
    public AddressBook addAddressBook(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook();
        addressBook = addressBookBuilder.buildAddressBook(addressBookDto, addressBook);
        return addressRepository.save(addressBook);
    }

    /**
     * Purpose : To get list of all the record of adress book
     *
     * @return the list of all adress book records
     */
    @Override
    public List<AddressBook> getAllAddressBook() {
        return addressRepository.findAll();
    }

    /**
     * Purpose : To get particular record of adress book by id
     *
     * @param id unique id of the records
     * @return the status of the adress book records
     */
    @Override
    public AddressBook findAddressBookById(int id) {
        return addressRepository.findById(id).
                orElseThrow(() -> new CustomException("Address Book data not found of this id :" + id));
    }

    /**
     * Purpose : To update the available records in the database
     *
     * @param id  unique id of the records
     * @param addressBookDto getting data from client
     * @return updated records of the adress book
     */
    @Override
    public String updateAddressBook(int id, AddressBookDto addressBookDto) {
        AddressBook addressBook = findAddressBookById(id);
        addressBook = addressBookBuilder.buildAddressBook(addressBookDto, addressBook);
        addressRepository.save(addressBook);
        return ADDRESS_BOOK_DETAIL_UPDATED_SUCCESSFULLY;
    }

    /**
     * Purpose : To delete particular record from the adress book
     *
     * @param id unique id of the adress book records
     * @return the status of the record which deleted or not
     */
    @Override
    public String deleteAddressBook(int id) {
        AddressBook addressBook = findAddressBookById(id);
        addressRepository.deleteById(id);
        return ADDRESS_BOOK_DETAIL_DELETED_SUCCESSFULLY;
    }
}
