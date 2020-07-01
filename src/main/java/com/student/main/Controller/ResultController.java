package com.student.main.Controller;


import com.student.main.Model.Result;
import com.student.main.Service.ResultService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ResultController {

@Autowired
ResultService resultService;

    @PostMapping("/result")
    public void uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file ) {
            resultService.saveResult(file);

    }

}

