package com.borsaistanbul.zz05_contactrestdatajdbc.service;

import com.borsaistanbul.zz05_contactrestdatajdbc.dto.ContactDTO;

import java.util.List;
import java.util.Optional;

public interface ContactService {
   // String getContactsAsString();

    List<ContactDTO> getAllContacts();
    Optional<ContactDTO> getContactById(Long id);
    ContactDTO createContact(ContactDTO contactDTO);
    ContactDTO updateContact(Long id, ContactDTO contactDTO);
    void deleteContact(Long id);
}
