package com.student.main.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;





@Service
public interface ResultService  {

     public void saveResult (MultipartFile file);


}
