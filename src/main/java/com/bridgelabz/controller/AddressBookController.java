package com.bridgelabz.controller;

import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.dto.ResponseDto;
import com.bridgelabz.entity.AddressBook;
import com.bridgelabz.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Purpose : To demonstrate various HTTP request methods
 *
 * @author : SREELIPTA
 * @since : 12-12-2021
 */
@RestController
@RequestMapping(value = "/address-book")
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;

    /**
     * Purpose : Method to add new address in address book
     *
     * @return : address detail if its added.
     */
    @PostMapping(value = "/detail")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(
            @RequestBody AddressBookDto addressBookDto) {
        AddressBook addressBook = addressBookService.addAddressBook(addressBookDto);
        ResponseDto responseDto = new ResponseDto("Address Book Data Added ", addressBook);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Purpose : Method to get all the address detail from address book.
     *
     * @return : list of address book detail in JSON format.
     */
    @GetMapping(value = "/detail")
    public ResponseEntity<ResponseDto> getAllAddressBook() {
        List<AddressBook> addressBook = addressBookService.getAllAddressBook();
        ResponseDto responseDto = new ResponseDto("List of Address Book Data", addressBook);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Purpose : Method to get the particular address data from address book.
     *
     * @return : the address detail in JSON format.
     */
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<ResponseDto> getAllAdressBook(
            @PathVariable int id) {
        AddressBook addressBook = addressBookService.findAddressBookById(id);
        ResponseDto responseDto = new ResponseDto("Address Book For this Id", addressBook);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    /**
     * Purpose : Method to update address data from address book by id
     *
     * @return : the updated detail of address book.
     */
    @PutMapping(value = "/detail/{id}")
    public ResponseEntity<ResponseDto> updateAddressBook(
            @PathVariable int id,
            @RequestBody AddressBookDto addressBookDto) {
        String addressBook = addressBookService.updateAddressBook(id, addressBookDto);
        ResponseDto responseDto = new ResponseDto("Address Book Data Updated ", addressBook);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Purpose : Method to delete address data from address book by id
     *
     * @return : the deleted status of address book.
     */
    @DeleteMapping(value = "/detail/{id}")
    public ResponseEntity<ResponseDto> deleteAddressBook(
            @PathVariable int id) {
        addressBookService.deleteAddressBook(id);
        ResponseDto responseDto = new ResponseDto(" Address Book Data Deleted ", "deleted id: " + id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
