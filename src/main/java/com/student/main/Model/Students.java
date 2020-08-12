package com.student.main.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Students {
    @Id
    private  int sid ;
    private  String name ;
    private  String department;
    private  int phone ;
    private  String address ;
    private  String semester;

}
