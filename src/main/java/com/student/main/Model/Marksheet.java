package com.student.main.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Marksheet {
    private int mid;
    private int rid;
    private int sid;
    private int bangla;
    private int english;
    private int math;
    private int science;
    private int history;
    private int total;
    private String name;
    private String grade;
    private String teacher;
}

