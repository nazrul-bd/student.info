package com.student.main.Data;


import com.student.main.Model.Student;
import com.student.main.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DataLoader {


    @Autowired
    Service service;

    //method invoked during the startup
//    @PostConstruct
//    public void loadData() {
//        service.saveStudent( new Student(1, "hasan", "english", 600,
//                new java.util.Date(System.currentTimeMillis())));
//    }

    //method invoked during the shutdown
//    @PreDestroy
//    public void removeData() {
//        userRepository.deleteAll();
//    }

}