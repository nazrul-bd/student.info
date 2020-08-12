package com.student.main.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teachers {
    @Id
    private int tid;
    private String name;
    private String department;
    private String subject;
    private String semester;


}
