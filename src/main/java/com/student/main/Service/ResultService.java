package com.student.main.Service;

import com.student.main.Model.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public interface ResultService  {

     public List<Result> saveMultipleResult (MultipartFile file) throws IOException;

     public List<Result> GetAllStudentResult();

     public List<Result> GetOneStudentResult(int id);

}
