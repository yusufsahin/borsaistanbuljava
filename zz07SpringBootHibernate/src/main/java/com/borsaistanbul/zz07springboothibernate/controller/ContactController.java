package com.borsaistanbul.zz07springboothibernate.controller;

import com.borsaistanbul.zz07springboothibernate.dao.ContactRepository;
import com.borsaistanbul.zz07springboothibernate.dao.model.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactRepository contactRepository = new ContactRepository();

    @PostMapping
    public String createContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return "Contact created successfully";
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactRepository.getContactById(id);
    }

    @PutMapping("/{id}")
    public String updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        contactRepository.updateContact(contact);
        return "Contact updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactRepository.deleteContact(id);
        return "Contact deleted successfully";
    }
}
