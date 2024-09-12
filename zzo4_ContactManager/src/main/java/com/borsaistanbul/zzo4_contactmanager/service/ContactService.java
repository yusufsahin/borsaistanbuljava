package com.borsaistanbul.zzo4_contactmanager.service;

import com.borsaistanbul.zzo4_contactmanager.dto.ContactDTO;

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
