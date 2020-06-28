package com.student.main.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private  int id ;
    @NotBlank(message = "name should  not be empty")
    public String name;
    private String department;
    @Min(value = 100, message = "Tution Fee should not be less than 100")
    @Max(value = 1000, message = "Tution Fee should not be greater than 1000")
    private  int tutionFee;
    @Past
    private Date birthDate ;
}

