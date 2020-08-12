package com.student.main.Model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Results {
    @Id
    private int rid;
    private int marks;
    private int gpa;
    private String status;
    private String teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "sid", referencedColumnName = "sid")
    })
    private Students students;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "subid", referencedColumnName = "subid")
    })
    private Subjects subjects;


}

