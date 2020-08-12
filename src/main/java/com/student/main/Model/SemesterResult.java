package com.student.main.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Immutable
//@Subselect("select s.sid as \"Roll\" , s.name as \"Student_Name\", s.department, sub.name as \"Subject_Name\",\n" +
//        "sub.semester , r.marks, r.gpa, r.status, t.name as \"Teacher_Name\"\n" +
//        "from results  r \n" +
//        "JOIN students s on r.sid= s.sid \n" +
//        "JOIN subjects sub on r.subid= sub.subid\n" +
//        "JOIN teachers t  on sub.tid = t.tid ")



@Subselect("select s.sid as \"Roll\" , s.name as \"Student_Name\", s.department, sub.name as \"Subject_Name\",\n" +
        "sub.semester , r.marks, r.gpa, r.status, case when  r.marks <40 then t.name else '' end as \"Teacher_Name\"" +
        "from results  r \n" +
        "JOIN students s on r.sid= s.sid \n" +
        "JOIN subjects sub on r.subid= sub.subid\n" +
        "JOIN teachers t  on sub.tid = t.tid ")
public class SemesterResult {
    @Id
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

