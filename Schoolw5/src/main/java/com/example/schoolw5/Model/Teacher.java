package com.example.schoolw5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Integer id;
@Column(columnDefinition = "varchar(20) not null")
    private String name;
@Column(columnDefinition = "int not null")
    private Integer age;
    @Column(columnDefinition = "varchar(20) not null")
    @Email
    private String Email;


    @Column(columnDefinition = "int not null")
    private Integer Salary;


    @OneToOne(cascade =CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    Address address;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courseset;
}
