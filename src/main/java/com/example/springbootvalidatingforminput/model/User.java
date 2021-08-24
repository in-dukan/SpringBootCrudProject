package com.example.springbootvalidatingforminput.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "usersnew")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue()
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max= 20, message = "Name must be greater than 2 and less than 20 characters")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 0, message = "Age must be greater than 0")
    @Max(value = 300, message = "Age must be less than 300")
    private Integer age;

    @NotEmpty(message = "Birth time cannot be empty")
    private String birthday;

    public User(String name, Integer age, String birthday){this.name = name; this.age =age; this.birthday = birthday;}

    @Override
    public String toString(){
        return "User [id= " + id + ", name= "+ name + " ,age= " + age + " , birthday = " + birthday + "]";
    }


























}
