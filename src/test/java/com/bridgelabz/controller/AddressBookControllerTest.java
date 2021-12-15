package com.bridgelabz.controller;

import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.service.AddressBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressBookControllerTest {

    @InjectMocks
    private AddressBookController addressBookController;

    @Mock
    private AddressBookService addressBookService;

    @Test
    void givenAListOfAddress_whenGetAllListOFAddressCalled_shouldReturnListOfAddress() {
        List<AddressBookDto> addressBookDtoList = new ArrayList<>();
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFirstName("Sreelipta");
        addressBookDto.setLastName("Sahoo");
        addressBookDto.setAddress("cda");
        addressBookDto.setState("Odisha");
        addressBookDto.setCity("Cuttack");
        addressBookDto.setPhoneNumber("9876543210");
        addressBookDto.setPinCode("765432");
        addressBookDtoList.add(addressBookDto);
        AddressBookDto addressBookDto1 = new AddressBookDto();
        addressBookDto1.setFirstName("Simran");
        addressBookDto1.setLastName("Sahoo");
        addressBookDto1.setAddress("cda");
        addressBookDto1.setState("Odisha");
        addressBookDto1.setCity("Cuttack");
        addressBookDto1.setPhoneNumber("9878843210");
        addressBookDto1.setPinCode("665432");
        addressBookDtoList.add(addressBookDto1);

        when(addressBookService.getListOfAllAddress()).thenReturn(addressBookDtoList);
        List<AddressBookDto> actualResponse = addressBookController.getListOfAllAddress();
        for (int i = 0; i < actualResponse.size(); i++) {
            assertEquals(addressBookDtoList.get(i).getFirstName(), actualResponse.get(i).getFirstName());
            assertEquals(addressBookDtoList.get(i).getLastName(), actualResponse.get(i).getLastName());
            assertEquals(addressBookDtoList.get(i).getAddress(), actualResponse.get(i).getAddress());
            assertEquals(addressBookDtoList.get(i).getCity(), actualResponse.get(i).getCity());
            assertEquals(addressBookDtoList.get(i).getState(), actualResponse.get(i).getState());
            assertEquals(addressBookDtoList.get(i).getPhoneNumber(), actualResponse.get(i).getPhoneNumber());
            assertEquals(addressBookDtoList.get(i).getPinCode(), actualResponse.get(i).getPinCode());
        }
    }

    @Test
    void givenAddressDetails_whenAddAddressDetailsCalled_shouldAddTheAddress() {
        String successString = "Address added successfully";
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFirstName("Sreelipta");
        addressBookDto.setLastName("Sahoo");
        addressBookDto.setAddress("cda");
        addressBookDto.setState("Odisha");
        addressBookDto.setCity("Cuttack");
        addressBookDto.setPhoneNumber("9876543210");
        addressBookDto.setPinCode("765432");
        when(addressBookService.addAddress(addressBookDto)).thenReturn(successString);
        String actualResponseString = addressBookController.addAddress(addressBookDto);
        assertEquals(successString, actualResponseString);
    }

    @Test
    void givenAAddressDetails_whenUpdateAddressDetailsCalled_shouldUpdateTheAddress() {
        String successString = "Employee Details updated successfully";
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFirstName("Sreelipta");
        addressBookDto.setLastName("Sahoo");
        addressBookDto.setAddress("cda");
        addressBookDto.setState("Odisha");
        addressBookDto.setCity("Cuttack");
        addressBookDto.setPhoneNumber("9876543210");
        addressBookDto.setPinCode("765432");
        when(addressBookService.updateAddress(id, addressBookDto)).thenReturn(successString);
        String actualResponseString = addressBookController.updateAddress(id,addressBookDto);
        assertEquals(successString, actualResponseString);
    }

    @Test
    void givenAAddressId_whenDeleteAddressDetailsCalled_shouldDeleteTheAddress() {
        String successString = "Address deleted successfully";
        int id = 1;
        when(addressBookService.deleteAddress(id)).thenReturn(successString);
        String actualResponseString = addressBookController.deleteAddress(id);
        assertEquals(successString, actualResponseString);
    }

}
