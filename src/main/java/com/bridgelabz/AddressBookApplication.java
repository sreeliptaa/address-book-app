package com.bridgelabz;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Purpose : To simulate Address Book System
 *
 * @author : SREELIPTA
 * @since : 14-12-2021
 */
@SpringBootApplication
public class AddressBookApplication {

	/**
	 * Purpose : Creating instance of Model mapper to map objects and entities.
	 *
	 * @return : Returns a new model mapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {

		SpringApplication.run(AddressBookApplication.class, args);
	}

}
