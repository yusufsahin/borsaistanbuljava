package com.borsaistanbul.zzo4_contactmanager.dao;

import com.borsaistanbul.zzo4_contactmanager.dao.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {
    List<Contact> findAll();
    Optional<Contact> findById(Long id);
    Contact save(Contact contact);
    void update(Contact contact);
    void delete(Long id);
}
