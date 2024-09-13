package com.borsaistanbul.zz06_projectmanagement.dao.model;


import com.borsaistanbul.zz06_projectmanagement.dao.model.common.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collection;

@Entity

//indexes = {@Index(name = "idx_username", columnList = "username")},uniqueConstraints={@UniqueConstraint(columnNames={"username"}),@UniqueConstraint(columnNames={"email"})}
@Table(name = "Users",uniqueConstraints = {
        @UniqueConstraint(name = "UniqueUsername", columnNames = {"username"}),
        @UniqueConstraint(name = "UniqueEmail", columnNames = {"email"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "Username",unique = true)
    private String username;

    @NonNull
    @Column(name = "Pwd")
    private String password;
    // private byte[] passwordSalt;


    @NonNull
    @Column(name = "Email",unique = true)
    private String email;
    @Column(name = "FirstName")
    private String firstname;
    @Column(name = "LastName")
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Collection<Role> roles;

}
