package com.bridgelabz.controller;

import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
     * Purpose : Method to get all the address detail from address book.
     *
     * @return : list of address book detail in JSON format.
     */
    @GetMapping(value = "/detail")
    public List<AddressBookDto> getListOfAllAddress() {
        return addressBookService.getListOfAllAddress();
    }

    /**
     * Purpose : Method to add new address in address book
     *
     * @return : address detail if its added.
     */
    @PostMapping(value = "/detail")
    public String addAddress(@Valid @RequestBody AddressBookDto addressBookDto) {
        return addressBookService.addAddress(addressBookDto);
    }

    /**
     * Purpose : Method to update address data from address book by id
     *
     * @return : the updated detail of address book.
     */
    @PutMapping("/detail/{id}")
    public String updateAddress(@PathVariable(value = "id") int id,
                                @Valid @RequestBody AddressBookDto addressBookDto){
        return addressBookService.updateAddress(id, addressBookDto);
    }

    /**
     * Purpose : Method to delete address data from address book by id
     *
     * @return : the deleted status of address book.
     */
    @DeleteMapping("/detail/{id}")
    public String deleteAddress(@PathVariable int id) {
        return addressBookService.deleteAddress(id);
    }

}
