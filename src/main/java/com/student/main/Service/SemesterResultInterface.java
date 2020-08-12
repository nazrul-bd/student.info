package com.student.main.Service;
import org.springframework.data.rest.core.annotation.RestResource;
import com.student.main.Model.SemesterResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



@RestResource
public interface SemesterResultInterface extends JpaRepository<SemesterResult, Integer> {



}
