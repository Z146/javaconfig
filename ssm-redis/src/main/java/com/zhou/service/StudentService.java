package com.zhou.service;

import com.zhou.domain.Student;

import java.util.List;

public interface StudentService {

    String testCache(Integer id);

    Student findById(Integer id);

    List<Student> findAll();

    String save(Student student);

    void deleteById(Integer id);

    void deleteAll();

    String update(Student student);
}
