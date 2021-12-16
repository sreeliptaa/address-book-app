package com.bridgelabz.builder;

import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.entity.AddressBook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Purpose : This builder class which holds all the building related application
 *
 * @author SREELIPTA
 * @since 10-12-2021
 */
@Component
public class AddressBookBuilder {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose : This method is created to copy the properties of simple POJO to @Entity class
     *
     * @param addressBookDto    : This the POJO class's object which is the source for copying the properties
     * @param addressBook : This is the Entity class's object which is the destination for that copied properties
     * @return the object of AddressBook class
     */
    public AddressBook buildAddressBook(AddressBookDto addressBookDto, AddressBook addressBook) {
        BeanUtils.copyProperties(addressBookDto, addressBook);
        return addressBook;
    }

}
