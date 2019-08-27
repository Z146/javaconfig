package com.zhou.mappers;

import com.zhou.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 10543
 */
@Mapper
@Repository
public interface StudentMapper  {

    /**
     * 通过id 查询 Student
     * @param id id
     * @return Student
     */
    Student findById(Integer id);

    /**
     * 查询所有学生
     * @return Student 对象的list集合
     */
    List<Student> findAll();

    /**
     * 添加
     * @param student 学生信息
     */
    void save(Student student);

    /**
     * 通过id 删除学生信息
     * @param id id
     */
    void deleteById(Integer id);

    /**
     * 删除全部
     */
    void deleteAll();

    /**
     * 更新
     * @param student 学生信息
     */
    void update(Student student);
}
