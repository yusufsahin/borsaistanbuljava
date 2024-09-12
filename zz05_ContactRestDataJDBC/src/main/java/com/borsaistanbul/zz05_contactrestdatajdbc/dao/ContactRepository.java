package com.borsaistanbul.zz05_contactrestdatajdbc.dao;

import com.borsaistanbul.zz05_contactrestdatajdbc.dao.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
