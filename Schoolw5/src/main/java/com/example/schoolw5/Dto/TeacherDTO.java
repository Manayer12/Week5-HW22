package com.example.schoolw5.Dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Valid
public class TeacherDTO {

    private Integer teacher_id;
    private String area;
    private String street;
    private Integer buildingNumber;
}
