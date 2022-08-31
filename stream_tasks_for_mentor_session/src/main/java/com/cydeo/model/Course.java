package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    private Integer id;
    private String name;
    private Integer duration; //duration in hour.
}
