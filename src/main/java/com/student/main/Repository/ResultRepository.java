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
    public List<Result>  saveResult(MultipartFile file ) throws IOException {

        List<Result>     ResultList = ExcelHelper.parseExcelFile(file.getInputStream());
        String sql = "insert into resultdb(id, name, gpa,grade) values(?,?,?,?)";


        jdbcTemplate.update(sql, new Object[]{ResultList.get(0).getId(), ResultList.get(0).getName(), ResultList.get(0).getGpa(), ResultList.get(0).getGrade()});


        return  ResultList ;

    }
}
