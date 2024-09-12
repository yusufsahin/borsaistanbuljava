package com.borsaistanbul.zzo4_contactmanager.dao.impl;

import com.borsaistanbul.zzo4_contactmanager.dao.ContactRepository;
import com.borsaistanbul.zzo4_contactmanager.dao.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> findAll() {


        String sql="select * from contacts";

        return jdbcTemplate.query(sql,(rs,rowNum)->
                new Contact(rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phonenumber"),
                        rs.getString("email")));
    }
    @Override
    public Optional<Contact> findById(Long id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        try {
            Contact contact = jdbcTemplate.queryForObject(sql, new Object[]{id},
                    (rs, rowNum) -> new Contact(rs.getLong("id"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("phonenumber"),
                            rs.getString("email")));
            return Optional.ofNullable(contact);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public Contact save(Contact contact) {
        final String INSERT_SQL = "INSERT INTO contacts(firstname, lastname, phonenumber, email) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder= new GeneratedKeyHolder();

        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"});

                        ps.setString(1, contact.getFirstname());
                        ps.setString(2, contact.getLastname());
                        ps.setString(3, contact.getPhoneNumber());
                        ps.setString(4, contact.getEmail());
                        return ps;
                    }
                },keyHolder

        );
// ID'nin düzgün bir şekilde alınıp alınmadığını kontrol edin.
        if (keyHolder.getKey() == null || keyHolder.getKey().longValue() == 0) {
            throw new IllegalStateException("Insertion failed, no ID obtained.");
        }
        Long newContactId = keyHolder.getKey().longValue();
        return new Contact(newContactId,  contact.getFirstname(), contact.getLastname(), contact.getPhoneNumber(), contact.getEmail());

    }

    @Override
    public void update(Contact contact) {
        String sql="UPDATE contacts SET firstname=?, lastname=?, phoneNumber=?, email=? WHERE id=?";
        jdbcTemplate.update(sql,contact.getFirstname(),contact.getLastname(),
                contact.getPhoneNumber(),contact.getEmail(),contact.getId());

    }

    @Override
    public void delete(Long id) {
        String sql="delete from contacts where id=?";
        jdbcTemplate.update(sql,id);
    }


    /*
    private List<Contact> contacts= new ArrayList<>();
    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Contact findById(Long id) {
        return contacts.stream().filter(
                contact -> contact.getId()
                        .equals(id))
                        .findFirst()
                        .orElse(null);
    }

    @Override
    public void save(Contact contact) {
        Contact existingContact = findById(contact.getId());
        if (existingContact == null) {
            contacts.add(contact);
        }else
        {
            existingContact.setFirstname(contact.getFirstname());
            existingContact.setLastname(contact.getLastname());
            existingContact.setPhoneNumber(contact.getPhoneNumber());
            existingContact.setEmail(contact.getEmail());

        }

    }

    @Override
    public void delete(Long id) {
        contacts.removeIf(contact -> contact.getId().equals(id));
    }*/
}
