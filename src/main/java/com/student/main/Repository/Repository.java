package com.student.main.Repository;

import com.student.main.Model.Student;
import com.student.main.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@org.springframework.stereotype.Repository
public class Repository  implements Service {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveStudent(Student student) {

        String sql = "INSERT INTO studentinfo (id,name,department, tutionfee,birthdate) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{student.getId(), student.getName(), student.getDepartment(), student.getTutionFee()
                , student.getBirthDate()});
    }

    @Override
    public void updateStudent(Student student) {

        String sql = "UPDATE studentinfo SET name =?, department=?, tutionfee=?,birthdate=? where id = ?";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getDepartment(), student.getTutionFee()
                , student.getBirthDate(), student.getId()});
    }

    @Override
    public void deleteStudent(int id) {

        String sql = "DELETE FROM studentinfo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Student> getAllStudent() {

        String sql = "SELECT * FROM studentinfo";
        List<Student> lisStudent = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Student.class));
        return lisStudent;

    }

    @Override
    public Student getone(int id) {
        String sql = "SELECT * FROM studentinfo WHERE id = ?";
        Object[] args = {id};
        Student s = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Student.class));
        return s;

    }
}
