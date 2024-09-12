package com.borsaistanbul.zzo4_contactmanager.controller;

import com.borsaistanbul.zzo4_contactmanager.dto.ContactDTO;
import com.borsaistanbul.zzo4_contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String getAllContacts(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("contact", new ContactDTO());
        return "add-edit";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id).orElseThrow());
        return "add-edit";
    }

    @PostMapping("/save")
    public String saveContact(@ModelAttribute("contact") ContactDTO contactDTO) {
        if (contactDTO.getId() == null) {
            contactService.createContact(contactDTO);
        } else {
            contactService.updateContact(contactDTO.getId(), contactDTO);
        }
        return "redirect:/contacts";
    }

    @GetMapping("/{id}")
    public String viewContact(@PathVariable Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id).orElseThrow());
        return "view";
    }

    @PostMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }
}
