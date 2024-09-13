package com.borsaistanbul.zz06_projectmanagement.dao.model;

import com.borsaistanbul.zz06_projectmanagement.dao.model.common.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collection;

@SuppressWarnings("serial")
@Entity

@Table(name = "Roles",uniqueConstraints = {
        @UniqueConstraint(name = "UniqueRoleName", columnNames = {"name"})})
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Role extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name="Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Description")
    private String description;

    @ManyToMany(mappedBy="roles")
    private Collection<User> users;
}
