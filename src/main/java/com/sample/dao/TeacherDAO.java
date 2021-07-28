package com.sample.dao;

import com.sample.entity.Teacher;

import java.util.List;

/**
 * Created by Kalana on 28/07/2021
 */

public interface TeacherDAO {

    List<Teacher> getTeachers();
    Teacher getTeacherById(int id);
    void deleteTeacher(int id);
    void saveOrUpdate(Teacher teacher);

}
