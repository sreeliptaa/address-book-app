package com.bridgelabz.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Purpose: To configure model mapper
 *
 * @author: SREELIPTA
 * @since: 2021-12-14
 */
@Configuration
public class AddressBookConfiguration {

    /**
     * Purpose : Creating instance of Model mapper to map objects and entities.
     *
     * @return : Returns a new model mapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
