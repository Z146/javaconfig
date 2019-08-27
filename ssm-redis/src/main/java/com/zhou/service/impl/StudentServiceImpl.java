package com.zhou.service.impl;

import com.zhou.domain.Student;
import com.zhou.mappers.StudentMapper;
import com.zhou.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);
    private StudentMapper studentMapper;
    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    @Cacheable(value = "cache",key = "#id.toString()")
    public String testCache(Integer id){
        logger.info("执行了方法 testCache()....");
        studentMapper.findById(id);
        return "OK";
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public String save(Student student) {
        studentMapper.save(student);
        return "OK";
    }

    @Override
    public void deleteById(Integer id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void deleteAll() {
        studentMapper.deleteAll();
    }


    @Override
    public String update(Student student) {
        studentMapper.update(student);
        return "OK";
    }
}
