package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private UserState state;

}