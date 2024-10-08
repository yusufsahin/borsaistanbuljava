package com.borsaistanbul.zz05_contactrestdatajdbc.dto;

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
    private String phonenumber;
    private String email;

}
