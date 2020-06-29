package com.student.main.Service;

import com.student.main.Model.StudentResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public interface ResultService  {

    public void save (MultipartFile file) ;

    public ByteArrayInputStream load();

    public List<StudentResult> getAllStudentResult();
}
