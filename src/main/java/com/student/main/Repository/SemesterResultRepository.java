package com.student.main.Repository;

import com.student.main.Model.SemesterResult;
import com.student.main.Service.SemesterResultInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterResultRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

      @Autowired
    SemesterResultInterface sr;

    public List<SemesterResult> GetAllStudentSemesterResult(){
        List<SemesterResult> semesterResults= sr.findAll();
        return   semesterResults;
    }



    public List<SemesterResult> GetAllStudentSemesterResultJdbc(){
        String sql = "select s.sid as \"Roll\" , s.name as \"Student_Name\", s.department, sub.name as \"Subject_Name\",\n" +
                "sub.semester , r.marks, r.gpa, r.status, case when  r.marks <40 then t.name else '' end as \"Teacher_Name\"" +
                "from results  r \n" +
                "JOIN students s on r.sid= s.sid \n" +
                "JOIN subjects sub on r.subid= sub.subid\n" +
                "JOIN teachers t  on sub.tid = t.tid ";
        List<SemesterResult> resultList = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(SemesterResult.class));
        return resultList;
    }



    public List<SemesterResult> GetOneStudentSemesterResult(int rid) {
        String sql = "select s.sid as \"Roll\" , s.name as \"Student_Name\", s.department, sub.name as \"Subject_Name\",\n" +
                "sub.semester , r.marks, r.gpa, r.status, t.name as \"Teacher_Name\"\n" +
                "from results  r \n" +
                "JOIN students s on r.sid= s.sid \n" +
                "JOIN subjects sub on r.subid= sub.subid\n" +
                "JOIN teachers t  on sub.tid = t.tid  where s.sid= ? ";

        Object[] args = {rid};
        List<SemesterResult> oneResult = jdbcTemplate.query(sql, args,
                BeanPropertyRowMapper.newInstance(SemesterResult.class));
        return oneResult;
    }











}
