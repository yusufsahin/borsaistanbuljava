package com.borsaistanbul.zz05_contactrestdatajdbc.service.impl;
import com.borsaistanbul.zz05_contactrestdatajdbc.dao.ContactRepository;
import com.borsaistanbul.zz05_contactrestdatajdbc.dao.model.Contact;
import com.borsaistanbul.zz05_contactrestdatajdbc.dto.ContactDTO;
import com.borsaistanbul.zz05_contactrestdatajdbc.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ContactDTO> getAllContacts() {

      return StreamSupport.stream(
              contactRepository.findAll().spliterator(),false)
              .map(contact -> modelMapper.map(contact,ContactDTO.class))
              .collect(Collectors.toList());

    }



    @Override
    public Optional<ContactDTO> getContactById(Long id) {

        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(this::convertToDTO);
    }

    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = convertToModel(contactDTO);
        Contact savedContact = contactRepository.save(contact);
        return convertToDTO(savedContact);
    }

    @Override
    public ContactDTO updateContact(Long id, ContactDTO contactDTO) {

        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            Contact updatedContact = existingContact.get();
            updatedContact.setFirstname(contactDTO.getFirstname());
           updatedContact.setLastname(contactDTO.getLastname());
            updatedContact.setPhonenumber(contactDTO.getPhonenumber());
            updatedContact.setEmail(contactDTO.getEmail());
            contactRepository.save(updatedContact);
            return convertToDTO(updatedContact);
        }else {
            throw new IllegalArgumentException("Contact not found with id: " + id);

        }

    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);

    }

    private ContactDTO convertToDTO(Contact contact) {
        return modelMapper.map(contact, ContactDTO.class);
    }

    private Contact convertToModel(ContactDTO contactDTO) {
        return modelMapper.map(contactDTO, Contact.class);
    }
/*
    @Override
    public String getContactsAsString() {

        List<Contact> contacts= contactRepository.findAll();

        StringBuilder sb = new StringBuilder();
        sb.append("ID    | First Name | Last Name | Phone Number| Email\n");
        sb.append("----------------------------------------------------\n");
        for (Contact contact : contacts) {
            sb.append(contact.getId()).append(" | ")
            .append(contact.getFirstname()).append(" | ")
                    .append(contact.getLastname()).append(" | ")
                    .append(contact.getPhoneNumber()).append(" | ")
                    .append(contact.getEmail()).append("\n")
                    .append("----------------------------------------------------\n");

        }
        return sb.toString();
    }
    */

}
