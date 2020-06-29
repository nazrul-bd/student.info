package com.student.main.Model;


import lombok.*;

import java.io.Serializable;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResult implements Serializable {
    private  int id;
    private  String name;
    private  double bangla;
    private  double english;
    private  double math;
    private  double gpa;
    private String grade;
}
