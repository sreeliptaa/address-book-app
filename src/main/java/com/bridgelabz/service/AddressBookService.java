package com.bridgelabz.service;

import com.bridgelabz.builder.AddressBookBuilder;
import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.entity.AddressBook;
import com.bridgelabz.exception.AddressBookCustomException;
import com.bridgelabz.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Purpose : To implement all the methods in controller class
 *
 * @author : SREELIPTA
 * @since : 10-12-2021
 */

@Service
public class AddressBookService {
    private static final String ADDRESS_ADDED_SUCCESSFULLY = "Address added successfully";
    private static final String INVALID_ID = "Invalid id";
    private static final String ADDRESS_DELETED_SUCCESSFULLY = "Address deleted successfully";
    private static final String ADDRESS_UPDATED_SUCCESSFULLY = "Address updated successfully";
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressBookBuilder addressBookBuilder;

    /**
     * Purpose : To get list of all the record of adress book
     *
     * @return the list of all adress book records
     */
    public List<AddressBookDto> getListOfAllAddress() {
        return addressRepository
                .findAll()
                .stream()
                .map(addressBook -> modelMapper.map(addressBook, AddressBookDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Purpose : To add the address detail to the database
     *
     * @param addressBookDto :is used to add data from client
     * @return address book records are created
     */
    public String addAddress(AddressBookDto addressBookDto) {
        AddressBook addressBook = modelMapper.map(addressBookDto, AddressBook.class);
        addressRepository.save(addressBook);
        return ADDRESS_ADDED_SUCCESSFULLY;
    }

    /**
     * Purpose : To update the available records in the database
     *
     * @param id  unique id of the records
     * @param addressBookDto getting data from client
     * @return updated records of the adress book
     */
    public String updateAddress(int id, AddressBookDto addressBookDto) throws AddressBookCustomException {
        AddressBook addressBook = findAtmEntityById(id);
        addressBook = addressBookBuilder.buildAddressBook(addressBookDto, addressBook);
        addressRepository.save(addressBook);
        return ADDRESS_UPDATED_SUCCESSFULLY;
    }

    /**
     * Purpose : To delete particular record from the adress book
     *
     * @param id unique id of the adress book records
     * @return the status of the record which deleted or not
     */
    public String deleteAddress(int id) throws AddressBookCustomException {
        AddressBook addressBook = findAtmEntityById(id);
        addressRepository.delete(addressBook);
        return ADDRESS_DELETED_SUCCESSFULLY;
    }
    /**
     * Purpose : To get particular record of adress book by id
     *
     * @param id unique id of the records
     * @return the status of the adress book records
     */
    private AddressBook findAtmEntityById(int id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressBookCustomException(INVALID_ID));
    }

}
