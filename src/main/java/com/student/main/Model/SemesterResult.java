package com.student.main.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Immutable
@Table(name = "semesterresult")

public class SemesterResult {
    @Id
    @Column(name = "roll", updatable = false, nullable = false)
    private int roll;
    private String studentName;
    private String department;
    private String subjectName;
    private String semester;
    private int marks;
    private int gpa;
    private String status;
    private String teacherName;
}

