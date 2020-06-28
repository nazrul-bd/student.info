package com.student.main.Controller;

import com.student.main.Exception.RecordNotFoundException;
import com.student.main.Model.Student;
import com.student.main.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {


    @Autowired
    Service service;



    @PostMapping(value = "/save")
    public ResponseEntity<Student> addStudent (@Valid @RequestBody Student student)
    {
        service.saveStudent(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }




    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        List<Student> slist = service.getAllStudent();
        return slist;
    }




    @PutMapping(value = "/update")
    public Student updateStudent(@RequestBody Student student) {
        service.updateStudent(student);
        return student;
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") int id) {
        try {
            service.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }




    @GetMapping(value = "/search/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable("id") int id)
    {
        Student student = service.getone(id);
        if(student == null) {
            throw new RecordNotFoundException("Invalid Student id : " + id);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }



}
