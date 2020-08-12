package com.student.main.Controller;

import com.student.main.Exception.RecordNotFoundException;
import com.student.main.Model.SemesterResult;
import com.student.main.Repository.SemesterResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SemesterResultController {

    @Autowired
    SemesterResultRepository  sr;

    @GetMapping(value = "/semester/result", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SemesterResult> getAllResult() {
        List<SemesterResult> slist = sr.GetAllStudentSemesterResult();
        return slist;
    }




    @GetMapping(value = "/semester/resultjdbc", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SemesterResult> getAllResultbyJdbc() {
        List<SemesterResult> slistJdbc = sr.GetAllStudentSemesterResultJdbc();
        return slistJdbc;
    }






    @GetMapping(value = "/semester/result/{rid}")
    public List<SemesterResult> getSemesterResultById (@PathVariable("rid") int rid)
    {
       List< SemesterResult>  semesterResult = sr.GetOneStudentSemesterResult(rid);
           return  semesterResult ;

    }



}
