package com.borsaistanbul.zzo4_contactmanager.data;

import com.borsaistanbul.zzo4_contactmanager.dao.ContactRepository;
import com.borsaistanbul.zzo4_contactmanager.dao.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ContactData implements CommandLineRunner {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactData(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        contactRepository.save(new Contact(1L, "John", "Doe", "123-456-7890","john@doe.com"));
        contactRepository.save(new Contact(2L, "Jane", "Doe", "123-456-7891","jane@doe.com"));

    }
}
