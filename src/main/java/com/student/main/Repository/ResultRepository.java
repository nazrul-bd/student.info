package com.student.main.Repository;

import com.student.main.Model.Result;
import com.student.main.Service.ResultService;
import com.student.main.helper.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResultRepository  implements ResultService {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Result> saveMultipleResult(MultipartFile file) throws IOException {
        List<Result>     ResultList = ExcelHelper.parseExcelFile(file.getInputStream());
        String sql = "insert into resultdb(id, name, gpa,grade) values(?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Result result = ResultList.get(i);
            preparedStatement.setInt(1, result.getId());
            preparedStatement.setString(2,result.getName());
            preparedStatement.setInt(3,result.getGpa());
            preparedStatement.setString(4,result.getGrade());
            }
            @Override
            public int getBatchSize() {
                return ResultList.size();
            }
        });

        return  ResultList;
    }



}
