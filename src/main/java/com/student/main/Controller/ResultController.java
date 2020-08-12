package com.student.main.Controller;


import com.student.main.Model.Marksheet;
import com.student.main.Model.Result;
import com.student.main.Service.ResultService;
import com.student.main.helper.ShowPdfResult;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ResultController {

@Autowired
ResultService resultService;

    @PostMapping("/uploadexcel")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file ) {
        try {
            List<Result>      rlist = resultService.saveMultipleResult(file);
            System.out.println("xxxxx"+rlist.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
     return "file uploaded successfully";
    }



    @GetMapping(value = "/student/result", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> ShowAllStudentResult() throws IOException {
        List<Result> resultList = (List<Result>) resultService.GetAllStudentResult();
        ByteArrayInputStream bis = ShowPdfResult.ResultReport(resultList);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=resultsreport.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }



    @GetMapping(value = "/student/result/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> ShowOneStudentResult(@PathVariable("id") int id ) throws IOException {
     List<Result> resultList =  resultService.GetOneStudentResult(id);

        ByteArrayInputStream bis = ShowPdfResult.ResultReport(resultList);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", "inline; filename=oneStudentResult.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }



    @GetMapping(value = "/marksheet", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Marksheet> getStudentsMarksheet() {
        List<Marksheet> marksheetList = resultService.GetAllStudentResultMarksheet();
        return marksheetList;
    }




}

