package com.student.main.Repository;

import com.student.main.Model.Result;
import com.student.main.Service.ResultService;
import com.student.main.helper.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Repository
public class ResultRepository  implements ResultService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void  saveResult(MultipartFile file) {

        List<Result> ResultList = null;
        try {
            ResultList = ExcelHelper.parseExcelFile(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sql = "insert into resultdb(id, name, gpa,grade) values(?,?,?,?)";

//        jdbcTemplate.update(sql, new Object[]{ResultList.getId(), ResultList.getName(), ResultList.getGpa(), ResultList.getGrade()});


    }
}
