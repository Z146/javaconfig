package com.zhou.mappers;

import com.zhou.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper  {


    Student findById(Integer id);

    List<Student> findAll();

    void save(Student student);

    void deleteById(Integer id);

    void deleteAll();

    void update(Student student);
}
