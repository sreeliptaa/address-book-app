package com.bridgelabz.builder;

import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.entity.AddressBook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AddressBookBuilderTest {

    @InjectMocks
    private AddressBookBuilder addressBookBuilder;
    @Mock
    private ModelMapper modelMapper;

    @Test
    void givenAddressBookDto_whenNeedToCovertAddressBookDtoToAddressBook_shouldReturnAddressBook() {
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFirstName("Sreelipta");
        addressBookDto.setLastName("Sahoo");
        addressBookDto.setAddress("cda");
        addressBookDto.setState("Odisha");
        addressBookDto.setCity("Cuttack");
        addressBookDto.setPhoneNumber("9876543210");
        addressBookDto.setPinCode("765432");
        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.setFirstName("Sreelipta");
        addressBook.setLastName("Sahoo");
        addressBook.setAddress("cda");
        addressBook.setState("Odisha");
        addressBook.setCity("Cuttack");
        addressBook.setPhoneNumber("9876543210");
        addressBook.setPinCode("765432");

        addressBook = addressBookBuilder.buildAddressBook(addressBookDto, addressBook);
        assertEquals(addressBookDto.getFirstName(), addressBook.getFirstName());
        assertEquals(addressBookDto.getLastName(), addressBook.getLastName());
        assertEquals(addressBookDto.getAddress(), addressBook.getAddress());
        assertEquals(addressBookDto.getState(), addressBook.getState());
        assertEquals(addressBookDto.getCity(), addressBook.getCity());
        assertEquals(addressBookDto.getPhoneNumber(), addressBook.getPhoneNumber());
        assertEquals(addressBookDto.getPinCode(), addressBook.getPinCode());
    }

}
