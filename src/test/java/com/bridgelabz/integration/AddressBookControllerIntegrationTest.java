package com.bridgelabz.integration;

import com.bridgelabz.controller.AddressBookController;
import com.bridgelabz.dto.AddressBookDto;
import com.bridgelabz.service.AddressBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AddressBookController.class)
@ActiveProfiles("test")
public class AddressBookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookService addressBookService;

    @Test
    void getListOfAddressTest() throws Exception {
        when(addressBookService.getListOfAllAddress()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/address-book/detail"))
                .andExpect(status().isOk());
    }

    @Test
    void addAddressTest() throws Exception {
        when(addressBookService.addAddress(any())).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/address-book/detail")
                .content("{\"firstName\":\"Lisa\",\"lastName\":\"Roy\",\"address\":\"cda\",\"city\":\"cuttack\"," +
                        "\"state\":\"odisha\",\"phoneNumber\":\"1234567898\",\"pinCode\":\"876543\"}\"")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void updateAddressTest() throws Exception {
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFirstName("Sreelipta");
        addressBookDto.setLastName("Sahoo");
        addressBookDto.setAddress("cda");
        addressBookDto.setState("Odisha");
        addressBookDto.setCity("Cuttack");
        addressBookDto.setPhoneNumber("9876543210");
        addressBookDto.setPinCode("765432");
        int id = 1;
        when(addressBookService.updateAddress(id, addressBookDto)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                .put("/address-book/detail/1")
                .content("{\"firstName\":\"Lisa\",\"lastName\":\"Roy\",\"address\":\"cda\",\"city\":\"cuttack\"," +
                        "\"state\":\"odisha\",\"phoneNumber\":\"1234567898\",\"pinCode\":\"876543\"}\"")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAddressTest() throws Exception {
        when(addressBookService.deleteAddress(1)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/address-book/detail/1")
                .content("{\"firstName\":\"lisa\",\"lastName\":\"roy\",\"address\":\"cda\",\"city\":\"cuttack\"," +
                        "\"state\":\"odisha\",\"phoneNumber\":\"1234567898\",\"pinCode\":\"876543\"}\"")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}
