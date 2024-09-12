package com.borsaistanbul.zzo4_contactmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;

}
