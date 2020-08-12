package com.student.main.Model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {
    @Id
    private int subid;
    private  String name ;
    private String department;
    private  String semester;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")
    private Teachers teachers;

}
