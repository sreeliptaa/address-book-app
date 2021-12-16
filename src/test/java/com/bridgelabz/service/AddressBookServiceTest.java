package com.bridgelabz.service;

import com.bridgelabz.builder.AddressBookBuilder;
import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.entity.AddressBook;
import com.bridgelabz.exception.AddressBookCustomException;
import com.bridgelabz.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {

    @InjectMocks
    private AddressBookService addressBookService;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private AddressBookBuilder addressBookBuilder;
    @Mock
    private ModelMapper modelMapper;

    @Test
    void givenAListOfEmployeeDetails_whenGetAListOfEmployeeCalled_shouldReturnAListOfEmployeeDTo() {
        List<AddressBook> addressBookList = new ArrayList<>();
        AddressBook addressBook1 = new AddressBook();
        addressBook1.setId(1);
        addressBook1.setFirstName("Sreelipta");
        addressBook1.setLastName("Sahoo");
        addressBook1.setAddress("cda");
        addressBook1.setState("Odisha");
        addressBook1.setCity("Cuttack");
        addressBook1.setPhoneNumber("9876543210");
        addressBook1.setPinCode("765432");
        addressBookList.add(addressBook1);
        AddressBook addressBook2 = new AddressBook();
        addressBook2.setId(2);
        addressBook2.setFirstName("Simran");
        addressBook2.setLastName("Sahoo");
        addressBook2.setAddress("cda");
        addressBook2.setState("Odisha");
        addressBook2.setCity("Cuttack");
        addressBook2.setPhoneNumber("9878843210");
        addressBook2.setPinCode("665432");
        addressBookList.add(addressBook2);

        List<AddressBookDto> addressBookDtoList = new ArrayList<>();
        AddressBookDto addressBookDto1 = new AddressBookDto();
        addressBookDto1.setFirstName("Sreelipta");
        addressBookDto1.setLastName("Sahoo");
        addressBookDto1.setAddress("cda");
        addressBookDto1.setState("Odisha");
        addressBookDto1.setCity("Cuttack");
        addressBookDto1.setPhoneNumber("9876543210");
        addressBookDto1.setPinCode("765432");
        addressBookDtoList.add(addressBookDto1);
        AddressBookDto addressBookDto2 = new AddressBookDto();
        addressBookDto2.setFirstName("Simran");
        addressBookDto2.setLastName("Sahoo");
        addressBookDto2.setAddress("cda");
        addressBookDto2.setState("Odisha");
        addressBookDto2.setCity("Cuttack");
        addressBookDto2.setPhoneNumber("9878843210");
        addressBookDto2.setPinCode("665432");

        addressBookDtoList.add(addressBookDto2);

        when(addressRepository.findAll()).thenReturn(addressBookList);
        when(modelMapper.map(addressBookList.get(0), AddressBookDto.class)).thenReturn(addressBookDto1);
        when(modelMapper.map(addressBookList.get(1), AddressBookDto.class)).thenReturn(addressBookDto2);
        List<AddressBookDto> actualListOfAddress = addressBookService.getListOfAllAddress();
        assertEquals(2, actualListOfAddress.size());
        assertEquals(addressBookDtoList, actualListOfAddress);
    }


    @Test
    void givenEmployeePayrollDto_whenCalledAddEmployee_shouldReturnSuccessMessage() {
        String successMessage = "Address added successfully";
        AddressBookDto addressBookDto1 = new AddressBookDto();
        addressBookDto1.setFirstName("Sreelipta");
        addressBookDto1.setLastName("Sahoo");
        addressBookDto1.setAddress("cda");
        addressBookDto1.setState("Odisha");
        addressBookDto1.setCity("Cuttack");
        addressBookDto1.setPhoneNumber("9876543210");
        addressBookDto1.setPinCode("765432");
        AddressBook addressBook1 = new AddressBook();
        addressBook1.setId(1);
        addressBook1.setFirstName("Sreelipta");
        addressBook1.setLastName("Sahoo");
        addressBook1.setAddress("cda");
        addressBook1.setState("Odisha");
        addressBook1.setCity("Cuttack");
        addressBook1.setPhoneNumber("9876543210");
        addressBook1.setPinCode("765432");

        when(modelMapper.map(addressBookDto1, AddressBook.class)).thenReturn(addressBook1);
        String actualMessage = addressBookService.addAddress(addressBookDto1);
        assertEquals(successMessage, actualMessage);
        verify(addressRepository, times(1)).save(addressBook1);
    }

    @Test
    void givenAddressIdDto_whenCalledDeleteAddress_shouldReturnSuccessMessage() {
        String successMessage = "Address deleted successfully";
        int id = 1;
        AddressBookDto addressBookDto1 = new AddressBookDto();
        addressBookDto1.setFirstName("Sreelipta");
        addressBookDto1.setLastName("Sahoo");
        addressBookDto1.setAddress("cda");
        addressBookDto1.setState("Odisha");
        addressBookDto1.setCity("Cuttack");
        addressBookDto1.setPhoneNumber("9876543210");
        addressBookDto1.setPinCode("765432");

        AddressBook addressBook1 = new AddressBook();
        addressBook1.setId(1);
        addressBook1.setFirstName("Sreelipta");
        addressBook1.setLastName("Sahoo");
        addressBook1.setAddress("cda");
        addressBook1.setState("Odisha");
        addressBook1.setCity("Cuttack");
        addressBook1.setPhoneNumber("9876543210");
        addressBook1.setPinCode("765432");

        when(addressRepository.findById(id)).thenReturn(Optional.of(addressBook1));
        String actualMessage = addressBookService.deleteAddress(id);
        assertEquals(successMessage, actualMessage);
        verify(addressRepository, times(1)).delete(addressBook1);
    }

    @Test
    void givenAddressIdDto_whenCalledUpdateAddress_shouldReturnSuccessMessage(){
        int id = 1;
        ArgumentCaptor<AddressBook> employeePayrollArgumentCaptor = ArgumentCaptor.forClass(AddressBook.class);
        String successMessage = "Address updated successfully";
        AddressBookDto addressBookDto1 = new AddressBookDto();
        addressBookDto1.setFirstName("Sreelipta");
        addressBookDto1.setLastName("Sahoo");
        addressBookDto1.setAddress("cda");
        addressBookDto1.setState("Odisha");
        addressBookDto1.setCity("Cuttack");
        addressBookDto1.setPhoneNumber("9876543210");
        addressBookDto1.setPinCode("765432");


        AddressBook addressBook1 = new AddressBook();
        addressBook1.setId(1);
        addressBook1.setFirstName("Sreelipta");
        addressBook1.setLastName("Sahoo");
        addressBook1.setAddress("cda");
        addressBook1.setState("Odisha");
        addressBook1.setCity("Cuttack");
        addressBook1.setPhoneNumber("9876543210");
        addressBook1.setPinCode("765432");

        when(addressRepository.findById(id)).thenReturn(Optional.of(addressBook1));
        when(addressBookBuilder.buildAddressBook(addressBookDto1, addressBook1)).thenReturn(addressBook1);
        String actualMessage = addressBookService.updateAddress(id, addressBookDto1);
        assertEquals(successMessage, actualMessage);
        verify(addressRepository, times(1)).save(employeePayrollArgumentCaptor.capture());
        assertEquals(addressBook1.getFirstName(), employeePayrollArgumentCaptor.getValue().getFirstName());
        assertEquals(addressBook1.getLastName(), employeePayrollArgumentCaptor.getValue().getLastName());
        assertEquals(addressBook1.getAddress(), employeePayrollArgumentCaptor.getValue().getAddress());
        assertEquals(addressBook1.getCity(), employeePayrollArgumentCaptor.getValue().getCity());
        assertEquals(addressBook1.getState(), employeePayrollArgumentCaptor.getValue().getState());
        assertEquals(addressBook1.getPhoneNumber(), employeePayrollArgumentCaptor.getValue().getPhoneNumber());
        assertEquals(addressBook1.getPinCode(), employeePayrollArgumentCaptor.getValue().getPinCode());
    }

    @Test
    void givenAAddressDetails_whenUpdateAddressIsCalled_shouldThrowExceptionMessage() {
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFirstName("Sreelipta");
        addressBookDto.setLastName("Sahoo");
        addressBookDto.setAddress("cda");
        addressBookDto.setState("Odisha");
        addressBookDto.setCity("Cuttack");
        addressBookDto.setPhoneNumber("9876543210");
        addressBookDto.setPinCode("765432");

        when(addressRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(AddressBookCustomException.class, () -> addressBookService.updateAddress(id, addressBookDto));
    }
}
