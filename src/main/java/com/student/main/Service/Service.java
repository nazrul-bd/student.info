package com.student.main.Service;


import com.student.main.Model.Student;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service  {

    public void saveStudent(Student student);

    public void updateStudent(Student student);

    public void deleteStudent(int id);

    List<Student> getAllStudent();

    public  Student getone(int id) ;

}
