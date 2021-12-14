package com.bridgelabz.repository;

import com.bridgelabz.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose : To implement the interface which extends database operations
 *
 * @author SREELIPTA
 * @since 10-12-2021
 */

public interface AddressRepository extends JpaRepository<AddressBook, Integer> {

}
