package com.planmypooja.contactapi.repo;

import com.planmypooja.contactapi.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/***
 Author: Ambuj
 Date: 17 Nov. 2024
 */

@Repository
public interface ContactRepo extends JpaRepository<Contact, String> {
    Optional<Contact> findById(String id);
}
